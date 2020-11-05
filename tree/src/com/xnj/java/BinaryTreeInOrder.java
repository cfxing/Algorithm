package com.xnj.java;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉排序数的中序遍历
 *
 * @author chen xuanyi
 * @Date 2020/5/11 18:03
 */
public class BinaryTreeInOrder {

    //法一：递归
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        inorderTraversal(root.left);
        list.add(root.value);
        inorderTraversal(root.right);

        return  list;

    }

    //法二：非递归
    public List<Integer> inorderTraversal2(TreeNode root){
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {

                TreeNode pop = stack.pop();
                list.add(pop.value);
                root = root.right;
            }
        }
        return list;
    }
}
