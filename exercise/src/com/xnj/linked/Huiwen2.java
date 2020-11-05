package com.xnj.linked;

import com.sun.tools.javac.Main;
import com.xnj.xnj;

import java.util.Stack;

/**
 * @author chen xuanyi
 * @Date 2020/5/1 10:30
 */

@xnj
public class Huiwen2 {

    public static void main(String[] args) {
        add(new Node(1));
        add(new Node(2));
        add(new Node(3));
        add(new Node(2));
        add(new Node(1));
        add(new Node(0));

        boolean huiWen1 = huiWen1(head);
        boolean huiWen2 = huiWen2(head);
        boolean huiWen3 = huiWen3(head);

        System.out.println(huiWen1 + "  " + huiWen2 + "  " + huiWen3);


    }

    static Node head = new Node(0);
    public static void add(Node node){
        if (head.next == null ){
            head.next = node;
        }
        Node cur = head.next;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = node;

    }

    //n extra place
    public static boolean huiWen1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    // n/2 extra place
    public static boolean huiWen2(Node head){
        //指向右边的第一个
        Node rightFirst = head.next;
        //用来辅助寻找右边第一个
        Node cur = head;

        while ( cur.next != null && cur.next.next != null){
            rightFirst = rightFirst.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while (rightFirst != null){
            stack.push(rightFirst);
            rightFirst = rightFirst.next;
        }

        while (!stack.isEmpty()){
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;

        }
        return true;
    }

    //O(1) extra place
    public static boolean huiWen3(Node head){
        if (head.next == null || head == null){
            return true;
        }
        //记录中间及遍历左边的指针
        Node left = head;
        //记录右边部分的指针
        Node right = head;
        //辅助指针
        Node temp;

        //找到中点位置
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next;
        }

        right = left.next;
        left.next = null;

        //进行反转
        while (right != null) {
            temp = right.next;//记录后一个节点
            right.next = left;//将right 指向 left,进行反转
            left = right;
            right = temp;
        }

        //结束后left 会在最后一个node ，记录下来
        temp = left;
        //right 指向头节点，开始比较
        right = head;
        boolean res = true;
        while (left != null && right != null){
            if (left.value != right.value){
                res = false;
            }
            left = left.next;
            right = right.next;
        }

        //再反转变为原来的样子
        left = temp.next;//记录temp 的 下一个，当修改temp的next 时，避免找不到
        temp.next = null;
        right = left.next;
        while (left != null) {
            left.next = temp;
            temp = left;
            left = right;
            right = left.next;
        }
        return res;
    }

}
