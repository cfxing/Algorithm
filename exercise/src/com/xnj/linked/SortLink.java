package com.xnj.linked;


import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * 给定一个单链表的头节点 head， 再给定一个整数 pivot， 实现一个吊坠链表的函数，将链表调整为左边小于 pivot， 中间等于pivo，
 * 右边大于pivo
 *
 * 思路：1.荷兰国旗问题，用一个数组装Node 节点，再进行（不稳定）空间复杂度O(N)
 *      2.时间复杂度 O(N), 空间复杂度O(1)
 *
 * @author chen xuanyi
 * @Date 2020/5/1 14:38
 */
public class SortLink {

    public static void sortLink(Node head, int value){
        Node[] arr;
        //先确定数组大小
        Node cur = head;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        arr = new Node[length];

        cur = head;
        //将 node 存放到数组
        for (int i = 0; i < length ; i++) {
            arr[i] = cur;
            cur = cur.next;
        }

        int left = -1;
        int right = arr.length;

        int theNode = 0;

        //进行排序
        while (theNode < right) {
            if (theNode < value){
                swap(arr,++left, theNode++);
            } else if (theNode > value) {
                swap(arr, right--, theNode);
            }else {
                theNode++;
            }
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] == arr[length - 1]){
                arr[i].next = null;
                break;
            }
            arr[i].next = arr[i+1];
        }
    }

    public static Node sortLink2(Node head, int value){
        //三个链表记录 小于，等于，大于 value的值，最后再连接
        Node lessHead = null;
        Node lessEnd = null;

        Node equalHead = null;
        Node equalEnd = null;

        Node moreHead = null;
        Node moreEnd = null;

        Node next ;
        //将head中的节点分到3个新链表中
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < value) {
                if (lessHead == null) {
                    lessHead = head;
                    lessEnd = head;
                }else{
                    lessEnd.next = head;
                    lessEnd = lessEnd.next;
//                    lessEnd = head;
                }
            } else if (head.value == value) {
                if (equalHead == null) {
                    equalHead = head;
                    equalEnd = head;
                }else {
                    equalEnd.next = head;
                    equalEnd = equalEnd.next;
//                    equalEnd = head;
                }
            }else {
                if (moreHead == head){
                    moreHead = head;
                    moreEnd = head;
                }else {
                    moreEnd.next = head;
                    moreEnd = moreEnd.next;
//                    moreEnd = head;
                }
            }
            head = head.next;
        }

        if (lessEnd != null){
            lessEnd.next = equalHead;
            //判断equal 是否为空，因为影响到后面的连接
            equalEnd = equalEnd == null ? lessEnd : equalEnd;
        }
        if (equalEnd != null) {
            equalEnd.next = moreHead;
            moreEnd.next = null;
        }

        return lessHead != null ? lessHead : (equalHead != null ? equalHead : moreHead);

    }


    private static void swap(Node[] arr, int i, int theNode) {
        Node temp = arr[i];
        arr[i] = arr[theNode];
        arr[theNode] = temp;
    }

}
