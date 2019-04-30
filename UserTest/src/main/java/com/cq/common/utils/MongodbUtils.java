/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.cq.common.base.PageInfo;
import com.mongodb.BasicDBObject;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年1月4日
 * @author chengq
 */
public class MongodbUtils {

    private MongodbUtils() {
    }

    private static final String LK = "$lk$";
    private static final String EQ = "$eq$";
    private static final String GT = "$gt$";
    private static final String LT = "$lt$";
    private static final String GTEQ = "$gteq$";
    private static final String LTEQ = "$lteq$";
    private static final String GTLT = "$gtlt$";
    private static final String IN = "$in$";

    /**
     * 将查询条件转成mongodb的查询条件
     *
     * @param queryMap
     *            查询条件
     * @param page
     *            分页信息
     * @param fieldList
     *            指定返回字段
     * @return mongodb的查询条件
     */
    public static Query getQuery(Map<String, Object> queryMap, PageInfo page, List<String> fieldList) {
        // 指定返回字段
        BasicDBObject fieldsObject = new BasicDBObject();
        fieldsObject.put("_id", false);
        if (ListUtils.isNotEmpty(fieldList)) {
            for (String field : fieldList) {
                fieldsObject.put(field, true);
            }
        }
        Query mongoQuery = new Query();
        // 查询条件
        for (Map.Entry<String, Object> query : queryMap.entrySet()) {
            setQueryCriteria(mongoQuery, query);
        }
        // 排序方式
        if (null != page) {
            if (null != page.getSortField() && !"".equals(page.getSortField())) {

            }
        }
        return null;
    }

    /**
     *
     * @param query
     * @param queryCondition
     */
    private static void setQueryCriteria(Query mongoQuery, Map.Entry<String, Object> queryCondition) {
        String value = queryCondition.getValue().toString();
        if (value.contains(LK)) {
            // 文本模糊查询
            Criteria criteria = Criteria.where(queryCondition.getKey()).regex(value.substring(LK.length()));
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(EQ)) {
            // 数值/日期 等于
            Criteria criteria = Criteria.where(queryCondition.getKey()).is(value.substring(EQ.length()));
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(GT)) {
            // 数值/日期 大于
            Criteria criteria = Criteria.where(queryCondition.getKey()).gt(value.substring(GT.length()));
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(LT)) {
            // 数值/日期 小于
            Criteria criteria = Criteria.where(queryCondition.getKey()).lt(value.substring(LT.length()));
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(GTEQ)) {
            // 数值/日期 大于等于
            Criteria criteria = Criteria.where(queryCondition.getKey()).gte(value.substring(GTEQ.length()));
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(LTEQ)) {
            // 数值/日期 小于等于
            Criteria criteria = Criteria.where(queryCondition.getKey()).lte(value.substring(LTEQ.length()));
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(GTLT)) {
            // 日期区间
            String[] dates = value.substring(GTLT.length()).split(",");
            Criteria criteria = Criteria.where(queryCondition.getKey()).gte(dates[0]).lte(dates[1]);
            mongoQuery.addCriteria(criteria);
        } else if (value.contains(IN)) {
            // 包含
            String[] dates = value.substring(IN.length()).split(",");
            List<String> list = new ArrayList<String>();
            for (String str : dates) {
                list.add(str);
            }
            Criteria criteria = Criteria.where(queryCondition.getKey()).in(list);
            mongoQuery.addCriteria(criteria);
        } else {
            // 完全匹配
            Criteria criteria = Criteria.where(queryCondition.getKey()).is(value);
            mongoQuery.addCriteria(criteria);
        }
    }
}
