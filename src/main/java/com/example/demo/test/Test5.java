package com.example.demo.test;

import java.util.Arrays;

public class Test5 {

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4, 8, 6, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(24.0/4.0);

    }

    private static void sort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
