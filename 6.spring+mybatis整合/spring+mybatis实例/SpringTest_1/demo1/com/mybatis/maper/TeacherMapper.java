package com.mybatis.maper;

import com.mybatis.pojo.Teacher;

public interface TeacherMapper {

    public Teacher getTeacher(int id);

    public Teacher getTeacher(String name);

    public int deleteTeacher(int id);
}
