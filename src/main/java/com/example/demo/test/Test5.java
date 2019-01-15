package com.example.demo.test;

public class Test5 {

    public static void main(String[] args) {
        int age = Son.age;
        System.out.println("儿子的年龄:" + age);
    }

}

class Father {
    static int age = 10;

    static {
        System.out.println("父类的静态代码块");
    }

}

class Son extends Father {

    static {
        System.out.println("子类的静态代码块");
    }
}