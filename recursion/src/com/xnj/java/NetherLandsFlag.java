package com.xnj.java;

/**
 * 给定一个数 num, 小于这个数的放左边，等于这个数的放中间，大于这个数的放右边
 *
 * @author chen xuanyi
 * @Date 2020/4/16 17:39
 */
public class NetherLandsFlag {
    /**
     *
     * @param arr 数组
     * @param left 左边界
     * @param right 右边界
     * @param num 要寻找的数
     */
    public static void partition(int[] arr, int left, int right, int num){

        //小于 num 数的边界
        int less = left - 1;//一开始在最左边-1，表示不存在

        //大于 num 数的边界
        int more = right + 1;

        int cur = left;//从最左边开始寻找

        while (cur < more){
            if (arr[cur] < num){
                swap(arr,++less,cur++);
            }else if (arr[cur] > num){
                swap(arr,--more,cur);
            }else {//等于 num
                cur++;
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
