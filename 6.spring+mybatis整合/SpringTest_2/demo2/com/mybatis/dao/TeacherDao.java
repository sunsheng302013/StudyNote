package com.mybatis.dao;

import com.mybatis.pojo.Teacher;

public interface TeacherDao {

    public Teacher getTeacher(int id);

    public Teacher getTeacher(String name);

    public int deleteTeacher(int id);
}
