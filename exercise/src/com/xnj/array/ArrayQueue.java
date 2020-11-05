package com.xnj.array;

/**
 * 使用数组实现循环队列，实现插入，删除数据操作
 *
 * @author chen xuanyi
 * @Date 2020/4/23 15:06
 */
public class ArrayQueue {

    int[] arr = new int[5];
    //数组中的数据个数
    static int size = 0;
    int start = 0;
    int end = 0;


    public void add(int n){//静态方法不能有非静态属性和方法
       if (size != arr.length){
           arr[end++] = n;
           size++;
       }
       if (size > arr.length){
           throw new ArrayIndexOutOfBoundsException("无法存储数据");
       }
       if (end == arr.length){

           end = 0;
       }
    }
    public int del(){
        if (size != 0) {
            size--;
            return arr[start++];
        }
        if (start == arr.length){
            start = 0;
        }
        throw new ArrayIndexOutOfBoundsException("没有数据");
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.add(3);
        arrayQueue.add(6);
        arrayQueue.add(9);
        arrayQueue.add(54);
        arrayQueue.add(34);
        int i1 = arrayQueue.del();
        arrayQueue.del();
        arrayQueue.del();
        arrayQueue.del();
        arrayQueue.add(55);


        for (int i = arrayQueue.start; i < arrayQueue.arr.length; i++) {
            System.out.println(arrayQueue.arr[i]);
        }
    }
}
