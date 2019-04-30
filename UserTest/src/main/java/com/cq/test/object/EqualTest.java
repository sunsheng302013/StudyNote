/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.object;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月9日
 * @author chengq
 */
public class EqualTest {

    public static void main(String[] args) {
        Integer index = 5;
        String cheng = "cheng";
        String qian = "qian";
        String strOne = "chengqian";
        String strTwo = "chengqian";
        String strThree = new String("chengqian");
        String strForth = cheng + qian;

        System.out.println("index.hashCode();:" + index.hashCode());
        System.out.println("strOne.hashCode():" + strOne.hashCode());
        System.out.println("strTwo.hashCode():" + strTwo.hashCode());
        System.out.println("strThree.hashCode():" + strThree.hashCode());
        System.out.println("strThree.hashCode():" + strThree.hashCode());
        if (strOne == strTwo) {
            strOne.hashCode();
            System.out.println("strOne == strTwo");
        }
        if (strOne == strForth) {
            strOne.hashCode();
            System.out.println("strOne == strForth");
        }
        if (strOne == strThree) {
            System.out.println("strOne == strThree");
        }
        if (strOne.equals(strThree)) {
            System.out.println("strOne-equals-strThree");
        }
    }
}
