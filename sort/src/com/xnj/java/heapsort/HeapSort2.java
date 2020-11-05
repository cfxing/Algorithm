package com.xnj.java.heapsort;

import com.xnj.java.quicksort.Swap;

/**
 * 自己写
 *
 * @author chen xuanyi
 * @Date 2020/4/18 21:37
 */
public class HeapSort2 {

    public static void sort(int[] arr){

        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            createHeap(arr,i);
        }
        int heapSize = arr.length;
        Swap.swap(arr,0, --heapSize);
        while (heapSize > 0){
            heapifly(arr,0,heapSize);
            Swap.swap(arr, 0 ,--heapSize);
        }

    }

    private static void createHeap(int[] arr, int i){
        while ( arr[i] > arr[((i - 1)/2)]){
            //如果 i 的数 大于其父节点
                Swap.swap(arr,i,(i - 1)/2);
                i = (i -1)/2;

        }
    }

    private static void heapifly(int[] arr, int i, int length){
        int left = (i * 2) + 1;
        while (left < length){
            int largest = left + 1 < length && arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[i] ? largest : i;

            if (largest == i){
                break;
            }

            //
            Swap.swap(arr,i,largest);
            i = largest;
            left = (i * 2) + 1;

        }
    }

}
