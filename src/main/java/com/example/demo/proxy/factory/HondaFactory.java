package com.example.demo.proxy.factory;

public class HondaFactory implements Factory{

    @Override
    public Car produceCar() {
        return new HondaCar();
    }

    @Override
    public Motor produceMotor() {
        return new HondaMotor();
    }

}
