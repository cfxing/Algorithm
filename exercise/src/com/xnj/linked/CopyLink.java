package com.xnj.linked;

import java.util.HashMap;

/**
 * 复制链表
 *
 * 方法一：使用hash表，key: 原节点 ； value：复制节点
 *
 * @author chen xuanyi
 * @Date 2020/5/2 8:20
 */
public class CopyLink {

    public static Node copyLinkWithRand(Node head){
        HashMap<Node, Node> map = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            map.put(cur,cur);
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static Node copyLinkWithRand2(Node head){
        Node left = head;
        Node mid ;
        Node right = left.next;

        //使得复制的Node 再原 Node 的next
        while (left != null ){
            left.next = new Node(left.value);
            mid = left.next;
            mid.next = right;
            left = right;
            right = right.next;
        }

        left = head;
        right = head.next;

        while (left != null) {
            right.rand = left.rand.next;//right 的 rand 是 原 node 的 rand 的下一个
            left = left.next.next;
            right = left.next;
        }

        mid = head.next;
        while (mid != null) {
            mid.next = mid.next.next;
            mid = mid.next;
        }
        return mid;
    }

    public static Node copyLinkWithRand3(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //copy node and link to every node
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //set copy node rand
        while (cur != null) {
            next = cur.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;//
            cur = next;
        }
        Node res = head.next;
        cur = head;
        //spit
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

}
