package com.example.demo.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test4 {

    private int value;

    public static void main(String[] args) throws InterruptedException {
        Test4 test = new Test4();
        test.setValue(0);
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 1; i <= 100; i++) {
            es.execute(() -> test.add());
        }
        Thread.sleep(2000L);
        System.out.println(test.getValue());
        es.shutdown();
    }

    public synchronized void add() {
        value++;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

