package com.xnj.java.heapsort;

import com.xnj.java.quicksort.Swap;

/**
 * 堆排序
 *
 * @author chen xuanyi
 * @Date 2020/4/18 21:07
 */
public class HeapSort {

    public static void sort(int[] arr){

        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        Swap.swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapify(arr,0,heapSize);
            Swap.swap(arr, 0,--heapSize);
        }
    }

    /**
     * 构成大顶堆：比较新插入的值与它的父节点（i-1)/2，然后进行操作
     * @param arr
     * @param i 待插入的值的索引
     */
    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1)/2]){
            Swap.swap(arr,i,(i - 1)/2);
            i = (i - 1)/2;
        }

    }

    /**
     * 堆的构成
     * @param arr
     * @param i 顶点
     * @param heapSize 堆的大小
     */
    private static void heapify(int[] arr, int i, int heapSize) {
        int left = i * 2 + 1;
        while (left < heapSize){
            //比较的是i 的左右子节点的值的大小，得到最大的数的索引
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1:left;
            //得到 左右子结点 与 顶点 i 之间的最大值的索引，返回给 largest
            largest = arr[largest] > arr[i] ? largest : i;
            //得到三者之间的最大值
            //如果最大值的索引 == i， 即没有改变，则结束循环
            if (largest == i){
                break;
            }
            //如果不是的化，则交换，使得 i 处的值最大
            Swap.swap(arr,largest, i);
            //再将交换后的 largest（
            i = largest;
            left = i * 2 + 1;
        }

    }

}
