package com.example.demo.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "accounts",type = "person")
public class Person {
    private String id;
    private String user;
    private String title;
    private String desc;

    public Person(String id, String user, String title, String desc) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.desc = desc;
    }

    public Person() {
    }
}
