package com.xnj.java;

/**
 * 已知链表头节点head 和 数值x, 将所有小于x 的放在大于等于x 的结点前，且保持这些结点的原来的相对位置（稳定性）
 *
 * @author chen xuanyi
 * @Date 2020/6/3 18:42
 */
public class Partition {

    public static Node partition(Node head, int x){
        if (head == null) {
            return null;
        }
        //小于x的
        Node lessNode = new Node(0);
        //大于等于x 的
        Node moreNode = new Node(0);

        Node less = lessNode;
        Node more = moreNode;

        //遍历链表
        while(head != null){
            if (head.value < x){
                lessNode.next = head;
                less = less.next;
            }else {
                moreNode.next = head;
                more = more.next;
            }
            head = head.next;
        }
        less.next = moreNode.next;
        moreNode = null;
        more.next = null;
        return lessNode.next;
    }
}
