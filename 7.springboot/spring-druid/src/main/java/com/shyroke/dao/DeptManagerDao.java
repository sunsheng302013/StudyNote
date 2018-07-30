package com.shyroke.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.DeptManager;

@Mapper
public interface DeptManagerDao {
    int deleteByPrimaryKey(int key);

    int insertSelective(DeptManager record);

    DeptManager selectByPrimaryKey(int key);

    int updateByPrimaryKeySelective(DeptManager record);

}