package com.cq.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.Form;

@Mapper
public interface FormMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Form record);

    Form selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Form record);

    int updateByPrimaryKey(Form record);
}