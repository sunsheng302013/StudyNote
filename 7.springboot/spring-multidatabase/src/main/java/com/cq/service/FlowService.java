/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cq.dto.FlowDTO;

/**
 * @since 2018年8月31日 上午11:31:49
 * @author chengq
 *
 */
@Service
public interface FlowService {

    public List<FlowDTO> selectAllFlow();

    List<FlowDTO> selectAllFlow2();
}
