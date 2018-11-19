package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.User;

@Mapper
public interface UserDao {

    List<User> login(User user);

    /**
     * @param userId
     * @return
     */
    String selectNameById(Long userId);

}