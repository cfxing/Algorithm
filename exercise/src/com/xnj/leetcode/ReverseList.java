package com.xnj.leetcode;

/**
 * @author chen xuanyi
 * @Date 2020/4/30 21:04
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode lastIndex = head;
        ListNode newHead = new ListNode(0);
        //当前指针指向第一个节点（除头节点）
        ListNode cur = head.next;
        ListNode next;

        while (cur != null){
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        while(lastIndex.next != null){
            lastIndex = lastIndex.next;
        }
        lastIndex.next = head;
        head.next = newHead.next;
        return head;
    }

    private static class ListNode {
        int x ;
        ListNode next;

        public ListNode(int x) {
            this.x = x;
        }
    }
}
