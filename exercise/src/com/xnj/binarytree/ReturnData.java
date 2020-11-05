package com.xnj.binarytree;

/**
 * 返回平衡二叉树的高度差
 *
 * @author chen xuanyi
 * @Date 2020/5/8 11:56
 */
public class ReturnData {
    public boolean isB;
    public int h;

    public ReturnData(boolean isB, int h) {
        this.isB = isB;
        this.h = h;
    }

    public static boolean isB(Node head){
        if (head == null) {
            return true;
        }
        return process(head).isB;
    }

    public static ReturnData process(Node head){
        if (head == null) {
            return new ReturnData(true, 0);
        }
        ReturnData leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnData(false, 0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1){
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
    }
}
