package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S1_11057_오르막수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		long dp[][] = new long[N+1][10];
		for(int i=0; i<10; i++) {
			dp[1][i] = 1;
		}
		for(int i=2; i<N+1; i++) {
			int cnt = 0;
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=cnt; k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j] = dp[i][j]%10007;
				cnt++;
			}
		}
		long answer = 0;
		for(int i=0; i<10; i++) {
			answer += dp[N][i];
		}
		System.out.println(answer%10007);
	}

	static String src =

			"1000";
}
