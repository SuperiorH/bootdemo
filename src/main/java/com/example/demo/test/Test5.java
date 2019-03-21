package com.example.demo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test5 implements InvocationHandler{

    public static void main(String[] args) {
        int[] array = new int[5];
        System.out.println(Arrays.toString(array));
        new Thread(()-> System.out.println(Thread.currentThread().getName()),"Thread-1").start();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)  {
        return null;
    }
}
