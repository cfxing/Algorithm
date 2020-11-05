package com.xnj.tanxin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *一块金条切成两半，需要花费相同长度的铜板，eg: 长度为20的金条，无论怎样切成两半，都需要花费20个铜板；一群人想整分整块金条，怎么分最省铜板
 *
 * eg: 【10，20，30】 : 代表一个三个人，整块金条的长度为 10+20+30 = 60 ，金条需要分成 10， 20， 30 三部分
 *
 * 思路： 60 分为30，30 , 需要60个铜板， 30 分为 10，20 ，需要30个铜板  总共： 需要60 + 30 = 90个铜板
 *
 *
 * @author chen xuanyi
 * @Date 2020/5/13 18:49
 */
public class SplitGold {

    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    public static class MinheapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;//<0,  o1 < o2 负数
        }
    }

    public static class MaxheapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; //<   o2 < o1
        }
    }
}
