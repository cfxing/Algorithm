package com.xnj.exercise;

import com.xnj.java.BubbleSort;

/**
 * @author chen xuanyi
 * @Date 2020/4/13 14:40
 */
public class BubbleTest {

    public static void main(String[] args) {
        int[] arr ={3,53,32,53,33,22,6,1,35,3,1,1,};
        BubbleSort.sort(arr);
        for (int i:arr){
            System.out.print(arr[i] +"\t");
        }
    }
}
