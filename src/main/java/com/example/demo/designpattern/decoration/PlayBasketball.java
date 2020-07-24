package com.example.demo.designpattern.decoration;

public class PlayBasketball implements Play {
    @Override
    public String getName() {
        return "篮球";
    }

    @Override
    public String getDescription() {
        return "这是一个篮球";
    }
}
