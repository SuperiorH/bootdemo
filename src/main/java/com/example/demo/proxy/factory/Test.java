package com.example.demo.proxy.factory;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        Factory f1 = new HondaFactory();
        Car car1 = f1.produceCar();
        car1.descCar();
        Motor motor1 = f1.produceMotor();
        motor1.descMotor();
        System.out.println("**********");
        Factory f2 = new ToyotaFactory();
        Car car2 = f2.produceCar();
        car2.descCar();
        Motor motor2 = f2.produceMotor();
        motor2.descMotor();
        System.out.println("**********");
        Map<String, String> map = new HashMap<>();
        map.put("language","Java");
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> s : set) {
            String key = s.getKey();
            String value = s.getValue();
            System.out.println(key);
            System.out.println(value);
        }
    }

}
