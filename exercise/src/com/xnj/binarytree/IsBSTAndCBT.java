package com.xnj.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是二叉搜索树（bst)完全二叉树(cbt)
 *
 * @author chen xuanyi
 * @Date 2020/5/8 12:43
 */
public class IsBSTAndCBT {

    public static boolean isBST(Node head){
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if (cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                return false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }


    //level 遍历
    public static boolean isCBT(Node head){
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        //当为true时，后面遇到的节点应都为叶子节点
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }else {
                leaf = true;
            }
        }
        return true;

    }
}
