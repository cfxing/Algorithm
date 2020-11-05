package com.xnj.binarytree;

/**
 * 返回完全二叉树的节点个数，时间复杂度小于 O（N）
 *
 * @author chen xuanyi
 * @Date 2020/5/8 15:45
 */
public class CompleteTreeNodeNumber {

    public static int nodeNum(Node head){
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     *
     * @param node  当前的节点
     * @param level 它所在的层次（从1开始）
     * @param height 该完全二叉树的高度（从1开始）
     * @return 返回以该 node为根结点的树的节点个数
     */
    private static int bs(Node node, int level, int height) {
        if (level == height) {
            return 1;
        }
        //判断当前 node 的右子树的 高度（即左子树）是否与 总的高度相同
        //如果相同，说明 该 node 的左子树 是一颗满二叉树 节点个数为： 2^(height - level)  - 1
        //再加上 node 本身就是  2^(height - level)
        //如果不相同，说明 node 的右子树 是一颗满二叉树（注：完全二叉树的叶子节点的高度差为1）
        //所以 node 的右子树的节点个数为 ： 2^(height - level - 1 )
        if (mostLeftLevel(node.right, level + 1) == height){
            return (1 << (height - level)) + bs(node.right, level + 1, height);
        }else {
            return (1 << (height - level - 1)) + bs(node.left, level + 1, height);
        }
    }

    private static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

}
