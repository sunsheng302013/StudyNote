package com.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.ITeacherDao;
import com.mybatis.pojo.Teacher;
import com.mybatis.service.ITeacherService;

@Service(value = "teacherService")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    ITeacherDao teacherDaoImpl;

    @Override
    public Teacher getTeacher(int id) {

        return teacherDaoImpl.getTeacherById(id);
    }

    @Override
    public Teacher getTeacher(String name) {

        return teacherDaoImpl.getTeacherByName(name);
    }

    @Override
    public boolean deleteTeacher(int id) {
        int f = teacherDaoImpl.deleteTeacher(id);
        if (f != 0) {
            return true;
        }
        return false;
    }
}
