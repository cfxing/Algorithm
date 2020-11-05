package com.xnj.linked;


import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.util.Stack;

/**
 * 额外空间复杂度：
 *  1.提供一个栈，遍历链表并放入栈中
 *      将链表（逆序）与栈中的数据向比较，相同则回文
 *
 *  2. 提供一个快指针，一个慢指针，块指针一次走两步，慢指针一次走一步
 *      当快指针走完后，慢指针走到了中点的位置
 *      然后将慢指针后的数据压入栈
 *      然后从头遍历链表，再取出栈中的数据进行比较
 *          当栈中数据取完，还没有不同时
 *          说明是回文链表
 *          1 ->2 ->2 ->1
 *
 *   3.提供一个快指针，一个慢指针，块指针一次走两步，慢指针一次走一步
 *       当快指针走完后，慢指针走到了中点的位置
 *       然后将右半部分逆序
 *       再比较左半部分和右半部分，有一个不同则返回为false（分奇偶，如果有一个为null，则停止比较）
 *       最后将右半部分再逆序回去
 *
 * @author chen xuanyi
 * @Date 2020/4/30 18:22
 */
public class HuiWen {

    public static void main(String[] args) {
        add(new Node(1));
        add(new Node(2));
        add(new Node(3));
        add(new Node(2));
        add(new Node(1));
        add(new Node(0));

        boolean palindrome1 = isPalindrome1(head);
        boolean palindrome2 = isPalindrome2(head);
        boolean palindrome3 = isPalindrome3(head);

        System.out.println(palindrome1 + "\t" + palindrome2 + "\t" + palindrome3);

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

    //need n extra space
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //need n/2 extra space
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        //慢指针：一次一步
        //当快指针走到最后时，慢指针指到右边第一个
        Node right = head.next;
        //快指针：一次两步
        Node cur = head;
        while (cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null){
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //need O(1) extra place
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {//find mid node
            n1 = n1.next;// n1 -> mid
            n2 = n2.next.next;//n2 -> end
        }
        n2 = n1.next;//n2 -> right part first node
        n1.next = null;//mid.next -> null
        Node temp = null;
        while (n2 != null) {//right part convert
            temp = n2.next;//temp -> save next node
            n2.next = n1;//next of right node convert
            n1 = n2;//n1 move
            n2 = temp;//n2 move
        }
        temp = n1;//temp -> save last node
        n2 = head;//n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) {//check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;//right to end
            n2 = n2.next;//left to mid
        }
        n1 = temp.next;
        temp.next = null;
        while (n1 != null){//recover list
            n2 = n1.next;
            n1.next = temp;
            temp = n1;
            n1 = n2;
        }
        return res;

    }

}

class Node{
    int value;
    Node next;
    Node rand;

    public Node(int value) {
        this.value = value;
    }


}
