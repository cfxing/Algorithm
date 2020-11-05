package com.xnj.leetcode;


/**
 *给定一串排序过后的数组，返回相邻两数之间的最大差值
 *
 * @author chen xuanyi
 * @Date 2020/4/23 13:43
 */
public class MaxGroup {

    public static void main(String[] args) {

        int[] arr = new int[]{1,3,5,6,8,12,23,33,43};
//        int maxGroup = maxGroup(arr);
        int maxGroup = MaxGroup2.maxGroup(arr);
        System.out.println(maxGroup);
    }

    public static int maxGroup(int[] arr){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min,arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max ){
            return 0;
        }
        boolean[] hasNum = new boolean[arr.length + 1];
        int[] mins = new int[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        //插入的桶的索引
        int bid = 0;
        for (int i = 0; i < arr.length; i++) {
            bid = bucket(arr[i], arr.length, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i < maxs.length ; i++) {
            if (hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    static int bucket(int num, int length, int min, int max) {
        return (num - min)* length / ( max - min);
    }
}
