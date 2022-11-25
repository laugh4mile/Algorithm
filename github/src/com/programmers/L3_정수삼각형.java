package com.programmers;

import java.util.Arrays;

class L3_정수삼각형 {
    public static int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[triangle.length+1][triangle.length+1];

        for(int r=0; r<triangle.length; r++){
            for(int c=0; c<triangle[r].length; c++){
                dp[r+1][c+1] = triangle[r][c];
            }
        }

        for (int r=1; r<dp.length; r++){
            for (int c=1; c<dp.length; c++){
                dp[r][c] = Math.max(dp[r-1][c], dp[r-1][c-1]) + dp[r][c];
                answer = Math.max(answer, dp[r][c]);
            }
        }

        for(int[] x : dp){
            System.out.println(Arrays.toString(x));
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
}