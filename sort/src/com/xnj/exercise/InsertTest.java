package com.xnj.exercise;

import com.xnj.java.InsertSort;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 16:27
 */
public class InsertTest {

    public static void main(String[] args) {
//        int[] arr = {2,3,5,3,5,7,8,889,90,9,0,57,44};

        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
        }


        long start = System.currentTimeMillis();
        System.out.println(start);
        InsertSort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end-start);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
