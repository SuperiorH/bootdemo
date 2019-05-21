package com.example.demo.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test3 {

    public static void main(String[] args) throws UnknownHostException {
//        for (int i = 1; i <= 30; i++) {
//            System.out.println(random.nextInt(10));
//        }
        //获取ip地址
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress().toString();
        System.out.println(addr);
        System.out.println(ip);
        System.out.println(Integer.MAX_VALUE);
    }

}
