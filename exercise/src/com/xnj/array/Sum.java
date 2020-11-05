package com.xnj.array;


/**
 * 使用递归，求和
 *
 * @author chen xuanyi
 * @Date 2020/4/25 13:22
 */
public class Sum {

    public static int sum(int[] arr, int l, int r){
        if (l == r){
            return arr[l];
        }
        int mid = l + (r - l)/2;

        int leftSum = sum(arr, l, mid);
        int rightSum = sum(arr,mid + 1, r);
        return leftSum +rightSum;
    }

    public static int sum2(int[] arr, int l, int r){
        if (r - l == 0){
            return arr[l];
        }

        int sum2 = sum2(arr, ++l, r);
        return sum2 + arr[l-1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,6,7};
//        int sum = sum(arr, 0, arr.length - 1);
        int sum2 = sum2(arr, 0, arr.length - 1);
        System.out.println(sum2);
    }


}
