/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils.event;

import java.util.List;
import java.util.Map;

import com.cq.common.utils.event.in.IExcelRowReader;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public interface ExcelDataReader extends IExcelRowReader {

    /**
     * 实现这个类，重写getRows来获取数据，以满足自己所需要
     *
     * @param rowlist
     *            excel文件中的一行数据（跳过表头）
     */
    @Override
    default void getRows(List<String> rowlist) {

    }

    /**
     * 默认实现，这个在这里不使用
     *
     * @return key=头，value=位置
     */
    @Override
    default Map<Object, Integer> getHeaders() {
        return null;
    }

    /**
     * 获取数据和当前sheet页
     *
     * @param rowlist
     *            excel文件中的行
     * @param sheetIndex
     *            sheet页码
     */
    @Override
    default void getRows(List<String> rowlist, int sheetIndex) {
    }
}
