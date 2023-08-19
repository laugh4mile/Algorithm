package com.programmers;

import java.util.Arrays;

public class L3_스티커모으기2 {
    public static int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        int answer = 0;
        int copy1[] = new int[sticker.length-1];
        int copy2[] = new int[sticker.length-1];
        for(int i=0; i<sticker.length-1; i++){
            copy1[i] = sticker[i];
            copy2[i] = sticker[i+1];
        }
        answer = Integer.max(answer, getMaxSum(copy1));
        answer = Integer.max(answer, getMaxSum(copy2));

        return answer;
    }

    private static int getMaxSum(int[] sticker) {
        int[][] dp = new int[sticker.length][2];
        dp[0][0] = 0;
        dp[0][1] = sticker[0];
        for(int i=1; i<sticker.length; i++){
            dp[i][0] = Integer.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + sticker[i];
        }
        return Integer.max(dp[sticker.length-1][0], dp[sticker.length-1][1]);
    }

    public static void main(String[] args) {
        int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
        int sticker2[] = {1, 3, 2, 5, 4};
        System.out.println(solution(sticker)); // 36
        System.out.println(solution(sticker2)); // 8
    }
}
