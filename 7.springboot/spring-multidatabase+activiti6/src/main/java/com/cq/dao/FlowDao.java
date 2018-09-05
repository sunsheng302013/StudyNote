package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.Flow;

@Mapper
public interface FlowDao {

    /**
     * @param flow
     * @return
     */
    int create(Flow flow);

    /**
     * @param flow
     * @return
     */
    int update(Flow flow);

    /**
     * @param flowId
     * @return
     */
    int deleteByFlowId(Long flowId);

    /**
     * @return
     */
    List<Flow> list();

    /**
     * @param flowId
     * @return
     */
    Flow getByFlowId(Long flowId);

}