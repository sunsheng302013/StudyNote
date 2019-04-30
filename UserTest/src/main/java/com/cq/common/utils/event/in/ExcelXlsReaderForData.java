/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.utils.event.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.eventusermodel.EventWorkbookBuilder.SheetRecordCollectingListener;
import org.apache.poi.hssf.eventusermodel.FormatTrackingHSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.hssf.eventusermodel.MissingRecordAwareHSSFListener;
import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingCellDummyRecord;
import org.apache.poi.hssf.model.HSSFFormulaParser;
import org.apache.poi.hssf.record.BOFRecord;
import org.apache.poi.hssf.record.BlankRecord;
import org.apache.poi.hssf.record.BoolErrRecord;
import org.apache.poi.hssf.record.BoundSheetRecord;
import org.apache.poi.hssf.record.FormulaRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NumberRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SSTRecord;
import org.apache.poi.hssf.record.StringRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;

import com.cq.common.constant.ExcelConstant;

/**
 * <p>
 * 类描述:事件模式，读取数据
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public class ExcelXlsReaderForData implements HSSFListener {

    /** 行数，用于确定是否有问题 */
    private int rowNumException = 0;

    /** 列数 */
    private int columnNum = 0;
    /**
     * 表头=true不输出
     */
    private boolean headerNum = true;

    private int minColumns = -1;

    /** POIFS 管理 */
    private POIFSFileSystem fs;
    /** 最后一行数量 */
    private int lastRowNumber;
    /** 最后一列数量 */
    private int lastColumnNumber;

    /** Should we output the formula, or the value it has? */
    private boolean outputFormulaValues = true;

    /** For parsing Formulas */
    private SheetRecordCollectingListener workbookBuildingListener;

    /**
     * excel2003工作薄
     */
    private HSSFWorkbook stubWorkbook;

    /**
     * Records we pick up as we process
     */
    private SSTRecord sstRecord;
    /** format监听 */
    private FormatTrackingHSSFListener formatListener;
    /** 时间formatter */
    private final DataFormatter formatter = new DataFormatter();

    /**
     * 表sheet索引
     */
    private int sheetIndex = -1;

    private BoundSheetRecord[] orderedBSRs;

    @SuppressWarnings("rawtypes")
    private ArrayList boundSheetRecords = new ArrayList();

    /**
     * For handling formulas with string results
     */
    private int nextRow;
    /** 下一列 */
    private int nextColumn;
    /** This is stored in the next record */
    private boolean outputNextStringRecord;

    /**
     * 当前行（暂时不使用）
     */
    @SuppressWarnings("unused")
    private int curRow = 0;

    /**
     * 存储行记录的容器
     */
    private List<String> rowlist = new ArrayList<String>();;

    @SuppressWarnings("unused")
    private String sheetName;
    /** 注入的读写 具体实现由业务编写 */
    private IExcelRowReader rowReader;

    public void setRowReader(IExcelRowReader rowReader) {
        this.rowReader = rowReader;
    }

    /**
     * 遍历excel下所有的sheet
     *
     * @throws IOException
     */
    public void process(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        try {
            this.fs = new POIFSFileSystem(in);
            MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(this);
            formatListener = new FormatTrackingHSSFListener(listener);
            HSSFEventFactory factory = new HSSFEventFactory();
            HSSFRequest request = new HSSFRequest();
            if (outputFormulaValues) {
                request.addListenerForAllRecords(formatListener);
            } else {
                workbookBuildingListener = new SheetRecordCollectingListener(formatListener);
                request.addListenerForAllRecords(workbookBuildingListener);
            }
            factory.processWorkbookEvents(request, fs);
        } finally {
            in.close();
        }
    }

    /**
     * 遍历excel下所有的sheet
     *
     * @throws IOException
     */
    public void process(InputStream fileName) throws IOException {
        // FileInputStream in = new FileInputStream(fileName);
        try {
            this.fs = new POIFSFileSystem(fileName);
            // this.fs = new POIFSFileSystem(in);
            MissingRecordAwareHSSFListener listener = new MissingRecordAwareHSSFListener(this);
            formatListener = new FormatTrackingHSSFListener(listener);
            HSSFEventFactory factory = new HSSFEventFactory();
            HSSFRequest request = new HSSFRequest();
            if (outputFormulaValues) {
                request.addListenerForAllRecords(formatListener);
            } else {
                workbookBuildingListener = new SheetRecordCollectingListener(formatListener);
                request.addListenerForAllRecords(workbookBuildingListener);
            }
            factory.processWorkbookEvents(request, fs);
        } finally {
            // in.close();
        }
    }

    /**
     * HSSFListener 监听方法，处理 Record
     */
    @Override
    @SuppressWarnings("unchecked")
    public void processRecord(Record record) {
        int thisRow = -1;
        int thisColumn = -1;
        String thisStr = null;
        String value = null;
        // List<String> rowlist = new ArrayList<String>();
        switch (record.getSid()) {

        case BoundSheetRecord.sid:
            boundSheetRecords.add(record);
            break;
        case BOFRecord.sid:
            BOFRecord br = (BOFRecord) record;
            if (br.getType() == BOFRecord.TYPE_WORKSHEET) {
                // 如果有需要，则建立子工作薄
                if (workbookBuildingListener != null && stubWorkbook == null) {
                    stubWorkbook = workbookBuildingListener.getStubHSSFWorkbook();
                }

                sheetIndex++;
                // 结束了 初始化行数
                headerNum = true;

                if (orderedBSRs == null) {
                    orderedBSRs = BoundSheetRecord.orderByBofPosition(boundSheetRecords);
                }
                sheetName = orderedBSRs[sheetIndex].getSheetname();

                /** 一个sheet结束了，初始化异常问题 */
                rowNumException = 0;
            }
            break;

        case SSTRecord.sid:
            sstRecord = (SSTRecord) record;
            break;

        case BlankRecord.sid:
            BlankRecord brec = (BlankRecord) record;
            thisRow = brec.getRow();
            thisColumn = brec.getColumn();
            thisStr = "";
            // rowlist.add(thisColumn, thisStr);
            break;
        // 单元格为布尔类型
        case BoolErrRecord.sid:
            BoolErrRecord berec = (BoolErrRecord) record;
            thisRow = berec.getRow();
            thisColumn = berec.getColumn();
            thisStr = berec.getBooleanValue() + "";
            // rowlist.add(thisColumn, thisStr);
            break;
        // 单元格为公式类型
        case FormulaRecord.sid:
            FormulaRecord frec = (FormulaRecord) record;
            thisRow = frec.getRow();
            thisColumn = frec.getColumn();
            if (outputFormulaValues) {
                if (Double.isNaN(frec.getValue())) {
                    // Formula result is a string
                    // This is stored in the next record
                    outputNextStringRecord = true;
                    nextRow = frec.getRow();
                    nextColumn = frec.getColumn();
                } else {
                    thisStr = formatListener.formatNumberDateCell(frec);
                }
            } else {
                thisStr = '"' + HSSFFormulaParser.toFormulaString(stubWorkbook, frec.getParsedExpression()) + '"';
            }
            // rowlist.add(thisColumn, thisStr);
            break;
        // 单元格中公式的字符串
        case StringRecord.sid:
            if (outputNextStringRecord) {
                // String for formula
                StringRecord srec = (StringRecord) record;
                thisStr = srec.getString();
                thisRow = nextRow;
                thisColumn = nextColumn;
                outputNextStringRecord = false;
            }
            break;
        case LabelRecord.sid:
            LabelRecord lrec = (LabelRecord) record;
            curRow = thisRow = lrec.getRow();
            thisColumn = lrec.getColumn();
            value = lrec.getValue().trim();
            thisStr = "".equals(value) ? " " : value;
            // rowlist.add(thisColumn, value);
            break;
        // 单元格为字符串类型
        case LabelSSTRecord.sid:
            LabelSSTRecord lsrec = (LabelSSTRecord) record;
            curRow = thisRow = lsrec.getRow();
            thisColumn = lsrec.getColumn();
            if (sstRecord == null) {
                thisStr = "";
                // rowlist.add(thisColumn, " ");
            } else {
                value = sstRecord.getString(lsrec.getSSTIndex()).toString().trim();
                thisStr = "".equals(value) ? " " : value;
                // rowlist.add(thisColumn, value);
            }
            break;
        // 单元格为数字类型
        case NumberRecord.sid:
            NumberRecord numrec = (NumberRecord) record;
            curRow = thisRow = numrec.getRow();
            thisColumn = numrec.getColumn();

            // value = formatListener.formatNumberDateCell(numrec).trim();

            // 第二种方式，参照formatNumberDateCell里面的实现方法编写
            Double valueDouble = numrec.getValue();
            String formatString = formatListener.getFormatString(numrec);

            if (formatString.contains(ExcelConstant.TIME_M) || formatString.contains(ExcelConstant.TIME_YEAR) || formatString.contains(ExcelConstant.TIME_MON)
                    || formatString.contains(ExcelConstant.TIME_DATE)) {
                formatString = "yyyy-MM-dd hh:mm:ss";
            }
            int formatIndex = formatListener.getFormatIndex(numrec);
            value = formatter.formatRawCellContents(valueDouble, formatIndex, formatString).trim();

            thisStr = "".equals(value) ? " " : value;
            // value = Double.toString(numrec.getValue());
            // 向容器加入列值
            // rowlist.add(thisColumn, value);
            break;
        default:
            break;
        }

        // 遇到新行的操作
        if (thisRow != -1 && thisRow != lastRowNumber) {
            lastColumnNumber = -1;
        }

        // 空值的操作
        if (record instanceof MissingCellDummyRecord) {
            MissingCellDummyRecord mc = (MissingCellDummyRecord) record;
            curRow = thisRow = mc.getRow();
            thisColumn = mc.getColumn();
            // 异常情况：出现的行当中是其中有一个单元格有数据导致 list添加的时候会造成出错
            if (curRow < rowNumException) {
                return;
            }
            thisStr = "";
            // rowlist.add(thisColumn, " ");

        }

        // 添加数据
        // 不是标题栏需要判断数据是否已经超过了标题栏的个数
        if (headerNum || notTitleAndConlumnNumLess(thisColumn)) {
            if (thisStr != null) {
                rowlist.add(thisColumn, thisStr);
            }
        }

        // 更新行和列的值
        if (thisRow > -1) {
            lastRowNumber = thisRow;
        }
        if (thisColumn > -1) {
            lastColumnNumber = thisColumn;
        }
        // 行结束时的操作
        if (record instanceof LastCellOfRowDummyRecord) {

            if (minColumns > 0) {
                // 列值重新置空
                if (lastColumnNumber == -1) {
                    lastColumnNumber = 0;
                }
            }
            lastColumnNumber = -1;

            if (headerNum) {
                columnNum = rowlist.size();
                // 行数增加
                rowNumException++;
            }

            if (!headerNum) {
                // 不是整行空的
                if (rowlist.size() != 0) {
                    // 每行结束时， 调用getRows() 方法
                    if (rowlist.size() < columnNum) {
                        int b = columnNum - rowlist.size();
                        while (b > 0) {
                            rowlist.add("");
                            b--;
                        }

                    }

                    // 回调函数
                    rowReader.getRows(new ArrayList<>(rowlist));
                    // 行数增加
                    rowNumException++;
                }
            }
            // 清空容器
            rowlist.clear();
            headerNum = false;

        }
    }

    /**
     * 数据行小于等于标题行数据
     */
    private boolean notTitleAndConlumnNumLess(int thisColumn) {
        // 标题行 false
        if (headerNum) {
            return false;
        }
        // 数据行满足
        if (thisColumn == -1) {
            return false;
        }
        // 大于标题行
        if (thisColumn > columnNum - 1) {
            return false;
        }
        return true;
    }

}
