package com.shyroke.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.DeptEmp;
import com.shyroke.model.DeptEmpKey;

@Mapper
public interface DeptEmpDao {
    int deleteByPrimaryKey(DeptEmpKey key);

    int insert(DeptEmp record);

    int insertSelective(DeptEmp record);

    DeptEmp selectByPrimaryKey(DeptEmpKey key);

    int updateByPrimaryKeySelective(DeptEmp record);

    int updateByPrimaryKey(DeptEmp record);
}