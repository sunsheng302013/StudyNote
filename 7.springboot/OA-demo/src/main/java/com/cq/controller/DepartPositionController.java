/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.model.DepartPosition;
import com.cq.service.DepartPositionService;

/**
 * @since 2018年8月28日 下午6:38:42
 * @author chengq
 *
 */
@RestController
@RequestMapping(value = "/oa/departposition")
public class DepartPositionController extends BaseController {

    @Autowired
    DepartPositionService departPositionService;

    @GetMapping("/getposition")
    public JackYunResponse<Object> getDepartPosition() {
        List<DepartPosition> departPositionList = departPositionService.getPosition();
        return sendSuccessData(departPositionList);
    }
}
