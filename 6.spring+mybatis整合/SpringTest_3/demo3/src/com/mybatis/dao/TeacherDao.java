package com.mybatis.dao;

import java.util.List;

import com.mybatis.pojo.Teacher;

public interface TeacherDao {

    public Teacher getTeacher(int id);

    public Teacher getTeacher(String name);

    public int deleteTeacher(int id);

    public List<Teacher> getTeacherList();

}
