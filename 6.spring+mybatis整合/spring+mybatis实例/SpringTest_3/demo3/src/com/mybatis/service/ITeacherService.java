package com.mybatis.service;

import java.util.List;

import com.mybatis.pojo.Teacher;

public interface ITeacherService {

    public Teacher getTeacher(int id);

    public Teacher getTeacher(String name);

    public boolean deleteTeacher(int id);

    public List<Teacher> getTeacherList();
}
