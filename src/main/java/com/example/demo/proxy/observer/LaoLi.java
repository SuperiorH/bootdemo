package com.example.demo.proxy.observer;

public class LaoLi implements People{
    String name = "老李";

    @Override
    public void getMessage(String message) {
        System.out.println(name + "接到了小美打过来的电话，电话内容是：" + message );
    }
}
