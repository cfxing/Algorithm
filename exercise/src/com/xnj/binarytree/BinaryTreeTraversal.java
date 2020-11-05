package com.xnj.binarytree;

import java.util.Stack;

/**
 * 前序遍历（递归，非递归） ， 中序遍历， 后序遍历
 *
 * 递归方式：
 *      看打印的顺序不同，遍历相同
 *
 * @author chen xuanyi
 * @Date 2020/5/2 18:25
 */
public class BinaryTreeTraversal {

    //前序遍历递归
    public static void preOrderRecur(Node head){
        if (head == null) {
            return;
        }
        System.out.println(head);
        preOrderRecur(head.left);
        preOrderRecur(head.right);

    }
    //前序遍历非递归
    //中左右
    //先将中压入栈
    //如果栈不为空，则弹出
    //如果再将这个节点的 右，左压入栈
    public static void preOrderUnRecur(Node head){
        if (head == null) {
            return;
        }else {//head != null
            Stack<Node> stack = new Stack<>();
            stack.push(head);
//            stack.add(head);
            while (!stack.isEmpty()) {
                Node s = stack.pop();
                System.out.print(s.value + " ");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }

        }

    }
    //中序遍历递归
    public static void inOrderRecur(Node head){
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head);
        inOrderRecur(head.right);

    }
    //中序遍历非递归
    public static void inOrderUnRecur(Node head){
        if (head == null) {
            return;
        }else {//head != null
            Stack<Node> stack = new Stack<>();
//            while (head != null) {
//                stack.push(head);
//                head = head.left;
//            }
            while (head != null || !stack.isEmpty()) {
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head + " ");
                    head = head.right;
                }
            }
        }
    }
    //后续遍历递归
    public static void posOrderRecur(Node head){
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head);
    }
    //后续遍历非递归
    //左右中 -> 中右左（逆序） -> 中左右（前序遍历）的反转
    public static void posOrderUnRecur(Node head){
        if (head == null) {
            return;
        }else {// head != null
            //存遍历时的节点
            Stack<Node> nodes = new Stack<>();
            //中右左
            Stack<Node> stack = new Stack<>();

            nodes.push(head);
            while (!nodes.isEmpty()) {
                head = nodes.pop();
                stack.push(head);
                if (head.left != null) {
                    nodes.push(head.left);
                }
                if (head.right != null) {
                    nodes.push(head.right);
                }
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop().value + " ");
            }

        }

    }

    //使用一个栈完成
    public static void posOrderUnRecur2(Node head){
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node cur = null;
            while (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.left != null && head != cur.left && head != cur.right) {
                    stack.push(cur.left);
                } else if (cur.right != null && head != cur.right) {
                    stack.push(cur.right);
                }else {
                    System.out.print(stack.pop().value + " ");
                    head = cur;
                }
            }
        }
    }

}
