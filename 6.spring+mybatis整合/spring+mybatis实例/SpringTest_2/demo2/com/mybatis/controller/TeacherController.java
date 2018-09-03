package com.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mybatis.pojo.Teacher;
import com.mybatis.service.ITeacherService;

@Controller
public class TeacherController {
    @Autowired
    ITeacherService teacherService;

    //ͨ��id����ʦ��Ϣ
    public Teacher getTeacher(int id) {
        Teacher teacher = teacherService.getTeacher(id);
        return teacher;
    }

    //ͨ��name����ʦ��Ϣ
    public Teacher getTeacher(String name) {
        Teacher teacher = teacherService.getTeacher(name);
        return teacher;
    }

    public void deleteTeacher(int id) {
        if (teacherService.deleteTeacher(id)) {
            System.out.println("����ɾ���ɹ�");
        } else {
            System.out.println("����ɾ��ʧ��");
        }
    }
}
