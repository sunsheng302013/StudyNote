/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;
import java.util.List;

import com.cq.model.FlowHistory;
import com.cq.model.Form;

/**
 * 审核展示界面
 * 
 * @since 2018年8月29日 下午2:31:57
 * @author huangyi
 *
 */
public class ExamineResultDTO extends Form implements Serializable {

    private static final long serialVersionUID = -130109993883514784L;

    /** 请假类型 **/
    private String flowName;

    /** 用户名 **/
    private String userName;

    /**
     * 流转历史
     */
    private List<FlowHistory> historyList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public List<FlowHistory> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<FlowHistory> historyList) {
        this.historyList = historyList;
    }

    @Override
    public String toString() {
        return "ExamineResultDTO [flowName=" + flowName + ", userName=" + userName + ", historyList=" + historyList + "]";
    }

}
