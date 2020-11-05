package com.xnj.tanxin;

import com.sun.source.tree.NewArrayTree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大项目
 *
 * @author chen xuanyi
 * @Date 2020/5/14 13:07
 */
public class IPO {
    public static class Node{
        public int p;//利润
        public int c;//成本

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }


    /**
     *
     * @param k  项目的个数
     * @param w  总金钱
     * @param profits 利润
     * @param capital 消费
     * @return 总金钱
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w){
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}
