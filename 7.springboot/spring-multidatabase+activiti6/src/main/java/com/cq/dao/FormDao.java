package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cq.dto.FormDTO;
import com.cq.model.Form;

public interface FormDao {

    /**
     * @param form
     * @return
     */
    int createForm(Form form);

    /**
     * @param id
     * @param status
     */
    int updateStatus(@Param(value = "id") Integer id, @Param(value = "status") Integer status);

    /**
     * @param userId
     * @return
     */
    List<FormDTO> selectFormById(Long userId);

}