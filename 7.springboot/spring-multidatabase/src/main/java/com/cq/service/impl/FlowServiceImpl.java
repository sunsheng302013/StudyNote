/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.FlowDao;
import com.cq.dto.FlowDTO;
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
    public List<FlowDTO> selectAllFlow() {
        return flowDao.selectAll();
    }

    @Override
    public List<FlowDTO> selectAllFlow2() {
        return flowDao.selectAll();
    }

}
