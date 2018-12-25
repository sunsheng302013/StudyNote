/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cq.common.annotation.DFDatasourceSwitcher;
import com.cq.common.annotation.DbTable;
import com.cq.common.base.IdWorkerUtil;
import com.cq.common.base.PageInfo;
import com.cq.common.enums.ResultCode;
import com.cq.common.enums.excel.ExportUserHeaders;
import com.cq.common.enums.user.LeaderAndeSubordinateEnum;
import com.cq.common.enums.user.UserCategoryEnum;
import com.cq.common.enums.user.UserIdCardEnum;
import com.cq.common.enums.user.UserJobCategoryEnum;
import com.cq.common.enums.user.UserSexEnum;
import com.cq.common.enums.user.UserStatusEnum;
import com.cq.common.exception.ServiceException;
import com.cq.common.utils.DateUtils;
import com.cq.common.utils.ExportExcelUtils;
import com.cq.common.utils.IdCardValidator;
import com.cq.common.utils.ListUtils;
import com.cq.dao.file.FileDao;
import com.cq.dao.user.UserDao;
import com.cq.dao.user.UserLeaderInfoDao;
import com.cq.dao.user.UserSpecialDao;
import com.cq.dto.ExportExcelDTO;
import com.cq.dto.user.UserBaseResultDTO;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserExportDTO;
import com.cq.dto.user.UserIdCardDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.dto.user.UserTransferQueryDTO;
import com.cq.dto.user.UserTransferResultDTO;
import com.cq.dto.user.UserUpdateBatchDTO;
import com.cq.model.file.File;
import com.cq.model.user.UserLog;
import com.cq.service.user.UserIdCardAnalyzeService;
import com.cq.service.user.UserLogService;
import com.cq.service.user.UserService;

