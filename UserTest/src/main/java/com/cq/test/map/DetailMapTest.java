/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cq.common.utils.ListUtils;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月25日
 * @author chengq
 */
public class DetailMapTest {

    public static void main(String[] args) {
        Map<String, List<String>> detailMap = new HashMap<String, List<String>>();
        List<String> dbNameList = new ArrayList<String>();

        List<List<String>> detailList = new ArrayList<List<String>>();
        for (String detailKey : detailMap.keySet()) {
            for (String name : dbNameList) {
                Object object = null;
                if (object == null && detailKey.equals(name)) {
                    List<String> valueList = detailMap.get(name);
                    detailList.add(valueList);
                }
            }
        }

        if (ListUtils.isNotEmpty(detailList)) {
            Integer size = detailList.get(0).size();
            List<List<String>> total = new ArrayList<List<String>>();
            for (int i = 0; i < size; i++) {
                List<String> valueList = new ArrayList<String>();
                for (int j = 0; j < detailList.size(); j++) {
                    valueList.add(detailList.get(j).get(i));
                }
                total.add(valueList);
            }
        }

    }
}
