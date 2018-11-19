/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.service;

import java.util.List;

import com.cq.dto.FormDTO;
import com.cq.model.Form;

/**
 * @since 2018年8月27日 上午11:30:22
 * @author differ
 *
 */
public interface FormService {

    /**
     * @param form
     * @return
     */
    void createForm(Form form);

    int updateStatus(Integer id, Integer status);

    /**
     * @param userId
     * @return
     */
    List<FormDTO> selectFormById(Long userId);

}
