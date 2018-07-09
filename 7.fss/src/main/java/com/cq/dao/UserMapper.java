package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.UserDTO;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDTO userDTO);

    UserDTO selectByPrimaryKey(String id);

    List<UserDTO> selectUserList();

    int updateUser(UserDTO userDTO);

    Integer updateStatus(@Param("idList") List<Integer> idList);
}