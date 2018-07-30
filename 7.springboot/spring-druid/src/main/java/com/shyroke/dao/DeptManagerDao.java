package com.shyroke.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.DeptManager;
import com.shyroke.model.DeptManagerKey;

@Mapper
public interface DeptManagerDao {
    int deleteByPrimaryKey(DeptManagerKey key);

    int insert(DeptManager record);

    int insertSelective(DeptManager record);

    DeptManager selectByPrimaryKey(DeptManagerKey key);

    int updateByPrimaryKeySelective(DeptManager record);

    int updateByPrimaryKey(DeptManager record);
}