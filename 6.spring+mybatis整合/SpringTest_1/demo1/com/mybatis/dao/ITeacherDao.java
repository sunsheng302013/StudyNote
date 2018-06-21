package com.mybatis.dao;

import com.mybatis.pojo.Teacher;

public interface ITeacherDao {

    public Teacher getTeacherById(int id);

    public Teacher getTeacherByName(String name);

    public int deleteTeacher(int id);
}
