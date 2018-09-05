/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @since 2018年8月29日 上午11:55:13
 * @author chengq
 *
 */
public class NodeConditionDTO implements Serializable {

    private static final long serialVersionUID = 7585809586809374032L;

    private Integer id;

    /** 当前节点 **/
    private Long nodeId;

    /** 下一步节点 **/
    private Long nextNodeId;

    private String nextNodeName;

    /** 表单字段 **/
    private String formAttribute;

    /** 表单属性操作符 **/
    private String operateCondition;

    /** 表单属性值 **/
    private String formValue;

    private String stepCondition;

    private Date gmtCreate;

    private Date gmtModified;

    /** 下一步骤类型 **/
    private Integer category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(Long nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    public String getNextNodeName() {
        return nextNodeName;
    }

    public void setNextNodeName(String nextNodeName) {
        this.nextNodeName = nextNodeName;
    }

    public String getFormAttribute() {
        return formAttribute;
    }

    public void setFormAttribute(String formAttribute) {
        this.formAttribute = formAttribute == null ? null : formAttribute.trim();
    }

    public String getOperateCondition() {
        return operateCondition;
    }

    public void setOperateCondition(String operateCondition) {
        this.operateCondition = operateCondition == null ? null : operateCondition.trim();
    }

    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue == null ? null : formValue.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getStepCondition() {
        return stepCondition;
    }

    public void setStepCondition(String stepCondition) {
        this.stepCondition = stepCondition;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

}
