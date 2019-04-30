/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月1日
 * @author chengq
 */
public class ListTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = getRandomList(20, 15);
        System.out.println(map.toString());
    }

    public static Map<Integer, Integer> getRandomList(int num, int range) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num; i++) {
            Integer randomNum = (int) (Math.random() * range);
            map.put(i, randomNum);
        }
        return map;
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
