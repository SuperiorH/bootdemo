package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

    @Autowired
    private ApplicationContext ac;

    public void publish(String msg) {
        ac.publishEvent(new DemoEvent(this, msg));
    }




}
