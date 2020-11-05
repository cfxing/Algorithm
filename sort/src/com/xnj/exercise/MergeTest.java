package com.xnj.exercise;

import com.xnj.java.MergeSort;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 20:38
 */
public class MergeTest {

    public static void main(String[] args) {
        int[] arr ={3,45,6,1,7,8};
        MergeSort.sort(arr,0,arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
