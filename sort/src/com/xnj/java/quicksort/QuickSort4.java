package com.xnj.java.quicksort;

/**
 * @author chen xuanyi
 * @Date 2020/4/17 12:23
 */
public class QuickSort4 {

    public static void sort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        Swap.swap(arr, (int)(l + (Math.random()*(r - l + 1))), r);
        int temp = 0;

        while (l < r){
            while (arr[l] < arr[right]){
                l ++;
            }
            while (arr[r] > arr[right]){
                r --;
            }
            //说明排序完成
            if (l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == arr[right]){
                r--;
            }
            if (arr[r] == arr[right]){
                l ++;
            }

        }

        if (l == r){
            l++;
            r--;
        }

        if (left < r){
            sort(arr, left, r);
        }
        if (right > l){
            sort(arr, l, right);
        }


    }


}
