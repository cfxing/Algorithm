package com.xnj.java;

import com.xnj.xnj;

/**
 * 指定位置反转：改变value
 *
 * @author chen xuanyi
 * @Date 2020/5/11 14:12
 */
@xnj
public class ReverseBetween2 {

    public static Node reversBetween(Node head, int m, int n){
        if (head == null) {
            return head;
        }

        Node pre = head;
        Node last;

        //记录m
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        last = pre;
        //记录n
        for (int i = m; i < n; i++) {
            last = last.next;
        }

        int temp;
        while (pre != last) {
            Node lastPre = pre;
            temp = pre.value;
            pre.value = last.value;
            last.value = temp;

            while (lastPre.next != last) {
                lastPre = lastPre.next;
            }
            last = lastPre;
            //扣边界
            if (last != pre){
                pre = pre.next;
            }
        }
        return head;
    }
}
