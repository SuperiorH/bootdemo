package com.example.demo.test;

import java.util.Random;


public class Test4 {

    public static void main(String[] args) {


    }

    private static int getValue() {
        int result;
        Random ran = new Random();
        while (1 == 1) {
            int i = ran.nextInt(2);
            int j = ran.nextInt(2);
            if (i == 0 && j == 1) {
                result = 0;
                break;
            } else if (i == 1 && j == 0) {
                result = 1;
                break;
            } else {
                continue;

            }
        }
        return result;
    }

}
