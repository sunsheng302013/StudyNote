/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils.event;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.cq.common.utils.event.in.ExcelXlsMultiReaderForData;
import com.cq.common.utils.event.in.ExcelXlsReaderForData;
import com.cq.common.utils.event.in.ExcelXlsxMultiReaderForDataNew;
import com.cq.common.utils.event.in.ExcelXlsxReaderForDataNew;
import com.cq.common.utils.event.in.IExcelRowReader;

/**
 * <p>
 * 类描述:读取数据
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public class ExcelDataReaderUtil {
    /**
     * excel2003扩展名
     */
    public static final String EXCEL03_EXTENSION = ".xls";
    /**
     * excel2007扩展名
     */
    public static final String EXCEL07_EXTENSION = ".xlsx";

    /**
     * 读取Excel文件，可能是03也可能是07版本
     *
     * @param reader
     *            读写器
     * @param fileName
     *            本地文件地址
     * @throws Exception
     */
    public static void readExcel2(IExcelRowReader reader, String fileName) throws Exception {
        try {
            // 处理excel2003文件
            if (fileName.endsWith(EXCEL03_EXTENSION)) {
                ExcelXlsReaderForData exceXls = new ExcelXlsReaderForData();
                exceXls.setRowReader(reader);
                exceXls.process(fileName);
                // 处理excel2007文件
            } else if (fileName.endsWith(EXCEL07_EXTENSION)) {
                // ExcelXlsxReaderForData exceXlsx = new ExcelXlsxReaderForData();
                // exceXlsx.setRowReader(reader);
                // exceXlsx.process(fileName);
            } else {
                throw new Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
            }
        } finally {
            // 最后返回null,结束标志
            reader.getRows(null);
        }
    }

    /**
     * 读取Excel文件，可能是03也可能是07版本
     *
     * @param reader
     *            读写器
     * @param urlName
     *            文件在ngnix的文件地址
     * @throws Exception
     */
    public static void readExcel(IExcelRowReader reader, String urlName) throws Exception {
        InputStream ins = null;
        try {
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            ins = connection.getInputStream();

            if (urlName.endsWith(EXCEL03_EXTENSION)) {
                // 处理excel2003文件
                processExcel03(reader, ins);
            } else if (urlName.endsWith(EXCEL07_EXTENSION)) {
                // 处理excel2007文件
                processExcel07(reader, ins);
            } else {
                throw new Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
            }
        } finally {
            // 最后返回null
            reader.getRows(null);
            ins.close();
        }
    }

    /**
     * 解析07版的excel
     *
     */
    private static void processExcel07(IExcelRowReader reader, InputStream ins) throws Exception {
        ExcelXlsxReaderForDataNew exceXlsx = new ExcelXlsxReaderForDataNew();
        exceXlsx.setRowReader(reader);
        exceXlsx.process(ins);
    }

    /**
     * 解析03版的excel
     *
     */
    private static void processExcel03(IExcelRowReader reader, InputStream ins) throws Exception {
        ExcelXlsReaderForData exceXls = new ExcelXlsReaderForData();
        exceXls.setRowReader(reader);
        exceXls.process(ins);
    }

    /**
     * 解析03版的excel
     *
     */
    private static void processMultiExcel03(IExcelRowReader reader, InputStream ins) throws Exception {
        ExcelXlsMultiReaderForData exceXls = new ExcelXlsMultiReaderForData();
        exceXls.setRowReader(reader);
        exceXls.process(ins);
    }

    /**
     * 解析07版的excel
     *
     */
    private static void processMultiExcel07(IExcelRowReader reader, InputStream ins) throws Exception {
        // ExcelXlsxMultiReaderForData exceXlsx = new ExcelXlsxMultiReaderForData();
        ExcelXlsxMultiReaderForDataNew exceXlsx = new ExcelXlsxMultiReaderForDataNew();
        exceXlsx.setRowReader(reader);
        exceXlsx.process(ins);
    }

    /**
     * 读取Excel文件，可能是03也可能是07版本
     *
     * @throws Exception
     *
     */
    public static void readMultiExcel(ExcelDataReader reader, String urlName) throws Exception {
        InputStream ins = null;
        try {
            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();
            ins = connection.getInputStream();

            if (urlName.endsWith(EXCEL03_EXTENSION)) {
                // 处理excel2003文件
                processMultiExcel03(reader, ins);
            } else if (urlName.endsWith(EXCEL07_EXTENSION)) {
                // 处理excel2007文件
                processMultiExcel07(reader, ins);
            } else {
                throw new Exception("文件格式错误，fileName的扩展名只能是xls或xlsx。");
            }
        } finally {
            // 最后返回null
            reader.getRows(null, -1);
            ins.close();
        }
    }
}
