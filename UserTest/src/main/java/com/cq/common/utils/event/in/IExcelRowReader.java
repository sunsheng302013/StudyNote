/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils.event.in;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述: 基础类
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public interface IExcelRowReader {

    /**
     * 业务逻辑实现方法
     *
     * @param rowlist
     *            excel文件中的行
     */

    void getRows(List<String> rowlist);

    /**
     * 获取数据和当前sheet页
     *
     * @param rowlist
     *            excel文件中的行
     * @param sheetIndex
     *            sheet页码
     */
    void getRows(List<String> rowlist, int sheetIndex);

    /**
     * 基础类
     *
     * @return 表头Map
     */
    Map<Object, Integer> getHeaders();

    /**
     * 基础类
     *
     * @return 多表头数据
     */
    List<Map<Object, Integer>> getMutiHeaders();
}