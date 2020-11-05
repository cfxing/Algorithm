package com.xnj.java.quicksort;

import java.util.Stack;

/**
 * 非递归实现
 *
 * @author chen xuanyi
 * @Date 2020/4/17 14:45
 */
public class QuickSort6 {

    public static void sort(int[] arr, int left, int right){
        int l = left;
        int r = right - 1;
        int temp = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        //第一次排序
        while (l<r){
            while (arr[l] < arr[right]){
                l++;
            }
            while (arr[l] > arr[right]){
                r--;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (l >= r){
                break;
            }

            if (arr[l] == arr[right]){
                r--;
            }
            if (arr[r] == arr[right]){
                l ++;
            }
        }
    }

}
