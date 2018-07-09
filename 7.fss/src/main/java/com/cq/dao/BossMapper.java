package com.cq.dao;

import com.cq.model.Boss;

public interface BossMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Boss record);

    int insertSelective(Boss record);

    Boss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Boss record);

    int updateByPrimaryKey(Boss record);
}