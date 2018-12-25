/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils;

import com.cq.common.utils.event.ExcelDataReader;
import com.cq.common.utils.event.ExcelDataReaderUtil;

/**
 * <p>
 * 类描述:导入数据的工具类
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public class ExcelStartDataUtil {
    /**
     * 数据读取（第一行不读）
     *
     * @param urlName
     *            nginx上文件地址
     * @param excelDataReader
     *            读取器
     * @throws Exception
     */
    public static void startInsertToDb(String urlName, ExcelDataReader excelDataReader) throws Exception {
        // 启动导入数据方法，方法需要继承ExcelDataReader
        ExcelDataReaderUtil.readExcel(excelDataReader, urlName);
    }

    /**
     * 数据读取（第一行不读）
     *
     * @param urlName
     *            nginx上文件地址
     * @param excelDataReader
     *            读取器
     * @throws Exception
     */
    public static void startMultiInsertToDb(String urlName, ExcelDataReader excelDataReader) throws Exception {
        // 启动导入数据方法，方法需要继承ExcelDataReader
        ExcelDataReaderUtil.readMultiExcel(excelDataReader, urlName);
    }

    /**
     *
     */
    private ExcelStartDataUtil() {
        super();
    }
}
