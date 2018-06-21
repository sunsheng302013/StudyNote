package com.mybatis.maper;

import com.mybatis.pojo.Teacher;

/*
 * teacher表和course表关联查询
 */
public interface TeacherAndCourseMapper {

    /*
     * select t.id as t_id, t.name as t_name, t.age as t_age, c.courseName as c_courseName, c.id as C_id
     * from teacher t, course c
     * where t.courseName = c.courseName and t.id = #{id}
     */
    public Teacher getTeacherAndCourse(int id);

}
