package com.cq.model;

import java.io.Serializable;
import java.util.Date;

public class Flow implements Serializable {

    private static final long serialVersionUID = -3863236019032004395L;

    private Integer id;

    private Long flowId;

    private String flowName;

    private String flowDescription;

    /** bpmn文件 process id **/
    private String processkey;

    private Date gmtCreate;

    private Date gmtModified;

    public String getProcesskey() {
        return processkey;
    }

    public void setProcesskey(String processkey) {
        this.processkey = processkey;
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

    public String getFlowDescription() {
        return flowDescription;
    }

    public void setFlowDescription(String flowDescription) {
        this.flowDescription = flowDescription;
    }

    @Override
    public String toString() {
        return "Flow [id=" + id + ", flowId=" + flowId + ", flowName=" + flowName + ", flowDescription=" + flowDescription + ", processkey=" + processkey
                + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }

}