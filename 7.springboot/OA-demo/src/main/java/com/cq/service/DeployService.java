/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

/**
 * 部署流程service
 * 
 * @since 2018年8月24日 上午10:46:52
 * @author huangyi
 *
 */
public interface DeployService {

    /**
     * 部署流程
     * 
     * @param flowId
     */
    void deploy(Long flowId);

}
