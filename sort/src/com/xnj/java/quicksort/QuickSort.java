package com.xnj.java.quicksort;


/**
 * 快速排序，使用荷兰国旗优化
 *
 * @author chen xuanyi
 * @Date 2020/4/16 18:05
 */
public class QuickSort {

    public static void sort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sort(arr, 0,arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right){

        while (left < right) {
            swap(arr,left + (int)(Math.random()* (right - left + 1)), right);//随机快排
            int[] p = partition(arr, left, right);
            sort(arr, left, p[0] - 1);
            sort(arr, p[1] + 1, right);

        }
    }

    private static int[] partition(int[] arr, int left, int right){

        int less = left - 1;
        int more = right;
        while (left < more){
            if (arr[left] < arr[right]){
                swap(arr,++less,left++);
            }else if (arr[left] > arr[right]){
                swap(arr,--more, left);
            }else {
                left++;
            }
        }
        swap(arr,more++,right);//一开始 arr[right] 并不参与比较，最后放到位置

        return new int[]{less + 1,more};

    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
