package com.xnj.test;

import com.xnj.java.NetherLandsFlag;

/**
 * @author chen xuanyi
 * @Date 2020/4/16 17:47
 */
public class NetherLandsFlagTest {

    public static void main(String[] args) {

        int[] arr = new int[]{23,53,5,6,2,56,4,4,5,1 ,3,4,5,5,2,9};

        NetherLandsFlag.partition(arr,0,arr.length - 1,4);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
