package com.xnj.binarytree;

import com.xnj.xnj;

import java.util.Currency;

/**
 * @author chen xuanyi
 * @Date 2020/5/8 16:29
 */
@xnj
public class CompleteTreeNodeNumber2 {

    public static int completeTreeNodeNumber(Node head){
        int num = 0;
        if (head == null) {
            return 0;
        }
        //得到树的高度
        int height = getHeight(head);
        //树所在的层
        int level = 1;
        while (head != null) {

            if ((getHeight(head.right) + level) == height) {//说明左子树为满二叉树
                num += (1 << (height - level));
                head = head.right;
                level++;
            } else {//说明右子树为满二叉树
                num += (1 << (height - level - 1));
                head = head.left;
                level ++;
            }
        }

        return num;

    }

    private static int getHeight(Node node){
        int height = 1;
        while (node.left != null) {
            height ++;
            node = node.left;
        }
        return height;
    }

}
