package com.example.demo.excel.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String name;
    private Integer age;
    private String classes;

//    public Student(String name, Integer age, String classes) {
//        this.name = name;
//        this.age = age;
//        this.classes = classes;
//    }
//
//    public Student() {
//    }

    public Student(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Joe", 10, "class1"));
        list.add(new Student("Joe", 11, "class1"));

        list.add(new Student("Max", 12, "class2"));
        list.add(new Student("Max", 13, "class2"));

        list.add(new Student("Wade", 14, "class3"));
        list.add(new Student("Wade", 15, "class3"));

        list.add(new Student("James", 16, "class4"));
        list.add(new Student("James", 17, "class4"));

        Integer v1 = list.stream().map(Student::getAge).filter((e) -> e >= 12).min(Integer::compare).get();
        Integer v2 = list.stream().map(Student::getAge).filter((e) -> e < 16).max(Integer::compare).get();
        list.sort(Comparator.comparing(Student::getAge).reversed());
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Student::getAge, Student::getName));
        System.out.println(map);
//        System.out.println(list);
//        System.out.println(v1);
//        System.out.println(v2);

//        Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
//        System.out.println(map.size());
//        map.forEach((k, v) -> System.out.println(k + "=" + v));
//        System.out.println(list.stream().map(Student::getAge).mapToInt((e) -> e).sum());
//        System.out.println(list.stream().map(Student::getAge).mapToInt((e) -> e).average().getAsDouble());
//        System.out.println(list.stream().map(Student::getAge).mapToInt((e) -> e).max().getAsInt());
//        System.out.println(list.stream().mapToInt(Student::getAge).min().getAsInt());


    }

}
