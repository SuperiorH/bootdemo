package com.example.demo.test.callback;

import java.util.Arrays;
import java.util.Map;

public class Test {

    private static void sort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void sort(MyCompare[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j].compare(arr[j + 1]) > 0) {
                    MyCompare temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1, 7, 9, 4, 8, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("*****分割线*****");
        Student[] students = {
                new Student("刘为", 160.0, 20),
                new Student("造船", 180.0, 22),
                new Student("胖子", 170.0, 18),
                new Student("Joe", 175.0, 15)
        };
        sort(students);
        System.out.println(Arrays.toString(students));
    }


}
