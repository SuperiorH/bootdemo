package com.example.demo.mongo.dao;

import com.example.demo.mongo.entity.User;

public interface UserDao {


    void saveUser(User user);

    User findUserByName(String userName);


    void updateUser(User user);


    void deleteUserById(Long id);

}
