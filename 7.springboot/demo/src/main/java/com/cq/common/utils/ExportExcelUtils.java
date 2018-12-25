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

    /**
     * Excel容量
     */
    // private static final int ONE_CELL_SIZE = 32767;

    /**
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @param workbook
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
     */
    public static void exportExcel(HSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, List<List<String>> result, OutputStream out)
            throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(20);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

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
     * @Title: exportExcel
     * @Description: 导出Excel的方法
     * @param workbook
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
     */
    public static void exportExcelString(XSSFWorkbook workbook, int sheetNum, String sheetTitle, String[] headers, List<List<String>> result, OutputStream out,
            Boolean mergeSecond) throws Exception {
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(sheetNum, sheetTitle);
        // 设置表格默认列宽度为20个字节
        sheet.setDefaultColumnWidth(20);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);

        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);

            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text.toString());
            if (i == headers.length - 1) {
                XSSFCell cellErro = row.createCell(i + 1);

                XSSFCellStyle errorStyle = workbook.createCellStyle();
                // 设置这些样式
                errorStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
                errorStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                errorStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                errorStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                errorStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
                errorStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
                errorStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                // 生成一个字体
                XSSFFont erroeFont = workbook.createFont();
                erroeFont.setColor(HSSFColor.RED.index);
                erroeFont.setFontHeightInPoints((short) 12);
                erroeFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
                errorStyle.setFont(erroeFont);
                errorStyle.setWrapText(true);

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
     * 字符串首位大写
     *
     * @param String
     * @return 字符串首位大写的字符串
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

}
