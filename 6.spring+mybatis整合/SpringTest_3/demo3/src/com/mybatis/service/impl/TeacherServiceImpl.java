package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.TeacherDao;
import com.mybatis.pojo.Teacher;
import com.mybatis.service.ITeacherService;

@Service(value = "teacherService")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Override
    public Teacher getTeacher(int id) {

        return teacherDao.getTeacher(id);
    }

    @Override
    public Teacher getTeacher(String name) {

        return teacherDao.getTeacher(name);
    }

    @Override
    public boolean deleteTeacher(int id) {
        int f = teacherDao.deleteTeacher(id);
        if (f != 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Teacher> getTeacherList() {
        // TODO Auto-generated method stub
        return teacherDao.getTeacherList();
    }
}
