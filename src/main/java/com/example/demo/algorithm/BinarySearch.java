package com.example.demo.algorithm;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 11, 12, 18};
        int index = search1(arr, 18);
        System.out.println(index);
    }

    /**
     * 非递归二分查找(1)
     *
     * @param array  目标数组
     * @param target 要查找的值
     * @return
     */
    public static int search(int[] array, int target) {
        int middle = (array.length - 1) / 2;
        while (middle >= 0 && middle <= array.length - 1) {
            if (array[middle] > target) {
                middle--;
            } else if (array[middle] < target) {
                middle++;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 非递归二分查找(2)
     *
     * @param array  目标数组
     * @param target 要查找的值
     * @return
     */
    public static int search1(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (target == array[middle]) {
                return middle;
            } else if (target < array[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

}
