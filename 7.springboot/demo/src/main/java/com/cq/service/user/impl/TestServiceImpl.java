/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DFDatasourceSwitcher;
import com.cq.common.annotation.DbTable;
import com.cq.common.base.PageInfo;
import com.cq.common.enums.user.UserSexEnum;
import com.cq.common.utils.ListUtils;
import com.cq.dao.user.UserTestDao;
import com.cq.dto.user.UserDTO;
import com.cq.dto.user.UserQueryDTO;
import com.cq.service.user.TestService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月28日
 * @author chengq
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserTestDao userTestDao;

    private static final String EDUCATION = "j_oa_user_education_info";
    private static final String SPECIAL = "j_oa_user_special";
    private static final String LEADER = "j_oa_user_leader_info";
    private static final String LABOURCONTRACT = "j_oa_user_labour_contract";

    @Override
    @DFDatasourceSwitcher
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
        List<Long> userIdList = userTestDao.listCount(map);
        page.setTotal(userIdList.size());
        List<UserDTO> userDtoList = new ArrayList<UserDTO>();
        if (ListUtils.isNotEmpty(userIdList)) {
            userQueryDto.setUserIdList(userIdList);
            userDtoList = userTestDao.list(page, userQueryDto);
        }
        return userDtoList;
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

    List<UserDTO> getEnumName(List<UserDTO> userDtoList) {

        for (UserDTO userDto : userDtoList) {
            userDto.setSexName(UserSexEnum.getMsgByCode(userDto.getSex()));

        }
        return userDtoList;
    }
}
