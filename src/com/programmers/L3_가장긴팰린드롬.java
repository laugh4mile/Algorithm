package com.programmers;

import java.util.Arrays;

public class L3_가장긴팰린드롬 {
    public static int solution(String s)
    {
        int answer = 0;
        int N = s.length();
        boolean dp[][] = new boolean[N][N];

        for(int i=0; i<N; i++){
            dp[i][i] = true;
            answer = 1;
        }

        for(int i=0; i<N-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                answer = 2;
            }
        }

        for(int len=3; len<=N; len++){
            for(int i=0; i<=N-len; i++){
                if(s.charAt(i) == s.charAt(i+len-1) && dp[i+1][i+len-2]){
                    dp[i][i+len-1] = true;
                    answer = Integer.max(answer, len);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abcdcba";
        System.out.println(solution(s));
    }
}
