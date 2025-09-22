package com.review;

import java.util.Arrays;

public class L2_숫자블록 {
    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int)end - (int) begin +1];
        for(int i=(int)begin; i<=end; i++){
            if(i==1){
                answer[i-(int) begin] = 0;
            }else{
                answer[i-(int)begin] = solve(i);
            }
        }

        return answer;
    }

    private static int solve(int n) {
        int num = 1;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                if(n/i > 10000000) {
                    num = i;
                    continue;
                }
                return n/i;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        long begin = 1;
        long end = 10;
        long begin2 = 477559014;
        long end2 = 477559014;
//        System.out.println(Arrays.toString(solution(begin, end)));
        System.out.println(Arrays.toString(solution(begin2, end2)));
    }
}
