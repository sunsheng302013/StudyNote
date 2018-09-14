/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cq.model.Flow;

/**
 * @since 2018年8月31日 上午11:31:49
 * @author chengq
 *
 */
@Service
public interface FlowService {

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

    Flow getByFlowId(Long flowId);
}
