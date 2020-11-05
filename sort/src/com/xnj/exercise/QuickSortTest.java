package com.xnj.exercise;

import com.xnj.java.quicksort.QuickSort3;
import com.xnj.java.quicksort.QuickSort4;
import com.xnj.java.quicksort.QuickSort5;

/**
 * @author chen xuanyi
 * @Date 2020/4/16 18:32
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 3, 5, 7, 8};

//        QuickSort.sort(arr);
//        QuickSort2.sort(arr);
//        QuickSort3.sort(arr,0,arr.length - 1);
        QuickSort4.sort(arr, 0, arr.length - 1);//对
//        QuickSort5.sort(arr, 0, arr.length - 1);


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
