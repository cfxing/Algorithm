package com.xnj.binarytree;


/**
 * 根节点的 parent 为 null
 *
 * @author chen xuanyi
 * @Date 2020/5/7 14:36
 */

public class GetPreNode {

    //返回node 的前驱节点
    public static Node getPreNode(Node node){
        if (node == null) {
            return node;
        }

        if (node.left != null) {
            return getLastRight(node.left);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    //返回head 的最右的一个节点
    private static Node getLastRight(Node head) {
        if (head == null) {
            return head;
        }
        while (head.right != null) {
            head = head.right;
        }
        return head;
    }

}
