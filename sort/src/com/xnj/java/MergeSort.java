package com.xnj.java;

/**
 * 归并排序
 *
 * @author chen xuanyi
 * @Date 2020/4/13 19:54
 */
public class MergeSort {

    public static void sort(int[] arr, int left, int right) {

        if (arr == null || arr.length == 0){
            return;
        }
        if (left == right){
            return;
        }
        int mid = left + (right - left) / 2;//防溢出
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid, right);


    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        for (int k = 0; k < arr.length; k++) {
            arr[k] = temp[k];
        }


    }


}
