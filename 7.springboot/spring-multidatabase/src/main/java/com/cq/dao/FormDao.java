package com.cq.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.Form;

@Mapper
public interface FormDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Form record);

    int insertSelective(Form record);

    Form selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Form record);

    int updateByPrimaryKey(Form record);
}