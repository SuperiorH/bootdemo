package com.example.demo.proxy.factory;

public class ToyotaFactory implements Factory{
    @Override
    public Car produceCar() {
        return new ToyotaCar();
    }

    @Override
    public Motor produceMotor() {
        return new ToyotaMotor();
    }

}
