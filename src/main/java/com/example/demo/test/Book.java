package com.example.demo.test;

import lombok.Data;

@Data
public class Book {

    private String name;
    private Integer page;

    public Book(String name, Integer page) {
        this.name = name;
        this.page = page;
    }



}
