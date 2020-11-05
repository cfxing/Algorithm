package com.xnj.tanxin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chen xuanyi
 * @Date 2020/5/14 13:17
 */
public class Program {
    public int start;
    public int end;

    public Program(int start, int end) {
        this.start = start;
        this.end = end;

    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;//时间小的在前面
        }
    }

    public static int bestArrange(Program[] programs, int current){
        Arrays.sort(programs,new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (current <= programs[i].start){
                result++;
                current = programs[i].end;
            }
        }
        return result;
    }
}