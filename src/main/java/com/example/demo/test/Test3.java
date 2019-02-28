package com.example.demo.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test3 {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress addr = InetAddress.getLocalHost();//        Random random = new Random();
//        for (int i = 1; i <= 30; i++) {
//            System.out.println(random.nextInt(10));
//        }
        String ip = addr.getHostAddress().toString();
        System.out.println(ip);

    }

}
