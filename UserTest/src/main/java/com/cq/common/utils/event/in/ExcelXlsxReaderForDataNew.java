/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils.event.in;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.cq.common.constant.ExcelConstant;

/**
 * <p>
 * 类描述: SAX 读取数据
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public class ExcelXlsxReaderForDataNew extends DefaultHandler {

    /** 是否是标题行 */
    private static boolean isHeader = true;

    /** 读取器 */
    private IExcelRowReader rowReader;

    /** 解决excel写数字使用 '0909 的这种写法 */
    private String nameValue = "";

    /**
     * 读取器
     *
     * @param rowReader
     *            读取器
     */
    public void setRowReader(IExcelRowReader rowReader) {
        this.rowReader = rowReader;
    }

    /**
     * 共享字符串表
     */
    private SharedStringsTable sst;

    /**
     * 上一次的内容
     */
    private String lastContents;

    /**
     * 字符串标识
     */
    private boolean nextIsString;

    /**
     * 工作表索引
     */
    private static Integer sheetIndex = -1;

    /**
     * 行集合
     */
    private List<String> rowlist = new ArrayList<String>(ExcelConstant.NUMBER_EIGHT);

    /**
     * 行map信息
     */
    private Map<String, String> mIndexAndValue = new HashMap<>(ExcelConstant.NUMBER_EIGHT);
    /** 标题行 */
    private List<String> titleIndexList = new ArrayList<String>(ExcelConstant.NUMBER_EIGHT);
    /**
     * 异常信息，如果为空则表示没有异常
     */
    private String exceptionMessage;

    /**
     * 单元格数据类型，默认为字符串类型
     */
    private CellDataType nextDataType = CellDataType.SSTINDEX;

    private final DataFormatter formatter = new DataFormatter();

    private short formatIndex;

    private String formatString;

    /**
     * 定义前一个元素和当前元素的位置，用来计算其中空的单元格数量，如A6和A8等
     */
    private String preRef = null, ref = null;

    /**
     * 单元格
     */
    private StylesTable stylesTable;

    /**
     * 遍历工作簿中所有的电子表格
     *
     * @param filename
     *            文件名
     * @throws IOException
     *             异常
     * @throws OpenXML4JException
     *             异常
     * @throws SAXException
     *             异常
     */
    public void process(String filename) throws IOException, OpenXML4JException, SAXException {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader xssfReader = new XSSFReader(pkg);
        stylesTable = xssfReader.getStylesTable();
        SharedStringsTable sst = xssfReader.getSharedStringsTable();
        XMLReader parser = this.fetchSheetParser(sst);
        Iterator<InputStream> sheets = xssfReader.getSheetsData();
        while (sheets.hasNext()) {
            sheetIndex++;
            // 结束了 初始化表头数据
            isHeader = true;
            titleIndexList.clear();
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
        }
    }

    /**
     * 遍历工作簿中所有的电子表格
     *
     * @param ins
     *            输入流
     * @throws IOException
     *             异常
     * @throws OpenXML4JException
     *             异常
     * @throws SAXException
     *             异常
     */
    public void process(InputStream ins) throws IOException, OpenXML4JException, SAXException {
        OPCPackage pkg = OPCPackage.open(ins);
        XSSFReader xssfReader = new XSSFReader(pkg);
        stylesTable = xssfReader.getStylesTable();
        SharedStringsTable sst = xssfReader.getSharedStringsTable();
        XMLReader parser = this.fetchSheetParser(sst);
        Iterator<InputStream> sheets = xssfReader.getSheetsData();
        // 多个sheet 多？
        while (sheets.hasNext()) {
            sheetIndex++;
            // 结束了 初始化表头数据
            isHeader = true;
            titleIndexList.clear();
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
        }
    }

    /**
     * 解析器
     *
     * @param sst
     *            sst
     * @return xmlReder
     * @throws SAXException
     *             异常
     */
    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");

        this.sst = sst;
        parser.setContentHandler(this);
        return parser;
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
        // c => 单元格

        if (ExcelConstant.CINDEX.equals(name)) {
            // 前一个单元格的位置
            if (preRef == null) {
                preRef = attributes.getValue(ExcelConstant.COLUM_DATA);
            } else {
                preRef = ref;
            }

            // 当前单元格的位置
            ref = attributes.getValue(ExcelConstant.COLUM_DATA);

            // 设定单元格类型
            this.setNextDataType(attributes);
            // Figure out if the value is an index in the SST
            String cellType = attributes.getValue(ExcelConstant.TTYPE);
            if (cellType != null && cellType.equals(ExcelConstant.SSTINDEX)) {
                nextIsString = true;
            } else {
                nextIsString = false;
            }
        }

        // 置空
        lastContents = "";
    }

    /**
     * 单元格中的数据可能的数据类型
     */
    enum CellDataType {
        /**
         * 布尔类型
         */
        BOOL, ERROR, FORMULA, INLINESTR, SSTINDEX, NUMBER, DATE, NULL
    }

    /**
     * 处理数据类型
     *
     * @param attributes
     *            单元格参数
     */
    public void setNextDataType(Attributes attributes) {
        nextDataType = CellDataType.NUMBER;
        formatIndex = -1;
        formatString = null;
        String cellType = attributes.getValue(ExcelConstant.TTYPE);

        String cellStyleStr = attributes.getValue(ExcelConstant.SSTINDEX);

        // String columData = attributes.getValue(ExcelConstant.COLUM_DATA);

        if (ExcelConstant.BOOLEAN.equals(cellType)) {
            nextDataType = CellDataType.BOOL;
        } else {

            if (ExcelConstant.ERROR.equals(cellType)) {
                nextDataType = CellDataType.ERROR;
            } else {

                if (ExcelConstant.INLINESTR.equals(cellType)) {
                    nextDataType = CellDataType.INLINESTR;
                } else if (ExcelConstant.SSTINDEX.equals(cellType)) {
                    nextDataType = CellDataType.SSTINDEX;
                } else {

                    if (ExcelConstant.FORMULA.equals(cellType)) {
                        nextDataType = CellDataType.FORMULA;
                    }
                }
            }
        }

        if (cellStyleStr != null) {
            int styleIndex = Integer.parseInt(cellStyleStr);
            XSSFCellStyle style = stylesTable.getStyleAt(styleIndex);
            formatIndex = style.getDataFormat();
            formatString = style.getDataFormatString();

            if (formatString.contains(ExcelConstant.TIME_M) || formatString.contains(ExcelConstant.TIME_YEAR) || formatString.contains(ExcelConstant.TIME_MON)
                    || formatString.contains(ExcelConstant.TIME_DATE)) {
                nextDataType = CellDataType.DATE;
                formatString = "yyyy-MM-dd hh:mm:ss.SSS";
            }

            if (formatString == null) {
                nextDataType = CellDataType.NULL;
                formatString = BuiltinFormats.getBuiltinFormat(formatIndex);
            }
        }
    }

    /**
     * 对解析出来的数据进行类型处理
     *
     * @param value
     *            单元格的值（这时候是一串数字）
     * @param thisStr
     *            一个空字符串
     * @return 解析好的数据值
     */
    public String getDataValue(String value, String thisStr) {
        switch (nextDataType) {
        // 这几个的顺序不能随便交换，交换了很可能会导致数据错误
        case BOOL:
            char first = value.charAt(0);
            if (first == '0') {
                thisStr = ExcelConstant.FALSE;
            } else {
                thisStr = ExcelConstant.TRUE;
            }
            break;
        case ERROR:
            thisStr = "\"ERROR:" + value.toString() + '"';
            break;
        case FORMULA:
            thisStr = '"' + value.toString() + '"';
            break;
        case INLINESTR:
            XSSFRichTextString rtsi = new XSSFRichTextString(value.toString());

            thisStr = rtsi.toString();
            rtsi = null;
            break;
        case SSTINDEX:
            try {
                if (ExcelConstant.CINDEX.equals(nameValue)) {
                    int idx = Integer.parseInt(lastContents);
                    lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();

                } else {
                    thisStr = value.toString();
                }
            } catch (NumberFormatException ex) {
                thisStr = value.toString();
            }
            break;
        case NUMBER:
            if (formatString != null) {
                thisStr = formatter.formatRawCellContents(Double.parseDouble(value), formatIndex, formatString).trim();
            } else {
                thisStr = value;
            }

            thisStr = thisStr.replace("_", "").trim();
            break;
        case DATE:
            if (NumberUtils.isDigits(value)) {
                thisStr = formatter.formatRawCellContents(Double.parseDouble(value), formatIndex, formatString);
            } else {
                thisStr = value;
            }
            // 对日期字符串作特殊处理
            // thisStr = thisStr.replace(" ", "T");
            break;
        default:
            thisStr = " ";
            break;
        }

        return thisStr;
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        // 根据SST的索引值的到单元格的真正要存储的字符串
        // 这时characters()方法可能会被调用多次
        if (nextIsString && StringUtils.isNotEmpty(lastContents) && StringUtils.isNumeric(lastContents)) {
            if (!ExcelConstant.CINDEX.equals(name) && !ExcelConstant.ROW.equals(name) && ExcelConstant.VINDEX.equals(name)) {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();

            }
        }

        // 存入值
        if (ExcelConstant.VINDEX.equals(name)) {

            // v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引
            String value = this.getDataValue(lastContents.trim(), "");
            // 索引
            String index = ref.replaceAll("\\d+", "");
            if (isHeader) {
                // 标题的index 存入
                titleIndexList.add(index);
            } else {
                // 计入map
                mIndexAndValue.put(index, value);
            }
        }

        // 一行结束
        if (ExcelConstant.ROW.equals(name)) {
            // 数据
            if (!isHeader) {
                // 设置数据
                setDataList();
                // 回调
                rowReader.getRows(new ArrayList<>(rowlist));
            }
            // 标题
            if (isHeader) {
                isHeader = false;
            }
            rowlist.clear();
            mIndexAndValue.clear();
            preRef = null;
            ref = null;
        }
    }

    /**
     * 设置rowlist的数据
     */
    private void setDataList() {
        for (String index : titleIndexList) {
            String value = mIndexAndValue.get(index);
            if (StringUtils.isEmpty(value)) {
                value = StringUtils.EMPTY;
            }
            rowlist.add(value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 得到单元格内容的值
        lastContents += new String(ch, start, length);
    }

    /**
     * @return the exceptionMessage
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

}
