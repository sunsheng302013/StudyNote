package com.cq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.model.DepartPosition;

@Mapper
public interface DepartPositionDao {

    public List<DepartPosition> selectAllPosition();

    public String selectPositionByPositionId(@Param(value = "positionId") Integer positionId);
}