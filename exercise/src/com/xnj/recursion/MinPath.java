package com.xnj.recursion;

/**
 * 从某一位置到右下角的最短路径
 *
 * @author chen xuanyi
 * @Date 2020/6/1 12:19
 */
public class MinPath {

    /**
     *
     * @param matrix
     * @param i  行
     * @param j  列
     * @return
     */
    public static int walk(int[][] matrix, int i, int j){
        //如果就在右下角
        if (i == matrix.length - 1 && j == matrix[0].length - 1){
            return matrix[i][j];
        }
        //在最下行
        if (i == matrix.length - 1) {
            return matrix[i][j] + walk(matrix, i, j + 1);
        }
        //在最右列
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + walk(matrix, i + 1, j);
        }
        int right = walk(matrix, i, j + 1);//右边位置到右下角的最短路径和
        int down = walk(matrix, i + 1, j);//下边位置到右下角的最短路径和
        return matrix[i][j] + Math.min(right, down);//取最小的
    }

    //无后效性问题

}
