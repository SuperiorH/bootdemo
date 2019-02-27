package com.example.demo.test.callback;

import lombok.Data;

@Data
public class Student implements MyCompare {
    private String name;
    private Double height;
    private Integer age;

    public Student(String name, Double height, Integer age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    @Override
    public int compare(MyCompare myCompare) {
        Student s = (Student) myCompare;
        int diff = this.age - s.age;
        return diff > 0 ? 1 : ((diff == 0) ? 0 : -1);
    }

}
