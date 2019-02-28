package com.example.demo.test;

import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationHandler;

public class Test2 {
    public static void main(String[] args) {
        Class c1 = String.class;
        Class c2 = Integer.class;
        Class c3 = InvocationHandler.class;
        Class c4 = Bean.class;
        Class[] arr = {c1, c2, c3, c4};
        Class c5 = arr[2];
        Class c6 = arr[3];
        System.out.println(c5.isInterface());
        System.out.println(c6.isAnnotation());
    }
}
