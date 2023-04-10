package com.bdqn.mybatis.dao;

import com.bdqn.mybatis.entity.User;

import java.util.List;

public interface UserMapper  {

    public List<User> findAll();

    public  void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    public User findById(int id );

    public  List<User> findByName(String name);

    public int getCount();
}
