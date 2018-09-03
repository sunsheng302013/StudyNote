/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cq.dto.FlowDTO;
import com.cq.service.FlowService;

/**
 * @since 2018年8月31日 上午11:30:29
 * @author chengq
 *
 */
@RestController
@RequestMapping("/flow")
public class FlowController {

    @Autowired
    FlowService flowService;

    /**
     * service层使用切库注解，走数据源1
     * 
     * @return
     */
    @RequestMapping(value = "/selectall", method = RequestMethod.GET)
    public List<FlowDTO> selectAllFlow() {
        return flowService.selectAllFlow();
    }

    /**
     * Service层中不添加切库注解，走数据源2
     * 
     * @return
     */
    @RequestMapping(value = "/selectall2", method = RequestMethod.GET)
    public List<FlowDTO> selectAllFlow2() {
        return flowService.selectAllFlow2();
    }
}
