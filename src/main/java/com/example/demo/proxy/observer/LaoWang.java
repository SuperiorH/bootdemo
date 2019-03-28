package com.example.demo.proxy.observer;

public class LaoWang implements People{
    public LaoWang(String name) {
        this.name = name;
    }

    public LaoWang() {
    }

    String name = "老王";

    @Override
    public void getMessage(String message) {
        System.out.println(name + "接到了小美打过来的电话，电话内容是：" + message );
    }

    public static void main(String[] args) {

    }



}
