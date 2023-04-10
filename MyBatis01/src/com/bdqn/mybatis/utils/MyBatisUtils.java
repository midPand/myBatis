package com.bdqn.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    static{
        InputStream is= null;
        try {
            is = Resources.getResourceAsStream ("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder ().build (is);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    // 获取Sqlsession对象
    public  static SqlSession getSqlSession(){
        return  sqlSessionFactory.openSession ();
    }
    // 关闭Sqlsession
    public static void closeSqlsession(SqlSession  sqlSession){
        sqlSession.close ();
    }
}
