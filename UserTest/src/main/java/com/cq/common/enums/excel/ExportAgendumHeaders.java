/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums.excel;

import com.cq.common.enums.ExportExcelEnumInterface;

/**
 * <p>
 * 类描述:日程导出固定excel字段名
 * </p>
 *
 * @since 2018年10月8日
 * @author chengq
 */
public enum ExportAgendumHeaders implements ExportExcelEnumInterface {

    /** 姓名 **/
    PARTICIPANTUSERNAME("participantUserName", ExcelDataType.STRING.getCode()),

    /** 日程标题 **/
    TITLE("title", ExcelDataType.STRING.getCode()),

    /** 日程开始时间 **/
    STARTTIME("startTime", ExcelDataType.STRING.getCode()),

    /** 日程结束时间 **/
    ENDTIME("endTime", ExcelDataType.STRING.getCode()),

    /** 地点 **/
    LOCATIONNAME("locationName", ExcelDataType.STRING.getCode()),

    /** 日程内容 **/
    CONTENT("content", ExcelDataType.STRING.getCode()),

    /** 重要日程 **/
    ISIMPORTANT("isImportant", ExcelDataType.STRING.getCode());

    private String dbName;
    private Integer dataType;

    @Override
    public String getDbName() {
        return dbName;
    }

    /**
     *
     * @param dbName
     *            需要设置的dbName
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public Integer getDataType() {
        return dataType;
    }

    /**
     *
     * @param dataType
     *            需要设置的dataType
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     *
     * @param dbName
     *            需要设置的dbName
     * @param dataType
     *            需要设置的dataType
     */
    ExportAgendumHeaders(String dbName, Integer dataType) {
        this.dbName = dbName;
        this.dataType = dataType;
    }

}
