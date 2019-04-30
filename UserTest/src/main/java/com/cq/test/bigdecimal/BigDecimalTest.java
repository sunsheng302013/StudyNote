/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.bigdecimal;

import java.math.BigDecimal;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月21日
 * @author chengq
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal date = new BigDecimal(35.7);
        float intvalue = date.floatValue();
        float hour = intvalue % 8;
        String ss = String.format("%1.2f", hour);
        System.out.println(ss + "天");
    }
}
