package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_5557_1학년 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		M = 20;
		long dp[][] = new long[N-1][M+1];
		tokens = new StringTokenizer(input.readLine());
		int start = Integer.parseInt(tokens.nextToken());
		dp[0][start] = 1;
		for(int i=1; i<N-1; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			for(int j=0; j<M+1; j++) {
				if(isIn(j+num) && dp[i-1][j] != 0) {
					dp[i][j+num] += dp[i-1][j];
				}
				if(isIn(j-num) && dp[i-1][j] != 0) {
					dp[i][j-num] += dp[i-1][j];
				}
			}
		}
		int end = Integer.parseInt(tokens.nextToken());
		System.out.println(dp[N-2][end]);
	}
	static boolean isIn(int num) {
		return(num>=0 && num<=M);
	}
	static String src =
			"40\r\n" + 
			"1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 1";
}
