package com.xnj.recursion;

/**
 * 给定一个数组 arr, 给定一个数 aim， 看 arr 中是否能相加得到 aim
 *
 * @author chen xuanyi
 * @Date 2020/6/1 17:37
 */
public class IsSum {

    public static boolean isSum(int[] arr,int i, int sum, int aim){

        if (i == arr.length){
            return sum == aim;
        }
        return isSum(arr, i + 1, sum, aim) || isSum(arr, i + 1, sum + arr[i], aim);

    }

}
