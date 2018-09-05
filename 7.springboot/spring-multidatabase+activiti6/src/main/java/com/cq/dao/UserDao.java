package com.cq.dao;

import java.util.List;

import com.cq.model.User;

public interface UserDao {

    List<User> login(User user);

    /**
     * @param userId
     * @return
     */
    String selectNameById(Long userId);

}