package com.xnj.exercise;

import com.xnj.java.SelectSort;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 15:17
 */
public class SelectTest {

    public static void main(String[] args) {
        int[] arr = {2,3,5,3,5,7,8};
        SelectSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
