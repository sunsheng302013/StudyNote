package com.cq.dao;

import com.cq.model.DictUser;

public interface DictUserMapper {
    int insert(DictUser record);

    int insertSelective(DictUser record);
}