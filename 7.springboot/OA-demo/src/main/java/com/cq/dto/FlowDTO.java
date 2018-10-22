package com.cq.dto;

import java.io.Serializable;
import java.util.List;

import com.cq.model.FlowNode;

public class FlowDTO implements Serializable {

    private static final long serialVersionUID = 4927870239969711917L;

    private Integer id;

    private Long flowId;

    private String flowName;

    private String processkey;

    private List<FlowNode> nodes;

    public String getProcesskey() {
        return processkey;
    }

    public void setProcesskey(String processkey) {
        this.processkey = processkey;
    }

    public List<FlowNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<FlowNode> nodes) {
        this.nodes = nodes;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

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

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    @Override
    public String toString() {
        return "FlowDTO [id=" + id + ", flowId=" + flowId + ", flowName=" + flowName + ", nodes=" + nodes + "]";
    }

}