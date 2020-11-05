
package com.xnj.java;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 15:06
 */
public class SelectSort {

//    public static void sort(int[] arr){
//        if (arr == null || arr.length <2){
//            return;
//        }
//
//        for (int i = 0;i < arr.length;i++){
//            int min =arr[i];
//            int index = i;
//            for (int j = i+1;j < arr.length;j++){
//
//                if (arr[j] < min){
//                    int temp = min;
//                    min = arr[j];
//                    arr[j] = arr[index];
////                    swap(arr,min ,arr[j]);
//
//
//                }
//
//            }
//        }
//    }

    public static void sort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            if (i == minIndex){
                continue;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
