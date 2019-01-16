package com.example.demo.mongo.controller;

import com.example.demo.mongo.dao.UserDao;
import com.example.demo.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private UserDao dao;

    @RequestMapping("/save")
    public String save() {
        User u = new User();
        u.setName("ivy");
        u.setAge(23);
        u.setAddr("江苏省南通市");
        dao.saveUser(u);
        return "1";
    }

}
