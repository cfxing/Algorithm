package com.xnj.linked;

import com.xnj.xnj;

import java.util.HashSet;

/**
 * 判断单链表是否是环状：
 *   1.定义一个快指针(f)和慢指针（s)
 *   2.快指针一次走两步，慢指针一次走一步
 *   3.当他们相遇时，快指针（f) 回到 head ，一次走一步
 *   4.他们总是能够在环的第一个节点处相遇
 *
 * 相交问题： 不可能相交岔开，因为单链表
 *  一个链表有环，一个链表无环，不可能相交
 *
 * 问题：两个单链表，可能有环，可能无环，给定两个单链表的头节点head1， head2 判断是否相交，
 *  若相交，则返回相交的第一个节点，如果不相交，返回null
 *      要求：时间复杂度 O（M+N), 额外空间复杂度 O(1)
 *
 *  方法一：使用 hashSet 判断一个单链表是否有环
 *
 * @author chen xuanyi
 * @Date 2020/5/2 8:52
 */
public class FindFirstIntersetNode {

    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        //loop: 环的第一个节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //当两个都没环时，相交的是直线，与环2的处理相似
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        //当两个都有环时，分3种情况
        //1.两个环是独立的
        //2.两个环的loop相同
        //3.两个环的loop不同，但组合成一个大环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);

        }
        //当一个有环，一个每环时，一定不相交
        return null;
    }

    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            //有2种情况
            cur1 = loop1.next;
            while (cur1 != loop1){
                //如果cur1 找到了loop2 ，说明他们同在一个环上
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            //如果 cur1 绕一圈后，还是只找到 loop1 , 说明两个链表分开，没有相交
            return null;
        }

    }

    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;//表示两个链表head1 和 head2 的长度差值
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //当两条链表没有环的时候，相交后的最后一个节点的 地址值 一定相同，否则说明没有相交
        if (cur1 != cur2) {
            return null;
        }
        //cur1 指向两者中最长的那个
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node s = head.next;//慢指针
        Node f = head.next.next;//快指针
        while (s != f) {
            if (f.next == null || f.next.next == null) {
                return null;
            }
            f = f.next.next;
            s = s.next;
        }
        f = head;//当相遇后，f 回到头节点，一次走一步，最后在第一个环节点出相遇
        while (f != s) {
            s = s.next;
            f = f.next;
        }
        return s;
    }

    @xnj
    public static Node getLoopNode2(Node head){
        HashSet<Node> set = new HashSet<>();
        Node cur = head;
        while (cur != null) {
            if (set.contains(cur)){
                return cur;
            }
            set.add(cur);
        }
        return null;
    }
}
