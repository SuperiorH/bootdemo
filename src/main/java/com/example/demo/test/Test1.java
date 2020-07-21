package com.example.demo.test;

import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class Test1 {

    public static void main(String[] args) {

        ExecutorService es = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(),
                (e) -> {
                    Thread thread = new Thread(e);
                    System.out.println("我是线程" + e);
                    return thread;
                }
        );

        for (int i = 1; i <= 10; i++) {
            es.submit(() -> {
                try {
                    Thread.sleep(1000L);
                    System.out.println(Thread.currentThread().getName() + "正在执行！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }


}
