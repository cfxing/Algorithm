package com.xnj.array;

/**
 * 打印回环矩阵
 *
 * @author chen xuanyi
 * @Date 2020/4/27 15:03
 */
public class PrintMartix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        print(arr, 0, 0, arr.length-1, arr[0].length  -1);
    }

    public static void print(int[][] arr, int leftR, int leftC, int rightR, int rightC){
        while (leftC <= rightC && leftR <= rightR){

            martix(arr, leftR++, leftC++, rightR--, rightC--);
        }
    }

    /**
     *
     * @param leftR 左上角的行
     * @param leftC 左上角的列
     * @param rightR 右下角的行
     * @param rightC 右下角的列
     */
    public static void martix(int[][] arr, int leftR, int leftC, int rightR, int rightC){
        if (leftR == rightR){
            for (int i = leftC; i <= rightC; i++) {

                System.out.print(arr[leftR][ i] + " ");
            }
        }else if (leftC == rightC){
            for (int i = 0; i <= rightR; i++) {

                System.out.print(arr[i][leftC] + " ");
            }
        }else {

            int curR = leftR;
            int curC = leftC;
            while (curC < rightC) {
                System.out.print(arr[leftR][curC++] + " ");
            }
            while (curR < rightR) {
                System.out.print(arr[curR++][rightC] + " ");
            }
            while (curC > leftC) {
                System.out.print(arr[rightR][curC--] + " ");
            }
            while (curR > leftR) {
                System.out.print(arr[curR--][leftC] + " ");
            }
        }
    }

}
