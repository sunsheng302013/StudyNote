package com.cq.model;

import java.util.Date;

public class FlowNode {
    private Integer id;

    /** 流程ID **/
    private Long flowId;

    /** 节点ID **/
    private Long nodeId;

    /** 序列号 **/
    private Integer serialNum;

    /** 节点名称 **/
    private String nodeName;

    /** 类别 开始时间1，用户任务2，排他网关3，结束事件10 **/
    private Integer category;

    /** 是否审核本部门及下属部门 0否，1是 **/
    private Integer isApprove;

    /** 参与者 **/
    private Integer participant;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public Integer getParticipant() {
        return participant;
    }

    public void setParticipant(Integer participant) {
        this.participant = participant;
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
        return "FlowNode [id=" + id + ", flowId=" + flowId + ", nodeId=" + nodeId + ",serialNum=" + serialNum + ", nodeName=" + nodeName + ", category="
                + category + ", isApprove=" + isApprove + ", participant=" + participant + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }
}