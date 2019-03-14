package com.example.demo.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
//@Document(indexName = "ecommerce",type = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String desc;
    private Long price;
    private String producer;


}
