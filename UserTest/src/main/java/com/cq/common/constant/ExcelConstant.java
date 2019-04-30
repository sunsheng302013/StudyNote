/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.constant;

/**
 * <p>
 * 类描述: excel用到的常量
 * </p>
 * 
 * @since 2018年11月27日
 * @author chengq
 */
public class ExcelConstant {
    /**
     * 时间类型
     */
    public static final String TIME_M = "m/";
    /** 时间类型 */
    public static final String TIME_YEAR = "年";
    /** 时间类型 */
    public static final String TIME_MON = "月";
    /** 时间类型 */
    public static final String TIME_DATE = "日";

    /**
     * 数字类型
     *
     */
    public static final int NUMBER_EIGHT = 8;

    /**
     * 字符串类型
     */
    /** false */
    public static final String FALSE = "FALSE";
    /** true */
    public static final String TRUE = "TRUE";

    /**
     * 数据类型 标签
     */
    /** 布尔 */
    public static final String BOOLEAN = "b";
    /** 错误 **/
    public static final String ERROR = "e";
    /** 字符串，直接存在cell */
    public static final String INLINESTR = "inlineStr";
    /** 字符串 */
    public static final String FORMULA = "str";
    /** s标签，数据类型为SST */
    public static final String SSTINDEX = "s";
    /** 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引 */
    public static final String VINDEX = "v";
    /** c标签 单元格 */
    public static final String CINDEX = "c";
    /**
     * 如果标签名称为 row ，这说明已到行尾，调用 optRows() 方法
     */
    public static final String ROW = "row";
    /** 单元格值 */
    public static final String COLUM_DATA = "r";
    /** 样式 */
    public static final String TTYPE = "t";

    /**
     *
     */
    private ExcelConstant() {
        super();
    }

}
