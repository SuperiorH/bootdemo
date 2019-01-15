package com.example.demo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.event")
public class DemoConfiguration {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DemoConfiguration.class);
        DemoPublisher publisher = ac.getBean("demoPublisher",DemoPublisher.class);
//      System.out.println(publisher);
        publisher.publish("啊哈哈哈哈哈哈哈");
    }

}
