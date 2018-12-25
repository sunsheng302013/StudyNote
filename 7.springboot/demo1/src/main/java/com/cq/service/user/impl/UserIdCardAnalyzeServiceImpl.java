/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.cq.common.enums.user.UserIdCardEnum;
import com.cq.dto.user.UserDTO;
import com.cq.service.user.UserIdCardAnalyzeService;

/**
 * <p>
 * 类描述:身份证信息解析
 * </p>
 *
 * @since 2018年11月5日
 * @author chengq
 */
@Service
public class UserIdCardAnalyzeServiceImpl implements UserIdCardAnalyzeService {

    @Override
    public UserDTO getUser(UserDTO userDto) {
        userDto.setBirthdate(getBirthByIdCard(userDto.getIdCardNo()));
        userDto.setAge(getAgeByIdCard(userDto.getIdCardNo()));
        userDto.setSex(getGenderByIdCard(userDto.getIdCardNo()));
        return userDto;
    }

    /**
     * 根据身份编号获取年龄
     *
     * @param idCard
     *            身份编号
     * @return 年龄
     */
    public int getAgeByIdCard(String idCard) {
        int iAge = 0;
        String year = idCard.substring(UserIdCardEnum.num6.getCode(), UserIdCardEnum.num10.getCode());
        Calendar cal = Calendar.getInstance();
        Integer iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }

    /**
     * 根据身份编号获取生日
     *
     * @param idCard
     *            身份编号
     * @return 生日(yyyyMMdd)
     */
    public Date getBirthByIdCard(String idCard) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String birthday = idCard.substring(UserIdCardEnum.num6.getCode(), UserIdCardEnum.num14.getCode());
        try {
            return sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据身份编号获取性别
     *
     * @param idCard
     *            身份编号
     * @return 性别(1-男，2-女，0-未知)
     */
    public Integer getGenderByIdCard(String idCard) {
        Integer sGender = 0;

        String sCardNum = idCard.substring(UserIdCardEnum.num16.getCode(), UserIdCardEnum.num17.getCode());
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = 1; // 男
        } else {
            sGender = 2; // 女
        }
        return sGender;
    }
}
