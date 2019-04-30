/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月16日
 * @author chengq
 */
public class ForeachTest {

    public static void main(String[] args) {
        List<Test> testList = new ArrayList<Test>();
        Long userId = 12L;
        Test testOne = new Test(12L);
        Test testTwo = new Test(13L);
        Test testThree = new Test(14L);
        testOne.setLocationName("locationName12L");
        testList.add(testOne);
        testList.add(testTwo);
        testList.add(testThree);
        testList.stream().filter(x -> x.getLocationId().equals(userId)).forEach(x -> x.setId(1));
        for (Test test : testList) {
            if (test.getLocationId().longValue() == userId.longValue()) {
                test.setLocationName("测试14");
            }
        }
        System.out.println(Arrays.toString(testList.toArray()));
    }
}
