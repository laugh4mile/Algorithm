package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S1_10844_쉬운계단수2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int mod = 1_000_000_000;

    public static void main(String[] args) throws NumberFormatException, IOException {
        input = new BufferedReader(new StringReader(src)); 
        N = Integer.parseInt(input.readLine());
        int dp[][] = new int[101][10];
        for(int i=1; i<=9; i++) {
        	dp[1][i] = 1;
        }
        for(int i=2; i<101; i++) {
        	dp[i][0] = dp[i-1][1];
        	for(int j=1; j<=8; j++) {
        		dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod ; 
        	}
        	dp[i][9] = dp[i-1][8];
        }
        long answer = 0;
        for(int i=0; i<=9; i++) {
        	answer += dp[N][i];
        }
        System.out.println(answer%mod);
    }

    static String src = "100";
}
