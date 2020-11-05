package com.xnj.array;

import com.xnj.xnj;

/**
 *
 * @author chen xuanyi
 * @Date 2020/4/30 11:32
 */
public class VoletZhengFangXing2 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        rotate(arr,0,0,arr.length - 1, arr.length - 1);
        print(arr);
    }

    public static void rotate(int[][] arr, int leftR, int leftC, int rightR, int rightC){
        while (leftR < rightR && leftC < rightC){
            rotateEdge(arr, leftR++, leftC++, rightR--, rightC--);
        }
    }

    @xnj
    private static  void rotateEdge(int[][] arr, int leftR, int leftC, int rightR, int rightC){
        int temp = 0;
//        for (int i = 0; i < rightC; i++) {
//            temp = arr[leftR][i];
//            arr[leftR][i] = arr[rightR][i];
//            arr[rightR][i] = arr[rightR][rightC];
//            arr[rightR][rightC] = arr[leftR][rightC];
//            arr[leftR][rightC] = temp;
//        }
//        int times = rightC - leftC;
//        for (int i = 0; i <rightC ; i++) {
//            temp = arr[leftR][leftC + i];
//            arr[leftR][leftC + i] = arr[rightR - i][leftC];
//            arr[rightR - i][leftC] = arr[rightR ][rightC - i];
//            arr[rightR ][rightC - i] = arr[leftR + i][rightC];
//            arr[leftR + i][rightC ] = temp;
//        }

        //注意：旋转方向应该一致
        for (int i = 0; i < rightC ; i++) {
            temp = arr[leftR][leftC + i];
            arr[leftR][leftC + i] = arr[rightR - i][leftC];
            arr[rightR - i][leftC] = arr[rightR][rightC - i];
            arr[rightR][rightC - i] = arr[leftR + i][rightC];
            arr[leftR + i][rightC] = temp;

        }

    }

    private static void print(int[][] arr){
        for (int[] i : arr){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
