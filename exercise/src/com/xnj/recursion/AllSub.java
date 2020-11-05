package com.xnj.recursion;

/**
 * 打印字符串的所有的子序列
 *
 * 注：子序列和子串的区别
 *
 * @author chen xuanyi
 * @Date 2020/6/1 10:01
 */
public class AllSub {

    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {//当到达数组最后的位置
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);//不要当前字符
        printAllSub(str, i + 1, res + String.valueOf(str[i]));//要当前字符

    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test.toCharArray(), 0, " ");
    }

}
