package com.codingtest.line.fintechIntern;

import java.util.Arrays;

public class Q2_2 {
    static int[] x = {1, 2, 6, 8};
    static int[] y = {1, 2, 5, 7};
    static int[] x2 = {1, 2, 4, 2};
    static int[] y2 = {1, 1, 4, 2};
    static int[] x3 = {1, 9, 5, 8, 4};
    static int[] y3 = {1, 5, 3, 1, 7};
    public static void main(String[] args) {
        System.out.println(solution(x3, y3));
    }

    public static int solution(int[] x, int[] y) {
        int answer = 0;
        int N = x.length; // 섬의 개수
        int connection[] = new int[N];
        Arrays.fill(connection,Integer.MAX_VALUE);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j) continue;
                double distance = Math.sqrt(Math.pow(x[i]-x[j],2) + Math.pow(y[i]-y[j],2));
                System.out.println(distance);
                connection[i] = Math.min(connection[i], (int) Math.ceil(distance));
            }
            System.out.println(connection[i]);
            System.out.println();
        }
        for(int i=0; i<N-1; i++){
            answer = Math.max(answer, connection[i]);
        }
        return answer;
    }
}
