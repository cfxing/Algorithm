package com.xnj.binarytree;

/**
 * 可以直观的看见一颗二叉树
 *
 *
 * @author chen xuanyi
 * @Date 2020/5/7 12:36
 */
public class PrintBinaryTree {

    public static void printBinaryTree(Node head){
        System.out.println("Binary Tree:");
        printIndor(head, 0, "H", 17);
        System.out.println();
    }

    private static void printIndor(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printIndor(head.right, height + 1, "v", len);
        String value = to + head.value + to;
        int lenM = value.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        value = getSpace(lenL) + value + getSpace(lenR);
        System.out.println(getSpace(height * len) + value);
        printIndor(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buffer = new StringBuffer(" ");
        for (int i = 0; i < num; i++) {
            buffer.append(space);
        }
        return buffer.toString();
    }

}
