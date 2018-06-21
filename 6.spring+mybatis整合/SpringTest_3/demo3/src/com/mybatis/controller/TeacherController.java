package com.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.pojo.Teacher;
import com.mybatis.service.ITeacherService;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    @Qualifier("teacherService")
    ITeacherService teacherService;

    @RequestMapping("selectOne")
    public ModelAndView searchOne(HttpServletRequest request, HttpServletResponse response) {
        Teacher teacher = teacherService.getTeacher(1);
        ModelAndView mav = new ModelAndView("loginForm");
        System.out.println(teacher.getAge());
        mav.addObject("age", 4);
        mav.addObject("teacher", teacher);
        return mav;
    }

    @RequestMapping("/teacherList")
    public ModelAndView searchAll(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("teacherList---->Start");
        List<Teacher> tl = teacherService.getTeacherList();
        System.out.println("查询成功");
        ModelAndView mav = new ModelAndView("teacherList");
        mav.addObject("teacherList", tl);
        return mav;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String resetUserPwd(String id) {

        int int_id = Integer.parseInt(id);

        System.out.println("delete:" + int_id);

        String msg = "用户删除失败";
        if (this.teacherService.deleteTeacher(int_id)) {
            msg = "用户删除成功";
        }
        return msg;
    }

    public List<Teacher> getTeacherList() {
        List<Teacher> teacherList = teacherService.getTeacherList();
        return teacherList;
    }
}
