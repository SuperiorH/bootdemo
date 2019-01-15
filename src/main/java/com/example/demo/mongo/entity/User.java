package com.example.demo.mongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class User implements Serializable{
    private static final long serialVersionUID = -3258839839160856613L;
    @Id
    private String id;
    private String name;
    private Integer age;
    private String addr;
}
