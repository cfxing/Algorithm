package com.xnj.test;

import com.xnj.java.BinarySearch;

/**
 * @author chen xuanyi
 * @Date 2020/4/20 12:13
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,9,11,22,42,56,65,74,75,85,97};
//        int search = BinarySearch.search(arr, 0, arr.length - 1, 77);
        int search = BinarySearch.sort2(arr, 0, arr.length - 1, 85);
        System.out.println(search);
    }

}
