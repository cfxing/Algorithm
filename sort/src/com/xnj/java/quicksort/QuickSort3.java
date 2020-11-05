package com.xnj.java.quicksort;

/**
 * @author chen xuanyi
 * @Date 2020/4/16 21:50
 */
public class QuickSort3 {

    public static void sort(int[] arr, int left, int right){
        if (arr == null || arr.length < 2){
            return;
        }

        while (left < right) {
            int change = change(arr, left, right);

            sort(arr, left, change - 1);
            sort(arr, change + 1, right);
        }

    }

    private static int change(int[] arr, int left, int right){

        int l = left;
        int r = right - 1;
        int p = right;
        while ( l < r){

            if (arr[l] <= arr[p]){
                l ++;

            }else if (arr[l] > arr[p]){
                swap(arr,l,r);
                r --;
            }
        }
        if (l == r){
            if (arr[l] <= arr[p]){
                swap(arr,++l,p);
            }else if (arr[l] > arr[p]){
                swap(arr,l,p);
            }
        }

        return l;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
