/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月7日
 * @author chengq
 */
public class ListFilterTest {

    public static void main(String[] args) {
        List<Test> list = getRandomList(10, 20);
        list.stream().filter(x -> x.getLocationId() == null).forEach(x -> x.setLocationId(5000000000L));
        for (Test test : list) {
            System.out.println(test.getLocationId());
        }
    }

    public static List<Test> getRandomList(int num, int range) {
        List<Test> list = new ArrayList<Test>();
        for (int i = 0; i < num; i++) {
            Test test = new Test();
            Integer randomNum = (int) (Math.random() * range);
            Long locationId = (long) (Math.random() * 100 * range);
            test.setId(randomNum);
            test.setLocationId(locationId);
            list.add(test);
        }
        for (int i = 0; i < num; i++) {
            Test test = new Test();
            Integer randomNum = (int) (Math.random() * range);
            // Long locationId = (long) (Math.random() * 100 * range);
            test.setId(randomNum);
            // test.setLocationId(locationId);
            list.add(test);
        }
        return list;
    }
}
