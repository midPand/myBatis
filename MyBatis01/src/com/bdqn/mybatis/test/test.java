package com.bdqn.mybatis.test;

import com.bdqn.mybatis.dao.UserMapper;
import com.bdqn.mybatis.entity.User;
import com.bdqn.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class  test {

    @Test
    public void findAll()throws Exception{
            InputStream inputStream= Resources.getResourceAsStream ("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder ();
            SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build (inputStream);
            SqlSession  sqlSession=sqlSessionFactory.openSession ();
            UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
            List<User> userList=userMapper.findAll ();
            for(User user:userList){
                System.out.println(user);
            }
            sqlSession.close ();
    }
    @Test
    public void addUser(){
        User user=new User ();
        user.setUserCode ("fanghao");
        user.setUserName ("方豪");
        user.setUserPassword ("456789");
        user.setGender (0);
        user.setPhone ("741852963");
        user.setAddress ("adasdasdasdasd");
        user.setUserRole (1);
        SqlSession sqlSession= MyBatisUtils.getSqlSession ();
        UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
        userMapper.addUser (user);
        sqlSession.commit ();
        MyBatisUtils.closeSqlsession (sqlSession);
    }
    @Test
    public void updateUser(){
        User user=new User ();
        user.setUserName ("李启");
        user.setId (40);
        SqlSession sqlSession= MyBatisUtils.getSqlSession ();
        UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
        userMapper.updateUser (user);
        sqlSession.commit ();
        MyBatisUtils.closeSqlsession (sqlSession);
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession ();
        UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
        userMapper.deleteUser (40);
        sqlSession.commit ();
        MyBatisUtils.closeSqlsession (sqlSession);
    }

    @Test
    public void findById(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession ();
        UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
        User user=userMapper.findById (39);
        System.out.println(user);
        sqlSession.commit ();
        MyBatisUtils.closeSqlsession (sqlSession);
    }

    @Test
    public void findByName(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession ();
        UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
        List<User> userList=userMapper.findByName ("李");
        for(User user:userList){
            System.out.println(user);
        }
        sqlSession.commit ();
        MyBatisUtils.closeSqlsession (sqlSession);
    }

    @Test
    public void getCount(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession ();
        UserMapper userMapper=sqlSession.getMapper (UserMapper.class);
        int i=userMapper.getCount ();
        System.out.println(i);
        sqlSession.commit ();
        MyBatisUtils.closeSqlsession (sqlSession);
    }
}
