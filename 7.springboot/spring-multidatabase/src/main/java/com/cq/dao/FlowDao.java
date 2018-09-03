/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.dto.FlowDTO;

/**
 * @since 2018年8月31日 上午11:41:00
 * @author chengq
 *
 */
@Mapper
public interface FlowDao {

    int deleteByPrimaryKey(Integer id);

    int insert(FlowDTO record);

    int insertSelective(FlowDTO record);

    List<FlowDTO> selectAll();

    int updateByPrimaryKeySelective(FlowDTO record);

    int updateByPrimaryKey(FlowDTO record);
}
