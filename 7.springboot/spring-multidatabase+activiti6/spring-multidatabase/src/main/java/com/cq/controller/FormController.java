/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.util.BaseController;
import com.cq.common.util.JackYunResponse;
import com.cq.common.util.SessionUtil;
import com.cq.dto.FormDTO;
import com.cq.model.Form;
import com.cq.service.FormService;

/**
 * @since 2018年8月27日 上午10:40:05
 * @author xiejy
 *
 */
@RestController
@RequestMapping("/oa/form")
public class FormController extends BaseController {

    /**
     * 请假服务类
     */
    @Autowired
    FormService formService;

    /**
     * 新建请假单
     * 
     * @param form
     *            请假单对象
     * @return data
     */
    @PostMapping("/create")
    public JackYunResponse<Object> createForm(Form form) {
        formService.createForm(form);
        return sendSuccess();
    }

    /**
     * 请假单列表
     * 
     * @return formList 请假单列表
     */
    @GetMapping("/mylist")
    public JackYunResponse<Object> myFormList() {
        Long userId = SessionUtil.get().getUserId();
        List<FormDTO> formList = formService.selectFormById(userId);
        return sendSuccessData(formList);
    }

    /**
     * 更新请假单状态
     * 
     * @param id
     *            请假单Id
     * @param status
     *            请假单状态Id
     * @return data
     */
    @PostMapping("/update")
    public JackYunResponse<Object> updateStatus(Integer id, Integer status) {

        return sendSuccessData(formService.updateStatus(id, status));
    }
}
