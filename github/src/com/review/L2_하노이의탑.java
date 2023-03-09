package com.review;

import java.util.Arrays;

public class L2_하노이의탑 {
    static int answer[][], cnt;
    static int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];

        hanoi(n,1,3,2);

        return answer;
    }

    private static void hanoi(int n, int from, int to, int via) {
        if(n == 1){
            move(1, from, to);
            return;
        }else{
            hanoi(n-1, from, via, to);
            move(n,from,to);
            hanoi(n-1, via, to, from);
        }
    }

    private static void move(int i, int from, int to) {
        answer[cnt][0] = from;
        answer[cnt++][1] = to;
    }

    public static void main(String[] args) {
        int n = 2;
        for(int[] x : solution(n)){
            System.out.println(Arrays.toString(x));
        }
    }
}
