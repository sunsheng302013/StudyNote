/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 导入接收
 *
 * @since 2017年12月12日 下午2:51:21
 * @author huangyi
 *
 */
public class ImportExcelDTO implements Serializable {

    private static final long serialVersionUID = -605304948533624798L;

    /** 文件路径 **/
    private String path;

    /** importType **/
    private String importType;

    /** 用户选择后对应英文名称 **/
    private String[] headValues;

    /** 用户选择后对应的下标 **/
    private String[] indexValues;

    /** 用户Excel标题头 **/
    private String[] userHeadValues;

    /****/

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String[] getHeadValues() {
        return headValues;
    }

    public void setHeadValues(String[] headValues) {
        this.headValues = headValues;
    }

    public String[] getIndexValues() {
        return indexValues;
    }

    public void setIndexValues(String[] indexValues) {
        this.indexValues = indexValues;
    }

    public String[] getUserHeadValues() {
        return userHeadValues;
    }

    public void setUserHeadValues(String[] userHeadValues) {
        this.userHeadValues = userHeadValues;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ImportExcelDTO [path=");
        builder.append(path);
        builder.append(", importType=");
        builder.append(importType);
        builder.append(", headValues=");
        builder.append(Arrays.toString(headValues));
        builder.append(", indexValues=");
        builder.append(Arrays.toString(indexValues));
        builder.append(", userHeadValues=");
        builder.append(Arrays.toString(userHeadValues));
        builder.append("]");
        return builder.toString();
    }

}
