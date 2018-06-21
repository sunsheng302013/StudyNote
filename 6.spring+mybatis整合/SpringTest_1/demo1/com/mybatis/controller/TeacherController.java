package com.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mybatis.pojo.Teacher;
import com.mybatis.service.ITeacherService;

@Controller
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    //通过id查老师信息
    public Teacher getTeacher(int id) {
        Teacher teacher = teacherService.getTeacher(id);
        return teacher;
    }

    //通过name查老师信息
    public Teacher getTeacher(String name) {
        Teacher teacher = teacherService.getTeacher(name);
        return teacher;
    }

    public void deleteTeacher(int id) {
        if (teacherService.deleteTeacher(id)) {
            System.out.println("数据删除成功");
        } else {
            System.out.println("数据删除失败");
        }
    }
}
