package com.xnj.java;

/**
 * @author chen xuanyi
 * @Date 2020/4/20 12:04
 */
public class BinarySearch {

    public static int search(int[] arr, int left, int right, int num) {
        if (arr == null || right - left < 1) {
            if (num == arr[left]) {
                return left;
            }
        }

        int mid = left + (right - left) / 2;

        while (mid > left - 1 || mid < right + 1) {
            if (mid == left) {
                return left;
            }
            if (mid == right) {
                return right;
            }
            if (arr[mid] > num) {//往左边找
                mid = left + (mid - left) / 2;
            } else if (arr[mid] < num) {//往右边找
                mid = (mid + 1) + (right - (mid + 1)) / 2;
            } else {//相等
                return mid;
            }
        }

        throw new RuntimeException("输入的数据查找不到");
    }


    public static int sort2(int[] arr, int left, int right, int num) {
        if (arr == null || arr.length < 1) {
            if (arr[0] == num) {
                return 0;
            }
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] > num) {
            sort2(arr, left, mid, num);
        } else if (arr[mid] < num) {
            sort2(arr, mid + 1, right, num);
        } else {
            return mid;
        }
        throw new RuntimeException("输入错误类型错误");
    }
}
