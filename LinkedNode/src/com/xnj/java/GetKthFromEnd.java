package com.xnj.java;

/**
 * 返回从倒数第k 个节点开始到最后节点的新链表
 *
 * @author chen xuanyi
 * @Date 2020/5/11 15:07
 */
public class GetKthFromEnd {

    /**
     *
     * @param head 头节点
     * @param k 倒数第 k 个节点（从1开始计数）
     * @return 返回以 k 处开始的节点为头节点的新链表
     */
    public Node getKthFromEnd(Node head, int k){

        //定义链表的大小
        //记录最后一个node
        int length = 0;
        Node last = head;
        //不能改动head，否则后面的赋值会出现空指针异常
        Node cur = head;
        while (cur != null){
            length++;
            cur = cur.next;
            if (cur == null) {
                last = cur;
            }
        }

        for (int i = length; i > length - k; i--) {
            Node  lastPre = head;

            //使 latsPre 每次指向last 的前一个
            while (lastPre.next != last) {
                lastPre = lastPre.next;
            }
            last = lastPre;
        }
        return last;



    }
}
