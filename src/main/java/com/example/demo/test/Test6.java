package com.example.demo.test;

import java.util.LinkedList;
import java.util.List;

public class Test6 {

    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                System.out.println("我先执行了！");
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("终于轮到我了！");
        });
        Thread t2 = new Thread(() -> {
            synchronized (o) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("通知前");
                o.notify();
                System.out.println("通知后");
                System.out.println("呵呵呵");
                System.out.println("哈哈哈");
                System.out.println("嘻嘻嘻");
            }
        });
        t1.start();
        t2.start();
        List<Integer> list = new LinkedList<>();
    }

}

