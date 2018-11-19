/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

/**
 * 流程历史
 * 
 * @since 2018年8月29日 下午2:28:00
 * @author huangyi
 *
 */
public class HistoryDTO implements Serializable {

    private static final long serialVersionUID = -5391512979019956622L;

    private String nodeName;

    private String dateTime;

    private String departmentName;

    private String operator;

    private String comment;

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "HistoryDTO [nodeName=" + nodeName + ", dateTime=" + dateTime + ", departmentName=" + departmentName + ", operator=" + operator + ", comment="
                + comment + "]";
    }

}
