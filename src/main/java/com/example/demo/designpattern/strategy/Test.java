package com.example.demo.designpattern.strategy;

public class Test {

    public static void main(String[] args) {
        Context context1 = new Context("bus");
        Context context2 = new Context("subway");
        Context context3 = new Context("bike");
        context1.selectResult();
        context2.selectResult();
        context3.selectResult();
    }
}
