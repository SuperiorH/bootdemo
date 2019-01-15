package com.example.demo.test;

public class Test3 {

    public static void main(String[] args) {
        System.out.println(format("A","B"));
    }

    private static String format(String str1,String str2){
        String str = "1%s2%s3";
        return String.format(str,str1,str2);
    }

}
