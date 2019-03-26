package com.example.demo.test;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Test5 {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        new Thread(() -> System.out.println(Thread.currentThread().getName()), "Thread-1").start();
        ExecutorService es = Executors.newFixedThreadPool(5);
        String s = "{\"name\":\"Paul\",\"age\":18,\"sex\":\"男\",\"friends\":[\"James\",\"Chris\"]}";
        Person person = JSONObject.parseObject(s, Person.class);
        List<String> list = person.getFriends();
        list.add("Lu");
        System.out.println(list);
    }

}
