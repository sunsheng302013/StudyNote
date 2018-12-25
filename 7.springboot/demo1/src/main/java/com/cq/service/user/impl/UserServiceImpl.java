/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.common.base.IdWorkerUtil;
import com.cq.common.base.PageInfo;
import com.cq.common.enums.ResultCode;
import com.cq.common.exception.ServiceException;
import com.cq.common.utils.DateUtils;
import com.cq.common.utils.IdCardValidator;
import com.cq.common.utils.ListUtils;
import com.cq.dao.file.FileDao;
import com.cq.dao.user.UserDao;
import com.cq.dao.user.UserLeaderInfoDao;
import com.cq.dao.user.UserSpecialDao;
import com.cq.dao.user.UserSpecialInfoDao;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.dto.user.UserTransferQueryDTO;
import com.cq.dto.user.UserTransferResultDTO;
import com.cq.dto.user.UserUpdateBatchDTO;
import com.cq.model.file.File;
import com.cq.model.user.UserLog;
import com.cq.model.user.UserSpecialInfo;
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

    @Autowired
    private UserSpecialInfoDao userSpecialInfoDao;

    private static final Integer TODAY_ADD = 0;
    private static final Integer YESTERDAY_ADD = 1;
    private static final Integer WEEK_ADD = 2;
    private static final Integer MONTH_ADD = 3;

    @Override
    @DS
    public List<UserDTO> list(UserQueryDTO userQueryDto, PageInfo page) {

        // 实例化日期
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        if (userQueryDto != null) {
            if (userQueryDto.getAddType() == TODAY_ADD) {
                // 今天新增
                userQueryDto.setAddDateGte(calendar.getTime());
                calendar.add(Calendar.DATE, +1);
                userQueryDto.setAddDateLte(calendar.getTime());
            }
            if (userQueryDto.getAddType() == YESTERDAY_ADD) {
                // 昨天新增
                userQueryDto.setAddDateLte(calendar.getTime());
                calendar.add(Calendar.DATE, -1);
                userQueryDto.setAddDateGte(calendar.getTime());
            }
            if (userQueryDto.getAddType() == WEEK_ADD) {
                // 本周新增
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                userQueryDto.setAddDateGte(calendar.getTime());
            }
            if (userQueryDto.getAddType() == MONTH_ADD) {
                // 本月新增
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                userQueryDto.setAddDateGte(calendar.getTime());
            }
        }
        List<UserDTO> userDtoList = userDao.select(page, userQueryDto);
        page.setTotal(userDao.selectCount(userQueryDto));
        return userDtoList;
    }

    @Override
    @DS
    public UserDTO selectUser(UserDTO userDto) {
        idCardValidator(userDto);
        userDto = userIdCardAnalyzeService.getUser(userDto);
        return userDto;
    }

    @Override
    @DS
    public Integer save(UserDTO userDto) {
        UserLog userLog = new UserLog();
        if (null == userDto.getUserId()) {
            userDto.setUserId(IdWorkerUtil.getId());
            userLog.setLogDetail("新建人员档案");
        } else {
            userDao.delete(userDto.getUserId());
            userLog.setLogDetail("修改人员档案");
        }
        idCardValidator(userDto);
        userDto = setDynamicUserInfo(userDto);

        // 保存上下级人员
        if (ListUtils.isNotEmpty(userDto.getUserLeaderList())) {
            userLeaderInfoDao.deleteByUserId(userDto.getUserId());
            userLeaderInfoDao.insert(userDto.getParentPosition());
            userLeaderInfoDao.insert(userDto.getSubPosition());
        }
        // 保存员工特长
        if (ListUtils.isNotEmpty(userDto.getUserSpecialList())) {
            userSpecialDao.deleteByUserId(userDto.getUserId());
            userSpecialDao.insert(userDto.getUserSpecialList());
        }
        // 保存附件信息
        if (ListUtils.isNotEmpty(userDto.getFileList())) {
            if (null == userDto.getFileId()) {
                userDto.setFileId(IdWorkerUtil.getId());
            }
            fileDao.deleteByForeignId(userDto.getFileId());
            List<File> fileList = userDto.getFileList();
            Long fileId = userDto.getFileId();
            fileList.forEach(x -> x.setForeignId(fileId));
            fileDao.insert(fileList);
        }
        Integer index = userDao.insert(userDto);
        if (index == 1) {
            userLog.setUserId(userDto.getUserId());
            userLogService.saveUserLog(userLog);
        }
        return index;
    }

    @Override
    @DS
    public Integer delete(List<Long> userIdList) {
        /**
         * 删除关联表数据 userDepartInfoDao.deleteBatchByUserId(userIdList);// 1. 删除所在部门信息
         * userEducationInfoDao.deleteBatchByUserId(userIdList);// 2. 删除教育经历
         * userFamilyInfoDao.deleteBatchByUserId(userIdList); // 3. 家庭成员
         * userLabourContractDao.deleteBatchByUserId(userIdList);
         * userLabourContractInfoDao.deleteBatchByUserId(userIdList);// 4. 合同
         * userLeaderInfoDao.deleteBatchByUserId(userIdList);// 5. 上下级关系
         * userPositionInfoDao.deleteBatchByUserId(userIdList);// 6. 职位信息
         * userSkillInfoDao.deleteBatchByUserId(userIdList); // 7. 技能职称
         * userSpecialDao.deleteBatchByUserId(userIdList);// 8. 技能特长
         * userTrainInfoDao.deleteBatchByUserId(userIdList); // 9. 培训经历
         * userWorkExperienceInfoDao.deleteBatchByUserId(userIdList); // 10. 工作经历
         * userChangeInfoDao.deleteBatchByUserId(userIdList);// 11. 人事异动
         * fileDao.deleteBatchByUserId(userIdList); // 12. 附件信息
         */
        return userDao.fakeDelete(userIdList);
    }

    @Override
    @DS
    public void idCardValidator(UserDTO userDto) {
        if (!IdCardValidator.isValidatedAllIdcard(userDto.getIdCardNo())) {
            throw new ServiceException(ResultCode.IDCARD_IS_FAIL);
        }
        if (userDao.uniquenessCheck(userDto) != 0) {
            throw new ServiceException(ResultCode.CATEGORY_NAME_EXIST);
        }
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
    @DS
    public List<UserSpecialInfo> listUserSpecial() {
        return userSpecialInfoDao.listUserSpecial();
    }

    @Override
    @DS
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
    @DS
    public List<UserTransferResultDTO> transferList(UserTransferQueryDTO userTransferQueryDto) {
        return userDao.transferList(userTransferQueryDto);
    }
}
