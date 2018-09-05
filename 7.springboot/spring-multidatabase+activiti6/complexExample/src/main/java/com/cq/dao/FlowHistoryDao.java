package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.FlowHistory;

@Mapper
public interface FlowHistoryDao {

    int insert(FlowHistory record);

    List<FlowHistory> listByKey(Long businessKey);

}