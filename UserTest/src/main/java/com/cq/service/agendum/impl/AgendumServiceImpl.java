/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.agendum.impl;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DatasourceSwitcher;
import com.cq.common.base.MemberHolder;
import com.cq.common.enums.excel.ExportAgendumHeaders;
import com.cq.common.utils.ExportExcelUtils;
import com.cq.common.utils.ListUtils;
import com.cq.dao.agendum.AgendumDao;
import com.cq.dao.user.UserInfoDao;
import com.cq.dto.ExportExcelDTO;
import com.cq.dto.agendum.AgendumQueryDTO;
import com.cq.dto.agendum.AgendumResultDTO;
import com.cq.model.user.UserInfo;
import com.cq.service.agendum.AgendumService;

/**
 * <p>
 * 类描述:查询日程
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
@Service
public class AgendumServiceImpl implements AgendumService {

    @Autowired
    private AgendumDao agendumDao;

    @Autowired
    private UserInfoDao userInfoDao;

    /** 日程开始时间 **/
    private static final String START_TIME = "getStartTime";
    /** 日程结束时间 **/
    private static final String END_TIME = "getEndTime";
    /** 重要日程 **/
    private static final String IS_IMPORTANT = "getIsImportant";
    /** 查询-其他人 2 **/
    private static final Integer OTHERS = 2;
    /** 日程权限-正常(上级可见) 1 **/
    private static final Integer ROLETYPE_NORMAL = 1;
    /** 日程权限-仅自己可见 2 **/
    private static final Integer ROLETYPE_ONESELET = 2;

    @Override
    @DatasourceSwitcher
    public List<AgendumResultDTO> listAgendumResult(AgendumQueryDTO query) {
        Long currentUserId = MemberHolder.getUserId();
        List<AgendumResultDTO> listAgendumResult = new ArrayList<AgendumResultDTO>();
        // 查询自己的日程
        if (query.getType() == 0) {
            query.setUserId(currentUserId);
        }
        // 查询下属的日程，下属为空-->返回null
        if (query.getType() == 1) {
            List<UserInfo> listSubordinate = userInfoDao.listSubordinate(currentUserId);
            if (ListUtils.isNotEmpty(listSubordinate)) {
                List<Long> userIdList = listSubordinate.stream().map(UserInfo::getUserId).collect(Collectors.toList());
                // userIdList.add(currentUserId);
                query.setUserIdList(userIdList);
            } else {
                return listAgendumResult;
            }
        }
        // 查询日程
        listAgendumResult = agendumDao.listAgendumResult(query);
        if (ListUtils.isNotEmpty(listAgendumResult)) {
            // 初始设置日程可见,不可修改
            listAgendumResult.forEach(x -> x.setIsScan(1));
            listAgendumResult.forEach(x -> x.setIsUpdate(0));

            // 1.创建人是当前登录人的日程 --> 日程为可修改状态
            listAgendumResult.stream().filter(x -> currentUserId.equals(x.getCreateUserId())).forEach(x -> x.setIsUpdate(1));
            // 2.日程为仅自己可见&&当前登录人不是日程参与人&&当前登录人不是日程创建人 --> 日程标题为空, 日程不可见
            listAgendumResult.stream().filter(x -> ROLETYPE_ONESELET.equals(x.getRoleType()) && !currentUserId.equals(x.getParticipantUserId())
                    && !currentUserId.equals(x.getCreateUserId())).forEach((x) -> {
                        x.setTitle("");
                        x.setContent("");
                        x.setIsScan(0);
                    });
            // 3.日程为上级可见&&当前登录人不是日程参与人上级&&当前登录人不是日程创建人--> 日程标题为空, 日程内容为空, 日程不可见
            // 查询个人和下属 日程标题都是不变,只有通过姓名筛选时才需要判断
            if (query.getType() == OTHERS) {
                listAgendumResult = setAgendumTitle(currentUserId, listAgendumResult);
            }
        }
        // 拼接标题 暂时不需要
        listAgendumResult = getAgendumTitle(listAgendumResult);
        return listAgendumResult;
    }

    /**
     * 日程为上级可见且当前登录人不是日程参与人上级的日程 日程标题为空
     *
     * @author chengq
     * @param currentUserId
     *            当前登录人ID
     * @param listAgendumResult
     *            日程列表
     * @return 修改后的日程
     */
    public List<AgendumResultDTO> setAgendumTitle(Long currentUserId, List<AgendumResultDTO> listAgendumResult) {
        List<UserInfo> listSubordinate = userInfoDao.listSubordinate(currentUserId);
        List<Long> userIdList = new ArrayList<Long>();
        if (ListUtils.isNotEmpty(listSubordinate)) {
            userIdList = listSubordinate.stream().map(UserInfo::getUserId).collect(Collectors.toList());
        }
        userIdList.add(currentUserId);
        // 日程为上级可见&&当前登录人不是日程参与人上级&&当前登录人不是日程创建人 --> 日程标题为空，日程不可见
        for (AgendumResultDTO agendum : listAgendumResult) {
            boolean isLeader = userIdList.contains(agendum.getParticipantUserId());
            boolean isCreateUser = currentUserId.equals(agendum.getParticipantUserId());
            if (ROLETYPE_NORMAL.equals(agendum.getRoleType()) && !isLeader && !isCreateUser) {
                agendum.setTitle("");
                agendum.setContent("");
                agendum.setIsScan(0);
            }
        }
        return listAgendumResult;
    }

    /**
     * 拼接日程显示标题
     *
     * @author chengq
     * @param listAgendumResult
     *            日程列表
     * @return 日程列表
     */
    public List<AgendumResultDTO> getAgendumTitle(List<AgendumResultDTO> listAgendumResult) {
        SimpleDateFormat formatter = new SimpleDateFormat("ahh:mm");
        for (AgendumResultDTO agendum : listAgendumResult) {
            String date = "全天";
            if (agendum.getIsWholeDay() == 0) {
                date = formatter.format(agendum.getStartTime());
            }
            String agendumTitle = date + "【" + agendum.getParticipantUserName() + "】" + agendum.getTitle();
            agendum.setAgendumTitle(agendumTitle);
        }
        return listAgendumResult;
    }

    @Override
    @DatasourceSwitcher
    public List<List<Object>> export(AgendumQueryDTO query, ExportExcelDTO exportExcelDTO) {
        List<String> dbNameList = exportExcelDTO.getEnName();
        // 查询出导出的数据
        List<AgendumResultDTO> list = listAgendumResult(query);
        List<List<Object>> result = new ArrayList<>();
        // 获取整个EXCEL表格的数据
        for (AgendumResultDTO agendumResult : list) {
            List<Object> row = new ArrayList<>();
            // 比对表头名和数据库的字段名获取表格中一行的数据
            for (String name : dbNameList) {
                for (ExportAgendumHeaders element : ExportAgendumHeaders.values()) {
                    String dbName = element.getDbName();
                    // 比对成功后通过拼接字符串和反射获取到单元格的值
                    if (name.equals(dbName)) {
                        String methodName = "get" + ExportExcelUtils.toUpperCaseFirstOne(name);
                        try {
                            Method method = agendumResult.getClass().getMethod(methodName);
                            Object object = method.invoke(agendumResult);
                            object = conversionSpecialObject(methodName, object);
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
     * 导出时特殊字段转化
     *
     * @param methodName
     *            字段名
     * @param object
     *            字段值
     * @return 转换之后的字段值
     */
    public Object conversionSpecialObject(String methodName, Object object) {
        if (START_TIME.equals(methodName) && object != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            object = formatter.format(object);
        }
        if (END_TIME.equals(methodName) && object != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            object = formatter.format(object);
        }
        if (IS_IMPORTANT.equals(methodName) && object != null) {
            if (object.equals(1)) {
                object = "是";
            } else {
                object = "否";
            }
        }
        return object;
    }

}
