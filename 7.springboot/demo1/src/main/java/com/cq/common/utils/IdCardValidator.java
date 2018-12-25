/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cq.common.enums.user.IdCardCheckCodeEnum;
import com.cq.common.enums.user.UserIdCardEnum;

/**
 * <p>
 * 类描述: 身份证合法性校验
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */

public class IdCardValidator {

    /** 默认构造方法 **/
    protected IdCardValidator() {
    }

    // 每位加权因子
    private static int[] power = { UserIdCardEnum.num7.getCode(), UserIdCardEnum.num9.getCode(), UserIdCardEnum.num10.getCode(), UserIdCardEnum.num5.getCode(),
            UserIdCardEnum.num8.getCode(), UserIdCardEnum.num4.getCode(), UserIdCardEnum.num2.getCode(), UserIdCardEnum.num1.getCode(),
            UserIdCardEnum.num6.getCode(), UserIdCardEnum.num3.getCode(), UserIdCardEnum.num7.getCode(), UserIdCardEnum.num9.getCode(),
            UserIdCardEnum.num10.getCode(), UserIdCardEnum.num5.getCode(), UserIdCardEnum.num8.getCode(), UserIdCardEnum.num4.getCode(),
            UserIdCardEnum.num2.getCode() };

    /**
     * 验证所有的身份证的合法性
     *
     * @param idcard
     *            身份证号
     * @return ture false
     */
    public static boolean isValidatedAllIdcard(String idcard) {
        if (idcard.length() == UserIdCardEnum.num15.getCode()) {
            idcard = convertIdcarBy15bit(idcard);
        }
        return isValidate18Idcard(idcard);
    }

    /**
     * 判断18位身份证的合法性
     *
     * @param idcard
     *            18位身份证号码
     * @return true false
     */
    private static boolean isValidate18Idcard(String idcard) {
        // 非18位为假
        if (idcard.length() != UserIdCardEnum.num18.getCode()) {
            return false;
        }
        // 获取前17位
        String idcard17 = idcard.substring(0, UserIdCardEnum.num17.getCode());
        // 获取第18位
        String idcard18Code = idcard.substring(UserIdCardEnum.num17.getCode(), UserIdCardEnum.num18.getCode());
        char[] c = null;
        String checkCode = "";
        // 是否都为数字
        if (isDigital(idcard17)) {
            c = idcard17.toCharArray();
        } else {
            return false;
        }

        if (null != c) {
            int[] bit = new int[idcard17.length()];
            bit = converCharToInt(c);
            int sum17 = 0;
            sum17 = getPowerSum(bit);
            // 将和值与11取模得到余数进行校验码判断
            checkCode = getCheckCodeBySum(sum17);
            if (null == checkCode) {
                return false;
            }
            // 将身份证的第18位与算出来的校码进行匹配，不相等就为假
            if (!idcard18Code.equalsIgnoreCase(checkCode)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证身份证前17位是否为数字
     *
     * @param str
     *            身份证前17位
     * @return true false
     */
    private static boolean isDigital(String str) {
        if (str == null || "".equals(str)) {
            return false;
        } else {
            return str.matches("^[0-9]*$");
        }
    }

    /**
     * 将字符数组转为整型数组
     *
     * @param c
     *            字符数组
     * @return 整形数组
     * @throws NumberFormatException
     *             整形类型转换错误
     */
    private static int[] converCharToInt(char[] c) throws NumberFormatException {
        int[] a = new int[c.length];
        int k = 0;
        for (char temp : c) {
            a[k++] = Integer.parseInt(String.valueOf(temp));
        }
        return a;
    }

    /**
     * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
     *
     * @param bit
     *            整形数组
     * @return 加权和值
     */
    private static int getPowerSum(int[] bit) {

        int sum = 0;
        if (power.length != bit.length) {
            return sum;
        }

        for (int i = 0; i < bit.length; i++) {
            for (int j = 0; j < power.length; j++) {
                if (i == j) {
                    sum = sum + bit[i] * power[j];
                }
            }
        }
        return sum;
    }

    /**
     * 将和值与11取模得到余数进行校验码判断
     *
     * @param sum17
     *            加权和值
     * @return 校验位
     */
    private static String getCheckCodeBySum(int sum17) {
        Integer num = sum17 % UserIdCardEnum.num11.getCode();
        return IdCardCheckCodeEnum.getMsgByCode(num);
    }

    /**
     * 将15位的身份证转成18位身份证
     *
     * @param idcard
     *            15位身份证号
     * @return 18位身份证号
     */
    private static String convertIdcarBy15bit(String idcard) {
        String idcard17 = null;
        // 非15位身份证
        if (idcard.length() != UserIdCardEnum.num15.getCode()) {
            return null;
        }

        if (isDigital(idcard)) {
            // 获取出生年月日
            String birthday = idcard.substring(UserIdCardEnum.num6.getCode(), UserIdCardEnum.num12.getCode());
            Date birthdate = null;
            try {
                birthdate = new SimpleDateFormat("yyMMdd").parse(birthday);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Calendar cday = Calendar.getInstance();
            cday.setTime(birthdate);
            String year = String.valueOf(cday.get(Calendar.YEAR));

            idcard17 = idcard.substring(0, UserIdCardEnum.num6.getCode()) + year + idcard.substring(UserIdCardEnum.num8.getCode());

            char[] c = idcard17.toCharArray();
            String checkCode = "";

            if (null != c) {
                int[] bit = new int[idcard17.length()];

                // 将字符数组转为整型数组
                bit = converCharToInt(c);
                int sum17 = 0;
                sum17 = getPowerSum(bit);

                // 获取和值与11取模得到余数进行校验码
                checkCode = getCheckCodeBySum(sum17);
                // 获取不到校验位
                if (null == checkCode) {
                    return null;
                }

                // 将前17位与第18位校验码拼接
                idcard17 += checkCode;
            }
        } else { // 身份证包含数字
            return null;
        }
        return idcard17;
    }
}
