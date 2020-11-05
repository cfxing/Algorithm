package com.xnj.array;

/**
 * 使用递归，得到数组中的最大值
 *
 * @author chen xuanyi
 * @Date 2020/4/25 13:13
 */
public class GetMax {

    public static int getMax(int[] arr, int l, int r){

        //基线条件
        if (l == r){
            return arr[l];
        }
        int mid = l + (r - l)/2;

        int leftMax = getMax(arr, l, mid);
        int rightMax = getMax(arr, mid +1, r);

        return leftMax > rightMax ? leftMax : rightMax;
    }



}
