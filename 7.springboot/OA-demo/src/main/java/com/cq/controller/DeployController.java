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
import com.cq.service.DeployService;

/**
 * 发布流程并生成部署文件
 *
 *
 * @since 2018年8月24日 上午10:39:26
 * @author huangyi
 *
 */
@RestController
@RequestMapping("/oa")
public class DeployController extends BaseController {

    @Autowired
    private DeployService deployService;

    /**
     * 生成xml文档
     * 
     * @param flowId
     *            流程Id
     * @return data
     */
    @PostMapping("/deploy")
    public JackYunResponse<Object> deploy(Long flowId) {
        deployService.deploy(flowId);
        return sendSuccess();
    }
}
