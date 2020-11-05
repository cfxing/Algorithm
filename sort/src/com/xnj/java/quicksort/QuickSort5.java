package com.xnj.java.quicksort;

/**
 * @author chen xuanyi
 * @Date 2020/4/17 13:42
 */
public class QuickSort5 {

    public static void sort(int[] arr, int left, int right){
        if (arr == null || arr.length < 2){
            return;
        }
        while (left < right) {
            int[] p = partition(arr, left, right);
            if (left < p[0] - 1) {
                sort(arr, left, p[0] - 1);
            }
            if (right > p[1] + 1) {
                sort(arr, p[1] + 1, right);
            }
        }
    }

    private static int[] partition(int[] arr, int left, int right){

        int l = left - 1;//小于下边界
        int r = right;//大于下边界
        Swap.swap(arr,(int)(left + (Math.random()*(right - left + 1))), right);
        int cur = left;//从左边开始
        while (cur < r){
            if (arr[cur] < arr[right]){
                Swap.swap(arr, ++l, cur++);
            }else if (arr[cur] > arr[right]){
                Swap.swap(arr, --r, cur);
            }else {
                cur++;
            }

            if (cur >= r){
                break;
            }
        }
        Swap.swap(arr,r,right);
        return new int[]{++l,r};//l为什么+1，r 不减一，而在调用的时候才执行：因为防止最坏情况，l或r 没动
    }
}
