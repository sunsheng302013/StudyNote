package com.cq.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.User;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}