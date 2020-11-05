package com.xnj.java;

/**
 * 判断一个链表是否有环
 *
 * @author chen xuanyi
 * @Date 2020/6/3 15:29
 */
public class DetectCycle {

    public static Node detectCycle1(Node head){
        Node slow = head;
        Node fast = head;
        Node meet = null;
        while (fast != null || fast != slow) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node detectCycle2(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast == null || slow == null) {
                return  null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;


    }
}
