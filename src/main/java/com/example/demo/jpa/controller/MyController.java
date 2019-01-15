package com.example.demo.jpa.controller;

import com.example.demo.jpa.entity.UseBuyerCollect;
import com.example.demo.jpa.repository.UseBuyerCollectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class MyController {

    @Autowired
    private UseBuyerCollectRepository repository;

    @RequestMapping("/m1/{userId}")
    public List<UseBuyerCollect> m1(@PathVariable String userId) {
        return repository.findByUserId(userId);
    }

    @RequestMapping("/m2/{userId}")
    public Integer m2(@PathVariable String userId) {
        return repository.countByUserId(userId);
    }

    @RequestMapping("/m3")
    public String m3() {
        UseBuyerCollect collect = new UseBuyerCollect("hehe", "ea16edc8a92b4e1e9ac3dfe7783781f2", 1, new Date(), new Date());
        repository.save(collect);
        return "insert success";
    }

    @RequestMapping("/m4/{collectType}/{id}")
    public int m4(@PathVariable Integer collectType, @PathVariable String id) {
        return repository.modifyById(collectType,id);
    }

}
