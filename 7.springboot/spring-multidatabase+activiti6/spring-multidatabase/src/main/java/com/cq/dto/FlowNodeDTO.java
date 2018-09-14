/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

/**
 * @since 2018年8月27日 上午9:52:43
 * @author chengq
 *
 */
public class FlowNodeDTO implements Serializable {

    private static final long serialVersionUID = 2197248344704090498L;

    private Integer id;

    /** 流程ID **/
    private Long flowId;

    /** 序列号 **/
    private Integer serialNum;

    /** 节点ID **/
    private Long nodeId;

    /** 节点名称 **/
    private String nodeName;

    /** 类别 开始时间1，用户任务2，排他网关3，结束事件10 **/
    private Integer category;

    /** 参与者 **/
    private Integer participant;

    private String participantName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
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

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getParticipant() {
        return participant;
    }

    public void setParticipant(Integer participant) {
        this.participant = participant;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

}
