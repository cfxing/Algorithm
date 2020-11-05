package com.xnj.recursion;

import javax.swing.*;
import java.util.HashSet;
import java.util.SplittableRandom;

/**
 * 打印一个字符串的全排列
 *
 * @author chen xuanyi
 * @Date 2020/6/1 10:30
 */
public class All_Permutations {

    public static void printAllPermutations1(String str){
        char[] chs = str.toCharArray();
        process1(chs, 0);
    }

    private static void process1(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process1(str, i + 1);
//            swap(str, i, j);
        }
    }

    public static void printAllPermutations2(String str){
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    private static void process2(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])){
                set.add(chs[j]);
                swap(chs,i,j);
                process2(chs, i + 1);
//                swap(chs, i, j);
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp;
        temp = str[i];
        str[i] = str[j];
        str[j] = str[i];
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations1(test1);
        System.out.println("++++++++++++++++++++++++++++++");
        printAllPermutations2(test1);
    }

}
