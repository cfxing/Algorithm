package com.xnj.array;

/**
 *
 *
 * @author chen xuanyi
 * @Date 2020/4/25 14:41
 */
public class QuickSort {

    public static void sort(int[] arr, int l, int r){
        if (arr == null || arr.length < 2){
            return;
        }
        if (r - l == 1){
            if (arr[l] > arr[r]){
                swap(arr,r,l);
            }
        }
        int mid = l + (r - l)/2;
        int pivot = arr[mid];
        while (l < r){
            while (arr[l]< pivot){
                l++;
            }
            while (arr[r] > pivot){
                r++;
            }
            swap(arr,l,r);

            if (l == r){
                l++;
                r++;
            }
            if (arr[l] == pivot){
                r--;
            }
            if (arr[r] == pivot){
                l++;
            }
            sort(arr,l ,mid);
            sort(arr,mid + 1, r);
        }

    }

    public static void swap(int[] arr, int r, int l) {
        arr[r] = arr[r]^arr[l];
        arr[l] = arr[r]^arr[l];
        arr[r] = arr[r]^arr[l];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,2,7,5,9};
        sort(arr,0,arr.length - 1);
        for (int i:arr){
            System.out.println(i);
        }
    }

}
