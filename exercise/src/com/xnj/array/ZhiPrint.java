package com.xnj.array;

/**
 * 之字型打印数组
 * 思路：
 * 1.
 *
 *
 * @author chen xuanyi
 * @Date 2020/4/30 14:54
 */
public class ZhiPrint {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        print(arr);


    }

    public static void print(int[][] arr){

        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = arr.length - 1;
        int endC = arr[0].length - 1;
        boolean isUp = true;
        while (aR <= endR ){
            printMartix(arr, aR, aC, bR, bC, isUp);
            aR = (aC == endC ? aR + 1 : aR);
            aC = (aC == endC ? aC : aC + 1);
            //注意：bc 应该在 bR 前面判断，因为 bR 的变化会再次引起 bC 的变化
            bC = (bR == endR ? bC + 1 : bC);
            bR = (bR == endR ? bR : bR + 1);
            isUp = !isUp;
        }

    }

    /**
     *
     * @param arr 数组人
     * @param aR a 点的横坐标 a 往右走
     * @param aC a 点的纵坐标
     * @param bR b 点的横坐标
     * @param bC b 点的纵坐标
     * @param isUp 是否向上之字形
     */
    private static void printMartix(int[][] arr, int aR, int aC, int bR, int bC,boolean isUp){

        if (isUp){
            while (bR >= aR && bC <= aC){

                System.out.print(arr[bR--][bC++] + " ");
            }
        }else {
            while (aR <= bR && aC >= bC){

                System.out.print(arr[aR++][aC--] + " ");
            }
        }

    }

}
