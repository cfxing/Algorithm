package com.xnj.java;

import java.lang.annotation.Target;

/**
 * 冒泡排序
 *
 * @author chen xuanyi
 * @Date 2020/4/13 14:26
 */
public class BubbleSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        for (int end = arr.length - 1;end > 0;end --){
            for (int i = 0; i < end ; i++){
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }


//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = i+1; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j+1]){
//                    int temp;
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}
