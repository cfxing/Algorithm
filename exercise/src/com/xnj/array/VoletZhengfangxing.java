package com.xnj.array;


/**
 * 将正方形逆时针旋转
 *
 * @author chen xuanyi
 * @Date 2020/4/28 10:33
 */
public class VoletZhengfangxing {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        volet(arr,0,0,arr.length - 1, arr[0].length - 1);
    }

    public static void volet(int[][] arr, int leftR, int leftC, int rightR, int rightC){
        if (arr.length ==1 && arr[0].length == 1){
            return;
        }else {
            int curR = leftR;
            int curC = leftC;
            for (int i = rightC; i >= 0; ) {

                while (curR <= rightR){
                    System.out.print(arr[curR++][i] + " ");
                }
                curR = leftR;
                i--;
                System.out.println();
            }

        }
    }
}
