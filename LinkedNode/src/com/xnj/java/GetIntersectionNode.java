package com.xnj.java;

import com.xnj.hash.Hash;

import java.util.HashSet;

/**
 * 返回相交的结点，两个链表
 *
 * @author chen xuanyi
 * @Date 2020/5/13 22:07
 */
public class GetIntersectionNode {

    //指针法
    public static Node getIntersectionNode1(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;

        int n = 0;//用来计算两个链表的差值

        //为了保证cur 指在最后一个结点
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }

        if (cur1 != cur2) {
            return null;
        }

        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

         n = Math.abs(n);

        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;

    }

    //使用set 集合， value 保存 地址值, 不是最优解
    public static Node getIntersectionNode2(Node head1, Node head2){
        HashSet<String> set = new HashSet<>();
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null){
            set.add(cur1.toString());
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            if (set.contains(cur2.toString())){
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }

    //空间复杂度 O（1）
    public static Node getIntersectionNode3(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        if (len1 >= len2){
            head1 = forwardLongList(len1, len2,head1);
        }else {
            head2 = forwardLongList(len2, len1, head2);
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
//                return head1;
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
//        return null;
        return head1;
    }

    private static int getLength(Node head){
        int n = 0;
        while (head.next != null){
            n++;
            head = head.next;
        }
        return n;
    }

    private static Node forwardLongList(int longLen, int shortLen, Node head){
        int delta = longLen - shortLen;
        while (delta != 0 && head != null) {
            head = head.next;
            delta--;
        }
        return head;
    }
}
