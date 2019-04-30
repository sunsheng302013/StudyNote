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
 * @since 2019年4月17日
 * @author chengq
 */
public class AbsTest {

    public static void main(String[] args) {
        BigDecimal one = new BigDecimal(1.3);
        String strOne = one.abs().stripTrailingZeros().toPlainString();
        System.out.println("strOne:" + strOne);
        System.out.println("one:" + one);
    }
}
