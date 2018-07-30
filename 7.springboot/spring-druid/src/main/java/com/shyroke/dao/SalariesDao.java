package com.shyroke.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.Salaries;

@Mapper
public interface SalariesDao {
    int deleteByPrimaryKey(int key);

    int insertSelective(Salaries record);

    List<Salaries> selectAll();
    
    Salaries selectByPrimaryKey(int i);

    int updateByPrimaryKeySelective(Salaries record);
}