package com.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mybatis.dao.ITeacherDao;
import com.mybatis.maper.TeacherMapper;
import com.mybatis.pojo.Teacher;
import com.mybatis.util.MybatisUtil;

@Repository
public class TeacherDaoImpl implements ITeacherDao {

    /*
     * 通过teacher id查询老师信息
     *
     * @see com.mybatis.dao.ITeacherDao#getTeacherById(int)
     */
    @Override
    public Teacher getTeacherById(int id) {
        System.out.println("TeacherDaoImpl:getTeacherById");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper tm = sqlSession.getMapper(TeacherMapper.class);
        Teacher t = tm.getTeacher(id);
        return t;
    }

    /*
     * 通过teacher name查询
     *
     * @see com.mybatis.dao.ITeacherDao#getTeacherByName(java.lang.String)
     */
    @Override
    public Teacher getTeacherByName(String name) {
        System.out.println("TeacherDaoImpl:getTeacherById");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper tm = sqlSession.getMapper(TeacherMapper.class);
        Teacher t = tm.getTeacher(name);
        return t;
    }

    @Override
    public int deleteTeacher(int id) {
        System.out.println("TeacherDaoImpl:deleteTeacher");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper tm = sqlSession.getMapper(TeacherMapper.class);
        int returnId = tm.deleteTeacher(id);
        sqlSession.commit();
        return returnId;

    }
}
