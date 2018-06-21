package com.mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.controller.TeacherController;
import com.mybatis.pojo.Teacher;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        TeacherController tc = ac.getBean(TeacherController.class);

        Teacher t = tc.getTeacher(4);

        System.out.println("name:" + t.getName());
    }
}
