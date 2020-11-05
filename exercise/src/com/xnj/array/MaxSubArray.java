package com.xnj.array;

/**
 * 给定一个整数数组 nums, 找到一个具有最大和的连续子数组（最少包含一个元素），返回最大子序和
 *
 *
 * @author chen xuanyi
 * @Date 2020/4/14 19:11
 */
public class MaxSubArray {

    private static int crossSum(int[] arr, int left, int right, int mid){
        if (left == right){
            return arr[left];
        }
        int leftSubSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = mid; i > left - 1 ; i--) {
            curSum += arr[i];
            leftSubSum = Math.max(leftSubSum,curSum);
        }
        int rightSubSum = Integer.MIN_VALUE;
        int CurSum = 0;
        for (int i = mid + 1; i < right+1; i++) {
            curSum = arr[i];
            rightSubSum = Math.max(curSum,rightSubSum);
        }

        return leftSubSum + rightSubSum;

    }

    private static int helper(int[] arr, int left, int right){
        if (left == right) {
            return arr[left];
        }

        int mid = left + (right - left)/2;

        int leftSum = helper(arr,left,mid);
        int rightSum = helper(arr,mid + 1 , right);
        int crossSum = crossSum(arr, left, right, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    //方法一：分治法：O(N logN)
    public static int maxSubArray1(int[] arr){
        return helper(arr,0,arr.length - 1);
    }


    //方法二：贪心算法：O(N)
    public static int maxSubArray2(int[] arr){
        int n = arr.length;
        int currSum = arr[0], maxSum = arr[0];

        for (int i = 1; i < n; i++) {
            currSum = Math.max(arr[i],currSum+arr[i]);

            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    //方法三：动态规划（Kadane 算法）：O(N)
    public static int maxSubArray3(int[] arr){
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > 0 ){
                arr[i] += arr[i - 1];
            }
            maxSum = Math.max(arr[i], maxSum);
        }
        return maxSum;
    }
}
