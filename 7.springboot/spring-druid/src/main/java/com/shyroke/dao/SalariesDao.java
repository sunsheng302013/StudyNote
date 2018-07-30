package com.shyroke.dao;

import org.apache.ibatis.annotations.Mapper;

import com.shyroke.model.Salaries;
import com.shyroke.model.SalariesKey;

@Mapper
public interface SalariesDao {
    int deleteByPrimaryKey(SalariesKey key);

    int insert(Salaries record);

    int insertSelective(Salaries record);

    Salaries selectByPrimaryKey(SalariesKey key);

    int updateByPrimaryKeySelective(Salaries record);

    int updateByPrimaryKey(Salaries record);
}