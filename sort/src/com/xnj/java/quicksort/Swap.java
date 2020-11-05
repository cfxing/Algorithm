package com.xnj.java.quicksort;

/**
 * @author chen xuanyi
 * @Date 2020/4/17 12:25
 */
public class Swap {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
