package com.xnj.recursion;

/**
 * 汉罗塔问题
 *
 * @author chen xuanyi
 * @Date 2020/5/31 10:25
 */
public class Hanoi {

    public static void Hanoi(int n) {
        if (n > 0){
            process(n,"left", "right", "mid");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        process(n,"left", "right", "mid");

    }

    public static void process(int n, String from, String to, String help){
        if (n == 1){
            System.out.println("Move 1 from" + from + "to " +to);
        }else {//1 ~ n 的问题
            process(n - 1, from, help, to);//n - 1 在 help上
            System.out.println("Move "+ n +" from " + from + " to " + to);
            process(n - 1, help, to, from);//将 n - 1 从help上移到 to, 借助from
        }
    }
}
