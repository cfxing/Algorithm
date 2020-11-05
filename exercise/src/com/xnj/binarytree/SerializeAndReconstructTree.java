package com.xnj.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的序列化和反序列化
 * 
 * @author chen xuanyi
 * @Date 2020/5/7 22:08
 */
public class SerializeAndReconstructTree {
    
    //前序遍历序列化
    public static String serialByPre(Node head){
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
            
    }
    
    //前序遍历反序列化
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
        
    }
    
    //中序序列化
    public static String serialByInOrder(Node head){
        if (head == null) {
            return "#_";
        }
        String res = null;
        res += serialByInOrder(head.left);
        res += head.value + "_";
        res += serialByInOrder(head.right);
        
        return res;

    }
    
    //中序反序列化
    public static Node reconInOrderString(String InString){
        String[] values = InString.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
            
        }
        return reconInOrder(queue);
    }

    //待修改
    private static Node reconInOrder(Queue<String> queue) {
        String value = queue.poll();
        Node head = new Node(Integer.valueOf(value));
        return head;

    }
    
    
    public static String serialByPost(Node head){
        if (head == null) {
            return "#_";
        }
        String res = null;
        res += serialByPost(head.left);
        res += serialByPost(head.right);
        res += head.value + "_";
        
        return res;
    }
    
    public static Node reconPostOrderString(String postString){
        String[] values = postString.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
            
        }
        return reconPostOrder(queue);
    }

    //待修改
    private static Node reconPostOrder(Queue<String> queue) {
        String value = queue.poll();
        Node head = new Node(Integer.valueOf(value));
        return head;

    }


    //水平序列化
    public static String serialByLevel(Node head){
        if (head == null) {
            return "#_";
        }
        String res = head.value + "_";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "_";
                queue.offer(head.left);
            }else {
                res += "#_";
            }
            if (head.right != null) {
                res += head.right.value + "_";
                queue.offer(head.right);
            }else {
                res += "#_";
            }
        }
        return res;
        
    }
    
    //水平反序列化
    public static Node reconByLevelString(String leveStr){
        String[] values = leveStr.split("_");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByString(String value) {
        if (value.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(value));
    }
    
    

}
