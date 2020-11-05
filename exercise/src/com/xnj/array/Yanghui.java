package com.xnj.array;

/**
 * 给定一个非负整数 numRows, 生成杨辉三角的前 numRows 行
 *
 * @author chen xuanyi
 * @Date 2020/4/14 20:14
 */
public class Yanghui {

    public static void yangHui(int row){

        int[][] arr = new int[row][row];
        arr[0][arr.length/2] = 1;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < arr[0].length-1
                    ; j++) {
                arr[i][j] = arr[i-1][j]+arr[i-1][j+1];
            }
        }
        for (int[] i : arr){
            for (int j : i){
                System.out.print(j + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        yangHui(5);
    }
}
