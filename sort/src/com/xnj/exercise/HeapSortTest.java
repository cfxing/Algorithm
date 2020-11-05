package com.xnj.exercise;

import com.xnj.java.heapsort.HeapSort2;

/**
 * @author chen xuanyi
 * @Date 2020/4/18 21:47
 */
public class HeapSortTest {

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 3, 5, 7, 8};

//        HeapSort.sort(arr);
        HeapSort2.sort(arr);


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
