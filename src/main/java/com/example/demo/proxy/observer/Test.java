package com.example.demo.proxy.observer;

public class Test {
    public static void main(String[] args) {
        People p1 = new LaoWang();
        People p2 = new LaoLi();
        Beauty beauty = new Beauty();
        beauty.addPeople(p1);
        beauty.addPeople(p2);
        beauty.notifyPeople();
    }
}
