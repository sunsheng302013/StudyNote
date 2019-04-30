/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.json;

import com.alibaba.fastjson.JSONObject;
import com.cq.common.utils.JsonUtils;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月8日
 * @author chengq
 */
public class EntityTest {

    public static void main(String[] args) {
        String strOne = getTestJson();
        TestTwo two = JsonUtils.jsonToEntity(strOne, TestTwo.class);
        System.out.println(two);
    }

    public static String getTestJson() {
        TestOne one = new TestOne();
        one.setId(2019);
        one.setOverDate(2020);
        one.setUserId(2013310200301L);
        one.setVacationType("vacationType");
        return JSONObject.toJSONString(one);
    }
}
