/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import java.util.List;

import com.cq.common.base.PageInfo;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月30日
 * @author chengq
 */
public class Page {

    /**
     *
     * @param page
     *            分页信息
     * @param userWorkDtoList
     *            流程信息
     * @return 流程信息
     */
    public static <T> List<T> pagination(PageInfo page, List<T> objectList) {
        if (null != page && ListUtils.isNotEmpty(objectList)) {
            if (page.getOffset() + page.getPageSize() > objectList.size()) {
                objectList = objectList.subList(page.getOffset(), objectList.size());
            } else {
                objectList = objectList.subList(page.getOffset(), page.getOffset() + page.getPageSize());
            }
        }
        return objectList;
    }
}
