package com.xnj.binarytree;

/**
 *
 * 后继节点：中序遍历的后一个节点
 * 前驱节点：中序遍历的前一个节点
 *
 * x的后继节点：如果x有右子树，则x 的后继节点为右子树的最左的节点
 *      如果x 没有右子树， 1. 如果x 不是它的父节点的左子节点，则继续往上，直到找到x 是某一个父节点的左子树，则x 的后继为该节点
 *                      2.如果 x 是它的父节点的左子节点，则该节点为 x 的后继
 * @author chen xuanyi
 * @Date 2020/5/7 13:39
 */

public class GetSuccessorNode {
//给定某个节点，返回其后继
    public static Node getSuccessorNode(Node node){
        if (node == null) {
            return node;
        }
        if (node.right != null){
            return getLastLeft(node.right);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }

    }

    //给定一个头节点，返回最左边的节点
    private static Node getLastLeft(Node head) {
        if (head.left == null) {
            return head;
        }
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

}
