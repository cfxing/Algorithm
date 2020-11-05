package com.xnj.hash;

import com.xnj.xnj;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集结构：使用Map 实现
 *
 * 分治思想
 *
 * @author chen xuanyi
 * @Date 2020/5/12 19:04
 */
public class UnionFindSet {
    public HashMap<Node, Node> fatherMap;//key : 某一个节点  value：key 的 父节点
    public HashMap<Node, Integer> sizeMap;//key: 某一个节点  value：key 所在的集合一共有多少节点（代表节点）

    public UnionFindSet(List<Node> nodes){
        makeSets(nodes);
    }

    private void makeSets(List<Node> nodes){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (Node node : nodes){
            //一开始：每一个node 自己就是一个集合
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    //寻找头节点
    private Node findHead(Node node){
        Node father = fatherMap.get(node);

        //当 father == node 时， 即为头结点（只有头节点的 value 指向自己）
        if (father != node) {
            father = findHead(father);
        }
        //使得每个 node 都指向 head，因为每次递归都返回father，即头节点
        fatherMap.put(node, father);
        return father;

    }

    //迭代方式（非递归）
    @xnj
    private Node findHead2(Node node){
        Node father = fatherMap.get(node);
        Stack<Node> stack = new Stack<>();
        //找到头节点
        Node cur = node;
        while (father != cur) {
            stack.push(cur);
            cur = father;
            father = fatherMap.get(cur);
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            fatherMap.put(pop, father);
        }
        return father;
    }


    //判断是否是相同的集合
    public boolean isSameSet(Node a, Node b){
        return findHead(a) == findHead(b);
    }

    public void union(Node a, Node b){
        if (a == null || b == null) {
            return;
        }
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        if (aHead != bHead) {
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            if (aSetSize <= bSetSize) {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSetSize + bSetSize);
            }else {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSetSize + bSetSize);
            }
        }
    }

}

class Node{
    //String, int, float, char ，任意
}
