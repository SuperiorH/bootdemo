package com.example.demo.algorithm;

public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {11, 6, 9, 12, 18, 5, 8};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        int index = search(arr, 11);
//        System.out.println(index);
//        System.out.println("***这是分割线***");
//        int val = factorial(7);
//        System.out.println(val);
//        System.out.println("***这是分割线***");
//        Map<String, String> map = new HashMap<>();
//        map.forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println(Runtime.getRuntime().maxMemory());
    }

    private static int search(int[] arr, int value) {
        int mid = (arr.length - 1) / 2;
        while (mid <= arr.length - 1 && mid >= 0) {
            if (arr[mid] < value) {
                mid++;
            } else if (arr[mid] > value) {
                mid--;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
