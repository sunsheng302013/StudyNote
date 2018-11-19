/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.FlowDao;
import com.cq.model.Flow;
import com.cq.service.FlowService;

/**
 * @since 2018年8月31日 上午11:32:22
 * @author chengq
 *
 */
@Service
public class FlowServiceImpl implements FlowService {

    @Autowired
    FlowDao flowDao;

    @Override
    @DS("datasource1")
    public int create(Flow flow) {
        Long longTime = new Date().getTime();
        flow.setFlowId(longTime);
        return flowDao.create(flow);
    }

    @Override
    public int update(Flow flow) {
        return 0;
    }

    @Override
    public int deleteByFlowId(Long flowId) {
        return 0;
    }

    @Override
    public List<Flow> list() {
        return null;
    }

    @Override
    public Flow getByFlowId(Long flowId) {
        return null;
    }
}
