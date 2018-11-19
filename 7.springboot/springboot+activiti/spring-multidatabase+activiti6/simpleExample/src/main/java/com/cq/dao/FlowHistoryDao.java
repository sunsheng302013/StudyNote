package com.cq.dao;

import java.util.List;

import com.cq.model.FlowHistory;

public interface FlowHistoryDao {

    int insert(FlowHistory record);

    List<FlowHistory> listByKey(Long businessKey);

}