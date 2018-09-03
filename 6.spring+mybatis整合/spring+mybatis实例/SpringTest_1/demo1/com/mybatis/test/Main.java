package com.mybatis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.controller.TeacherController;

public class Main {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        TeacherController tc = ac.getBean(TeacherController.class);

        tc.deleteTeacher(2);
    }
}
