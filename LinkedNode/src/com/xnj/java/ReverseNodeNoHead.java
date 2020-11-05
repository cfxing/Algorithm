package com.xnj.java;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author chen xuanyi
 * @Date 2020/5/11 15:44
 */
public class ReverseNodeNoHead {


    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node last = head.next;



        while (cur != null) {
            if (cur == head) {
                cur.next = null;
                pre = cur;
                cur = last;
            } else {
                last = cur.next;
                cur.next = pre;
                pre = cur;
                cur = last;
            }
            if (last.next == null) {
                last.next = cur;
                break;
            }
        }
        return last;
    }

    //一般的反转（双指针）
    public static Node reverseList2(Node head){
        Node pre = null;
        Node cur = head;
        Node temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }

    //ArrayList
    public static Node reverseList3(Node head){
        Stack<Node> nodes = new Stack<>();

        Node cur = head;

        while (cur != null) {
            nodes.push(cur);
            cur = cur.next;
        }

        head = nodes.pop();
        cur = head;
        while (!nodes.isEmpty()){
            cur.next = nodes.pop();
            cur = cur.next;
        }
        return head;
    }

    //递归法
    public static Node reverseList4(Node head){

        if (head == null || head.next == null) {
            return head;
        }

        //cur 指向最后一个 node
        Node cur = reverseList4(head.next);

        head.next.next = head;
        //避免环
        head.next = null;

        return cur;



    }


}
