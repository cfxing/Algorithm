package com.xnj.java;


/**
 * 将链表逆序，不能申请额外空间
 *
 * @author chen xuanyi
 * @Date 2020/4/14 14:42
 */
public class ReverseNode {

    public static Node reverseList(Node head){
        Node new_Node = null;

        if (head != null){
            Node next = head.next;
            head.next = new_Node;
            new_Node = head;
            head = next;
        }

        return new_Node;
    }

}

