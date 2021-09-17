package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S1_11057_오르막수2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		long dp[][] = new long[N+1][10];
		long answer = 0;
		for(int i=0; i<10; i++) {
			dp[0][i] = 1;
			dp[i][1] = 1;
		}
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=10; c++) {
				dp[r][c] = dp[r][c-1] + dp[r-1][c];
			}	
		}
		for(int i=0; i<10; i++) {
			answer += dp[N][i];
		}
		System.out.println(answer%10007);
	}

	static String src =
			"1000";
}
