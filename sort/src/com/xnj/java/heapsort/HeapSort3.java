package com.xnj.java.heapsort;

import com.xnj.java.quicksort.Swap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;


/**
 * @author chen xuanyi
 * @Date 2020/4/18 23:05
 */
public class HeapSort3 {

    public static void midNum(){

        FileInputStream fis = new FileInputStream(new File("sort\\num"));

        int[] arrA = new int[1024];
        int[] arrD = new int[1024];
        int len;
        byte[] buffer = new byte[200];
        while ((len = fis.read()) != -1){
            int i = 0;
            arrA[i] =  buffer[0];
            if (arrA.length - arrD.length > 2){

            }
        }
    }



    private static void createHeapA(int[] arr,int i){
        while (arr[i] > arr[(i - 1)/2]){
            Swap.swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    private static void creatHeapD(int[] arr, int i) {
        while (arr[i] < arr[(i - 1)/2]){
            Swap.swap(arr,i,(i - 1)/2);
            i = (i - 1)/2;
        }
    }

    private static void heapifyA(int[] arr, int i, int length){
        int left = (i * 2) + 1;
        while (left < length) {
            int largest = left + 1 < length & arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[i] ? largest : i;

            if (largest == i){
                break;
            }

            Swap.swap(arr, i, largest);
            i = largest;
            left = (i * 2) + 1;
        }
    }

    private static void heapifyD(int[] arr, int i, int length){

//        int temp = arr[i];
        for (int j = (i * 2) + 1; j < length; j = (i * 2) + 1) {
            if (j + 1 < length & arr[j+1] > arr[j]){
                j++;
            }

            if (arr[j] > arr[i]){
//                arr[i] = arr[j];
                Swap.swap(arr, i, j);
                i = j;
            }else {
                break;
            }

        }

//        arr[i] = temp;
    }

}
