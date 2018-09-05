package com.cq.model;

import java.util.Date;

public class NodeCondition {

    private Integer id;

    /** 当前节点 **/
    private Long nodeId;

    /** 下一步节点 **/
    private Long nextNodeId;

    /** 表单字段 **/
    private String formAttribute;

    /** 表单属性操作符 **/
    private String operateCondition;

    /** 表单属性值 **/
    private String formValue;

    private Date gmtCreate;

    private Date gmtModified;

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

    @Override
    public String toString() {
        return "NodeCondition [id=" + id + ", nodeId=" + nodeId + ", nextNodeId=" + nextNodeId + ", formAttribute=" + formAttribute + ", operateCondition="
                + operateCondition + ", formValue=" + formValue + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
}