package com.xnj.leetcode;

/**
 * 给定一个二维数组，翻转数组的每一行，然后整体翻转数组
 *
 * @author chen xuanyi
 * @Date 2020/4/30 20:29
 */
public class VoletArray {

    public static void main(String[] args) {
//        int[][] arr = {{0,1,0,1},{1,1,1,1},{0,1,1,0}};
        int[][] arr = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(arr);
        voletArray(arr);
        System.out.println();

        print(arr);
    }

    public static void voletArray(int[][] arr) {


        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            int r = arr[0].length - 1;
            while (l <= r) {
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;

                l++;
                r--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] ^= 1;
            }
        }
    }

    private static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
