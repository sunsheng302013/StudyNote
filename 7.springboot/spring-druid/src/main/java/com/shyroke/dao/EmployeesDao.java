package com.shyroke.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.Employees;

@Mapper
public interface EmployeesDao {
    int deleteByPrimaryKey(Integer empNo);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer empNo);
    
    List<Employees> selectAll();

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}