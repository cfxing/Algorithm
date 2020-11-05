package com.xnj.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 获得 字典序最小的连接的字符串
 *
 * @author chen xuanyi
 * @Date 2020/5/13 16:47
 */
public class LowestLexicography {

    public static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static String lowestString(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i <strs.length ; i++) {
            res += strs[i];
        }
        return res;
    }

}
