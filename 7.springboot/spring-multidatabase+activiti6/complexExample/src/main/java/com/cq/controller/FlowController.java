/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.model.Flow;
import com.cq.service.FlowService;

/**
 * @since 2018年8月31日 上午11:30:29
 * @author chengq
 *
 */
@RestController
@RequestMapping("/flow")
public class FlowController extends BaseController {

    @Autowired
    FlowService flowService;

    @PostMapping("/create")
    public JackYunResponse<Object> createFlow(Flow flow) {
        Integer i = flowService.create(flow);
        return sendSuccessData(i);
    }
}
