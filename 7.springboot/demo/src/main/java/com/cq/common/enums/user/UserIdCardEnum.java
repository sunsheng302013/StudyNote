/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.user;

import com.cq.common.enums.CodeEnum;

/**
 * <p>
 * 类描述: 身份证数字字典
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public enum UserIdCardEnum implements CodeEnum {

    /** 身份证解析 **/
    num0(0), num1(1), num2(2), num3(3), num4(4), num5(5), num6(6), num7(7), num8(8), num9(9), num10(10), num11(11), num12(12), num13(13), num14(14), num15(15),
    /** 身份证解析 **/
    num16(16), num17(17), num18(18);

    /** 处理类型code **/
    private Integer code;

    /**
     * @param code
     *            编码
     */
    UserIdCardEnum(Integer code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
