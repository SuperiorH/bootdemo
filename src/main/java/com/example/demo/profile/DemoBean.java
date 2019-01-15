package com.example.demo.profile;

import lombok.Data;

@Data
public class DemoBean {

    private String name;

    public DemoBean(String name) {
        this.name = name;
    }

}
