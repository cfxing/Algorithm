package com.xnj.linked;

import com.xnj.xnj;

import java.util.HashSet;

/**
 * @author chen xuanyi
 * @Date 2020/5/2 11:00
 */
@xnj
public class FindFirstIntersetNode2 {

    public static Node getIntersectNode(Node head1, Node head2){
        //1.先判断两条链表是否有环
        //情况一：两条链表都无环
        //情况二：两条链表都有环
        //情况三：一条链表有环， 一条链表无环
        Node loop1 = hasLoop(head1);
        Node loop2 = hasLoop(head2);

        //情况一
        if (loop1 == null && loop2 == null) {
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;//两个链表的差值
            while (cur1 != null) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != null) {
                n--;
                cur2 = cur2.next;
            }
            //如果最后一个节点不相等，则不会相交
            if (cur1 != cur2) {
                return null;
            }

            //让 cur1 指向最长的一个链表
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

        //情况二：
        //分三种方式
        //方式一： 自己有自己的环， 不相交 loop1 != loop2
        //方式二； 有相同的环，loop1 == loop2
        //方式三：有相同的环， loop1 ！= loop2
        else if (loop1 != null && loop2 != null) {
            //方式二
            while (loop1 == loop2){
                Node cur1 = head1;
                Node cur2 = head2;
                int n = 0;//两个链表的差值
                while (cur1 != loop1) {
                    n++;
                    cur1 = cur1.next;
                }
                while (cur2 != loop2) {
                    n--;
                    cur2 = cur2.next;
                }
                //让 cur1 指向最长的一个链表
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
            while (loop1 != loop2) {
                Node cur = loop1;
                //方式三：
                while (cur != loop1) {
                    cur = cur.next;
                    if (cur == loop2) {
                        return loop1;
                    }
                }
                //方式一：
                return null;


            }
        }else {
            //情况三
            return null;
        }
        throw new RuntimeException("链表错误");
    }

    private static Node hasLoop(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node cur = head;
        while (cur != null) {
            if (set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

}
