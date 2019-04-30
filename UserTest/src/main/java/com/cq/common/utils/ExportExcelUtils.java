package com.cq.common.utils;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel导出组件 import org.apache.poi.ss.util.CellRangeAddress;
 *
 * @since 2017年12月4日 上午11:25:02
 * @author huangyi
 *
 */
public class ExportExcelUtils {

    /** 表格默认列宽度 20个字节 **/
    private static final Integer SHEETLENGTH = 20;
    /** 字体默认高度 12 **/
    private static final short FONTHEIGHT = 12;

    /**
     * 默认构造方法
     */
    protected ExportExcelUtils() {
    }

    /**
     * Excel容量
     */
    // private static final int ONE_CELL_SIZE = 32767;

    /**
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @param workbook
     *            excel表生成的数据
     * @param sheetNum
     *            (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle
     *            （sheet的名称）
     * @param headers
     *            （表格的标题）
     * @param result
     *            （表格的数据）
     * @param out
     *            （输出流）
     * @throws Exception
     *             异常
     */
    public static void exportXls(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, List<List<String>> result, OutputStream out)
            throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(SHEETLENGTH);
        // 生成一个样式
        HSSFCellStyle style = setXlsStyle(workbook);
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (Object str : m) {
                    HSSFCell cell = row.createCell(cellIndex);
                    cell.setCellValue(str.toString());
                    cellIndex++;
                }
                index++;
            }
        }
    }

    /**
     * 导出xlsx格式Excel的方法
     *
     * @param workbook
     *            excel表生成的数据
     * @param sheetNum
     *            (sheet的位置，0表示第一个表格中的第一个sheet)
     * @param sheetTitle
     *            （sheet的名称）
     * @param headers
     *            （表格的标题）
     * @param result
     *            （表格的数据）
     * @param out
     *            （输出流）
     *
     * @param mergeSecond
     *            （合并第二行）
     *
     * @throws Exception
     *             抛出异常
     */
    public static void exportXlsx(XSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, List<List<String>> result, OutputStream out,
            Boolean mergeSecond) throws Exception {
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(SHEETLENGTH);
        // 生成样式
        XSSFCellStyle style = setXlsxStyle(workbook);
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
            if (i == headers.length - 1) {
                XSSFCell cellErro = row.createCell(i + 1);
                // 生成错误信息样式
                XSSFCellStyle errorStyle = setXlsxStyle(workbook);

                cellErro.setCellStyle(errorStyle);
                HSSFRichTextString textErro = new HSSFRichTextString("错误信息");
                cellErro.setCellValue(textErro.toString());
            }
        }
        // 遍历集合数据，产生数据行
        if (result != null) {
            int index = 1;
            for (List<String> m : result) {
                row = sheet.createRow(index);
                int cellIndex = 0;
                for (Object str : m) {
                    XSSFCell cell = row.createCell(cellIndex);
                    if (str != null) {
                        cell.setCellValue(str.toString());
                    }
                    cellIndex++;
                }
                index++;
            }
        }
    }

    /**
     * 设置xls格式excel样式
     *
     * @param workbook
     *            excel数据
     * @return xls格式exlce样式
     */
    public static HSSFCellStyle setXlsStyle(HSSFWorkbook workbook) {
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 设置字体
        font.setColor(HSSFColor.RED.index);
        font.setFontHeightInPoints(FONTHEIGHT);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        return style;
    }

    /**
     * 设置xlsx格式excel样式
     *
     * @param workbook
     *            excel数据
     * @return xls格式exlce样式
     */
    public static XSSFCellStyle setXlsxStyle(XSSFWorkbook workbook) {
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 设置字体
        font.setColor(XSSFFont.COLOR_RED);
        font.setFontHeightInPoints(FONTHEIGHT);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        return style;
    }

    /**
     * 字符串首位大写
     *
     * @param str
     *            字符串
     * @return 字符串首位大写的字符串
     */
    public static String toUpperCaseFirstOne(String str) {
        if (Character.isUpperCase(str.charAt(0))) {
            return str;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
        }
    }

}
