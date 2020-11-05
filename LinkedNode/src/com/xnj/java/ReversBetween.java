package com.xnj.java;

import com.xnj.java.Node;

/**
 * 已知链表头节点指针head , 将链表从位置 m 到 n 逆序（不申请额外空间）
 *
 * @author chen xuanyi
 * @Date 2020/5/8 18:56
 */
public class ReversBetween {

    public static Node reversBetween(Node head, int m, int n){
        if (head == null){
            return null;
        }
        Node pre = head;
        Node last = null;
        Node temp = null;
        Node tempNext = null;

        //记录m
        for (int i = 1; i < m; i++) {
           pre = pre.next;
        }
        last = pre;
        //记录n
        for (int i = m; i < n; i++) {
            last = last.next;
        }

        //添加code
        if(pre == last){//  [3,5] 1 1
            return head;
        }

        temp = pre.next;

        if (last.next != null) {
            pre.next = last.next;
        }else {
            pre.next = null;
        }
        //后改
        if(head != pre) {
            while (tempNext.next != pre) {
                tempNext = tempNext.next;
            }
        }
            tempNext.next = last;

        while (pre!= last) {
            tempNext = temp.next;
            temp.next = pre;
            pre = temp;
            temp = tempNext;
        }

        return head;
    }

}