/**
 * <p>
 * 类描述:人员档案基本信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
@Service
public class UserServiceImpl implements UserService {

    private static final int RESULT_INITIAL_SIZE = 10;
    private static final int ROW_INITIAL_SIZE = 20;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserIdCardAnalyzeService userIdCardAnalyzeService;

    @Autowired
    private UserLeaderInfoDao userLeaderInfoDao;

    @Autowired
    private UserSpecialDao userSpecialDao;

    @Autowired
    private FileDao fileDao;

    @Autowired
    private UserLogService userLogService;

    private static final String EDUCATION = "j_oa_user_education_info";
    private static final String SPECIAL = "j_oa_user_special";
    private static final String LEADER = "j_oa_user_leader_info";
    private static final String LABOURCONTRACT = "j_oa_user_labour_contract";

    @Override
    @DFDatasourceSwitcher
    // @Transactional(rollbackFor = Exception.class)
    public List<UserDTO> list(UserQueryDTO userQueryDto, PageInfo page) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer isHaveEducation = checkIsHaveTable(userQueryDto, EDUCATION);
        Integer isHaveSpecial = checkIsHaveTable(userQueryDto, SPECIAL);
        Integer isHaveLeader = checkIsHaveTable(userQueryDto, LEADER);
        Integer isHaveLabourContract = checkIsHaveTable(userQueryDto, LABOURCONTRACT);
        map.put("isHaveEducation", isHaveEducation);
        map.put("isHaveSpecial", isHaveSpecial);
        map.put("isHaveLeader", isHaveLeader);
        map.put("isHaveLabourContract", isHaveLabourContract);
        map.put("userQueryDto", userQueryDto);
        // 根据条件查询符合条件的人员ID列表
        List<Long> userIdList = userDao.listCount(map);
        page.setTotal(userIdList.size());
        List<UserDTO> userDtoList = new ArrayList<UserDTO>();
        if (ListUtils.isNotEmpty(userIdList)) {
            userQueryDto.setUserIdList(userIdList);
            userDtoList = userDao.list(page, userQueryDto);
        }
        return userDtoList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @DFDatasourceSwitcher
    public List<UserDTO> getUser(Long userId) {
        List<UserDTO> userDtoList = userDao.getUser(userId);
        return userDtoList;
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public UserBaseResultDTO get(Long userId) {
        UserBaseResultDTO userBaseResuleDto = userDao.get(userId);
        if (null != userBaseResuleDto) {
            userBaseResuleDto.setSexName(UserSexEnum.getMsgByCode(userBaseResuleDto.getSex()));
        }
        return userBaseResuleDto;
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public UserIdCardDTO selectUser(String idCardNo) {
        idCardNo = idCardValidator(idCardNo);
        return userIdCardAnalyzeService.getUser(idCardNo);
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public Long save(UserDTO userDto) {
        UserLog userLog = new UserLog();
        Integer index = null;
        idCardValidator(userDto);
        // 根据传来的userId判断操作类型是新增还是修改
        if (null == userDto.getUserId()) {
            userDto.setOperatorType(0);
            userDto.setUserId(IdWorkerUtil.getId());
            userLog.setLogDetail("新建人员档案基本信息");
            if (ListUtils.isNotEmpty(userDto.getFileList())) {
                userDto.setFileId(IdWorkerUtil.getId());
            }
            index = userDao.insert(userDto);
        } else {
            userDto.setOperatorType(1);
            userLog.setLogDetail("修改人员档案基本信息");
            if (ListUtils.isNotEmpty(userDto.getFileList()) && null == userDto.getFileId()) {
                userDto.setFileId(IdWorkerUtil.getId());
            }
            index = userDao.update(userDto);
            userLeaderInfoDao.deleteByUserId(userDto.getUserId());
            userSpecialDao.deleteByUserId(userDto.getUserId());
            fileDao.deleteByForeignId(userDto.getFileId());
        }
        // 新增或修改不成功时，返回null
        if (null == index) {
            return null;
        }
        // 保存上下级人员
        if (ListUtils.isNotEmpty(userDto.getLeaderAndSubordinate())) {
            userDto.getLeaderAndSubordinate().stream().filter(x -> x.getRelation() != null && !"".equals(x.getRelation()))
                    .forEach(x -> x.setType(LeaderAndeSubordinateEnum.getCodeByMsg(x.getRelation())));
            userLeaderInfoDao.insert(userDto.getUserId(), userDto.getLeaderAndSubordinate());
        }
        // 保存员工特长
        if (ListUtils.isNotEmpty(userDto.getUserSpecialList())) {
            userSpecialDao.insert(userDto.getUserId(), userDto.getUserSpecialList());
        }
        // 保存附件信息
        if (ListUtils.isNotEmpty(userDto.getFileList())) {
            List<File> fileList = userDto.getFileList();
            fileDao.insert(userDto.getFileId(), fileList);
        }
        userLog.setUserId(userDto.getUserId());
        userLogService.saveUserLog(userLog);
        return userDto.getUserId();
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(List<Long> userIdList) {
        Integer index = 0;
        index = userDao.fakeDelete(userIdList);
        if (index != 0 && ListUtils.isNotEmpty(userIdList)) {
            List<Long> erpUserIdList = userDao.getErpUserIdByUserId(userIdList);
            String str = StringUtils.join(erpUserIdList, ",");
            // erpService.updateStatus(str, 0);
        }
        return index;
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public String idCardValidator(String idCardNo) {
        if (!IdCardValidator.isValidatedAllIdcard(idCardNo)) {
            throw new ServiceException(ResultCode.IDCARD_IS_FAIL);
        }
        if (userDao.uniquenessCheck(idCardNo) != 0) {
            throw new ServiceException(ResultCode.IDCARD_EXIST);
        }
        if (idCardNo.length() == UserIdCardEnum.num15.getCode()) {
            idCardNo = IdCardValidator.convertIdcarBy15bit(idCardNo);
        }
        return idCardNo;
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public String idCardValidator(UserDTO userDto) {
        String idCardNo = userDto.getIdCardNo();
        if (!IdCardValidator.isValidatedAllIdcard(idCardNo)) {
            throw new ServiceException(ResultCode.IDCARD_IS_FAIL);
        }
        if (userDao.uniquenessCheckExceptOneSelf(userDto) != 0) {
            throw new ServiceException(ResultCode.IDCARD_EXIST);
        }
        if (idCardNo.length() == UserIdCardEnum.num15.getCode()) {
            idCardNo = IdCardValidator.convertIdcarBy15bit(idCardNo);
        }
        return idCardNo;
    }

    /**
     * 设置用户动态信息-年龄，司龄，社会工作年限
     *
     * @param userDto
     *            用户信息
     * @return userDto
     */
    public UserDTO setDynamicUserInfo(UserDTO userDto) {
        // 计算年龄，年龄和身份证上面不一定相同，以填写的生日为准
        if (userDto.getBirthdate() != null) {
            userDto.setAge((int) DateUtils.getUnitlYear(userDto.getBirthdate()));
        }
        // 计算司龄,保留两位小数
        if (userDto.getEntryDate() != null) {
            userDto.setEntryAge(DateUtils.getUnitlYear(userDto.getEntryDate()));
        }
        // 计算社会工作年限,保留两位小数
        if (userDto.getStartworkDate() != null) {
            userDto.setSocialAge(DateUtils.getUnitlYear(userDto.getStartworkDate()));
        }
        return userDto;
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public Integer updateBatch(UserUpdateBatchDTO userUpdateBatchDto) {
        if (ListUtils.isEmpty(userUpdateBatchDto.getUserIds())) {
            return null;
        }
        userLeaderInfoDao.deleteParentPosition(userUpdateBatchDto.getUserIds());
        // 修改上级人员
        if (ListUtils.isNotEmpty(userUpdateBatchDto.getParentPosition())) {
            userLeaderInfoDao.insertBatch(userUpdateBatchDto.getUserIds(), userUpdateBatchDto.getParentPosition());
        }
        // 修改人员状态
        return userDao.updateBatch(userUpdateBatchDto);
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public List<UserTransferResultDTO> transferList(PageInfo page, UserTransferQueryDTO userTransferQueryDto) {
        List<Long> userIdList = userDao.transferListCount(userTransferQueryDto);
        List<UserTransferResultDTO> transferList = new ArrayList<UserTransferResultDTO>();
        page.setTotal(userIdList.size());
        if (ListUtils.isNotEmpty(userIdList)) {
            userTransferQueryDto.setUserIdList(userIdList);
            transferList = userDao.transferList(page, userTransferQueryDto);
            for (UserTransferResultDTO userTransferResultDTO : transferList) {
                userTransferResultDTO.setSexName(UserSexEnum.getMsgByCode(userTransferResultDTO.getSex()));
                userTransferResultDTO.setJobCategoryName(UserJobCategoryEnum.getMsgByCode(userTransferResultDTO.getJobCategory()));
                userTransferResultDTO.setUserStatusName(UserStatusEnum.getMsgByCode(userTransferResultDTO.getUserStatus()));
                userTransferResultDTO.setUserCategoryName(UserCategoryEnum.getMsgByCode(userTransferResultDTO.getUserCategory()));
            }
        }
        return transferList;
    }

    @Override
    @DFDatasourceSwitcher
    @Transactional(rollbackFor = Exception.class)
    public List<List<Object>> export(PageInfo page, UserQueryDTO userQueryDTO, ExportExcelDTO exportExcelDTO) {
        List<String> dbNameList = exportExcelDTO.getEnName();

        // 查询出导出的数据
        List<UserDTO> list = list(userQueryDTO, page);
        List<UserExportDTO> userList = getUserExportDto(list);
        List<List<Object>> result = new ArrayList<>(RESULT_INITIAL_SIZE);
        // 获取整个EXCEL表格的数据
        for (UserExportDTO model : userList) {
            List<Object> row = new ArrayList<>(ROW_INITIAL_SIZE);
            // 比对表头名和数据库的字段名获取表格中一行的数据
            for (String name : dbNameList) {
                for (ExportUserHeaders element : ExportUserHeaders.values()) {
                    String dbName = element.getDbName();
                    // 比对成功后通过拼接字符串和反射获取到单元格的值
                    if (name.equals(dbName)) {
                        String methodName = "get" + ExportExcelUtils.toUpperCaseFirstOne(name);
                        try {
                            Method method = model.getClass().getMethod(methodName);
                            Object object = method.invoke(model);
                            row.add(object);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            result.add(row);
        }
        return result;
    }

    /**
     * @param list
     * @return
     */
    private List<UserExportDTO> getUserExportDto(List<UserDTO> list) {
        List<UserExportDTO> userExportDtoList = new ArrayList<UserExportDTO>();
        if (ListUtils.isEmpty(list)) {
            return userExportDtoList;
        }
        for (UserDTO userDTO : list) {
            UserExportDTO userExportDto = new UserExportDTO();
            BeanUtils.copyProperties(userDTO, userExportDto);
            userExportDtoList.add(userExportDto);
        }
        return userExportDtoList;
    }

    @Override
    public Integer checkIsHaveTable(UserQueryDTO userQueryDto, String tableName) {
        Integer result = 0;
        Field[] queryFields = userQueryDto.getClass().getDeclaredFields();
        Field[] queryBaseFields = userQueryDto.getClass().getSuperclass().getDeclaredFields();
        for (Field field : queryFields) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(userQueryDto);
                if (null != value && !"".equals(value)) {
                    if (!"serialVersionUID".equals(fieldName)) {
                        // 如果字段为数组，且数组长度为0 则跳过
                        if (value.getClass().isArray() && Array.getLength(value) == 0) {
                            continue;
                        }
                        DbTable dbTable = field.getAnnotation(DbTable.class);
                        if (dbTable == null) {
                            continue;
                        }
                        if (dbTable.name().equals(tableName)) {
                            return 1;
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            } finally {
                field.setAccessible(false);
            }
        }
        for (Field field : queryBaseFields) {
            try {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object value = field.get(userQueryDto);
                if (null != value && !"".equals(value)) {
                    if (!"serialVersionUID".equals(fieldName)) {
                        // 如果字段为数组，且数组长度为0 则跳过
                        if (value.getClass().isArray() && Array.getLength(value) == 0) {
                            continue;
                        }
                        DbTable dbTable = field.getAnnotation(DbTable.class);
                        if (dbTable == null) {
                            continue;
                        }
                        if (dbTable.name().equals(tableName)) {
                            return 1;
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            } finally {
                field.setAccessible(false);
            }
        }
        return result;
    }

}
