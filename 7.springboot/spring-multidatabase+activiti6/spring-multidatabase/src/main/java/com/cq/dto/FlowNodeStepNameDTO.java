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
public class FlowNodeStepNameDTO implements Serializable {

    private static final long serialVersionUID = 2197248344704090498L;

    /** 节点ID **/
    private Long nodeId;

    /** 节点名称 **/
    private String nodeName;

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
}
