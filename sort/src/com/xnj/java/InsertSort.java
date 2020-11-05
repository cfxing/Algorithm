package com.xnj.java;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 16:12
 */
public class InsertSort {

    public static void sort(int[] arr){

//        for (int i = 1; i < arr.length; i++) {
//
//            int value = arr[i];
//            int index = i;
//            while (index - 1 > 0 && value < arr[index - 1]){
//                arr[index] = arr[index - 1];
//                index--;
//            }
//            if (index == i ){
//                arr[index] = value;
//            }
//        }

        for (int i = 1; i < arr.length; i++) {

            for (int j = i-1;;) {
                boolean isTrune = false;

                if (j >=0 && arr[j] > arr [j + 1]) {
                    swap(arr, j, j + 1);
                    isTrune = true;
                }
                if (!(isTrune)){
                    break;
                }
                j--;
            }
        }

//        for (int i = 1; i < arr.length; i++) {
//
//            for (int j = i-1;j >=0 && arr[j]<arr[j+1];j--) {
//
//                    swap(arr, j, j + 1);//3359
//                }
//        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
