package com.xnj.java.quicksort;

import java.util.logging.Level;

/**
 * @author chen xuanyi
 * @Date 2020/4/16 21:31
 */
public class QuickSort2 {

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sort(arr,0,arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right){
        while (left < right){
            int[] p = partition(arr,left,right);
            sort(arr,left,p[0]);
            sort(arr,p[1], right);
        }
    }

    private static int[] partition(int[] arr, int left, int right){
        int less = left - 1;
        int more = right;//指向最后一个，

        while (left < more){
            if (arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                swap(arr, --more, left);
            }else {
                left++;
            }
        }
        swap(arr,more++,right);
        return new int[]{less, more};
    }

    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
}
