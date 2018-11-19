/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DS;
import com.cq.dao.FormDao;
import com.cq.dto.FormDTO;
import com.cq.model.Form;
import com.cq.service.ApplyService;
import com.cq.service.FormService;
import com.cq.service.UserService;

/**
 * @since 2018年8月27日 上午11:32:07
 * @author differ
 *
 */
@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormDao formDao;

    @Autowired
    private ApplyService applyService;

    @Autowired
    private UserService userService;

    @Override
    @DS("datasource1")
    public void createForm(Form form) {
        // 设置状态审批为审批中
        form.setStatus(1);
        // form.setUserId(SessionUtil.get().getUserId());
        Long flowId = form.getFlowId();
        formDao.createForm(form);
        int formId = form.getId();
        applyService.apply(flowId, formId);
    }

    @Override
    @DS
    public int updateStatus(Integer id, Integer status) {

        return formDao.updateStatus(id, status);
    }

    @Override
    @DS
    public List<FormDTO> selectFormById(Long userId) {
        List<FormDTO> formList = formDao.selectFormById(userId);
        for (FormDTO formDTO : formList) {
            formDTO.setUserName(userService.selectNameById(formDTO.getUserId()));
        }
        return formList;
    }

}
