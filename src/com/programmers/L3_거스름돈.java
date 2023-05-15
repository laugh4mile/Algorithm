package com.programmers;

import java.util.Arrays;

public class L3_거스름돈 {
    public static int solution(int n, int[] money) {
        int mod = 1_000_000_007;
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                if(j-money[i] >= 0){
                    dp[j] += dp[j-money[i]] % mod;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1,2,5}));
    }
}
