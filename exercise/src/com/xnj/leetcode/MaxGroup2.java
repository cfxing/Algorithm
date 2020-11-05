package com.xnj.leetcode;

import static com.xnj.leetcode.MaxGroup.bucket;

/**
 * @author chen xuanyi
 * @Date 2020/4/23 14:30
 */
public class MaxGroup2 {

    public static int  maxGroup(int[] arr){

        //1.先定义两个全局变量，min， max用来保存整个数组中的最小和最大值，用来分类桶
        int min = Integer.MAX_VALUE;//因为要得到数组的最小，先令它最大，再和其他的比较
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        //如果min 和 max 相同，说明只有一种数
        if (min == max){
            return 0;
        }
        //2.定义 n+1 个桶，用来保存每个放进桶中的数据的最大值和最小值
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        int bid = 0;
        //2.遍历数组，将数据放入对应的桶
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len,min, max);
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(arr[i] , maxs[bid]) : arr[i];
            hasNum[bid] = true;
        }

        //3.比较存在数据的桶，将上一个桶的最大值和这个桶的最小值比较、
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len + 1; i++)
            if (hasNum[i]){
                res = Math.max((mins[i] - lastMax), res);
                lastMax = maxs[i];{
            }
        }
        return res;
    }
}
