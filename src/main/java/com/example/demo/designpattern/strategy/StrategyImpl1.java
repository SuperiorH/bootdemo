package com.example.demo.designpattern.strategy;

public class StrategyImpl1 implements Strategy{
    @Override
    public void select() {
        System.out.println("坐公交");
    }
}
