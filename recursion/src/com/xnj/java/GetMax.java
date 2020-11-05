package com.xnj.java;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 19:27
 */
public class GetMax {

    public static int getMax(int[] arr, int l, int r){
        if (l == r){
            return arr[l];
        }
        int mid = l + (r - l)/2;
        int leftMax = getMax(arr,l,mid);
        int rightMax = getMax(arr,mid + 1, r);
        return leftMax  > rightMax ? leftMax:rightMax;
    }
}
