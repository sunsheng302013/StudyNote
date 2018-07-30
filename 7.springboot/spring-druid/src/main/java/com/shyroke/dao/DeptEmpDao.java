package com.shyroke.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.DeptEmp;

@Mapper
public interface DeptEmpDao {
    int deleteByPrimaryKey(int key);

    int insertSelective(DeptEmp record);

    DeptEmp selectByPrimaryKey(int key);

    int updateByPrimaryKeySelective(DeptEmp record);

}