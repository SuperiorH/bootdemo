package com.example.demo.designpattern.decoration;

public class PlayFootball implements Play {

    @Override
    public String getName() {
        return "足球";
    }

    @Override
    public String getDescription() {
        return "这是一个足球";
    }
}
