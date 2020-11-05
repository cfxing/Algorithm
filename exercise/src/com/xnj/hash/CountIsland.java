package com.xnj.hash;

/**
 * 岛问题： 一个矩阵只有 0 和 1 ， 1 可以和它的上下左右相连，相连的就是一个岛
 *
 *
 * 单核处理，单处理
 *
 *
 * @author chen xuanyi
 * @Date 2020/5/10 15:31
 */
public class CountIsland {

    public static int countIsLand(int[][] m){
        if (m == null || m[0] == null) {
            return 0;
        }

        //行
        int r = m[0].length;
        //列
        int c = m.length;

        //岛的总数
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] == 1){
                    reflect(m, i, j, r, c);
                }
            }
        }
        return res;
    }

    /**
     *
     * @param m   二维数组
     * @param i   当前行
     * @param j   当前列
     * @param r   总的行数
     * @param c   总的列数
     */
    private static void reflect(int[][] m, int i, int j, int r, int c) {
        if (i < 0 || i >= r || j < 0 || j >= c || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        reflect(m, i - 1, j, r, c);
        reflect(m, i, j + 1, r, c);
        reflect(m, i + 1, j, r, c);
        reflect(m, i, j - 1, r, c);

    }

}
