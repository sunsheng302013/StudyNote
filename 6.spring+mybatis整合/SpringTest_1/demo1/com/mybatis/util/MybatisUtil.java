package com.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

    private static SqlSessionFactory factory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        if (factory == null) {
            InputStream inputStream = MybatisUtil.class.getResourceAsStream("mybatisConfig.xml");
            return new SqlSessionFactoryBuilder().build(inputStream);
        }
        return factory;
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }
}
