package com.xnj.array;

/**
 * 在排好序的二维数组中，找到一个数
 *
 * @author chen xuanyi
 * @Date 2020/4/30 17:05
 */
public class SelectMartix {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] select = select(arr, 8);
        for (int i = 0; i < select.length; i++) {
            System.out.print(select[i] + " ");
        }
    }

    public static int[] select(int[][] arr, int index) {
        int r = 0;
        int c = arr.length - 1;
        //找到的坐标
        int[] find = new int[2];
        while (r <= arr.length - 1 && c >= 0) {
            if (index > arr[r][c]) {
               r++;
            } else if (index < arr[r][c]){
                c--;
            }else {
                find[0] = r;
                find[1] = c;
                return find;
            }
            find = toFind(arr, index, r, c);
        }
        return find;
    }

    private static int[] toFind(int[][] arr, int index, int r, int c) {
        int[] temp = new int[2];
        if (index == arr[r][c]) {
            temp[0] = r;
            temp[1] = c;
        }
        return temp;
    }


}
