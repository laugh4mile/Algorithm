package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_2579_계단오르기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		int stair[] = new int[n];
		int dp[][] = new int[n][2];
		for(int i=0; i<n; i++) {
			stair[i] = Integer.parseInt(input.readLine());
		}
		dp[0][0] = stair[0];
		dp[0][1] = 0;
		if(n>1) {
			dp[1][0] = stair[1];
			dp[1][1] = stair[0]+stair[1];
		}
		int cnt=0;
		for(int i=2; i<n; i++) {
			dp[i][0] = Math.max(dp[i-2][0] + stair[i], dp[i-2][1] + stair[i]) ;
			dp[i][1] = dp[i-1][0] + stair[i];
		}
//		for(int x[] : dp) {
//			System.out.println(Arrays.toString(x));
//		}
		if(n == 1) {
			System.out.println(dp[0][0]);
		}else {
			System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
		}
	}

	static String src =
			"1\r\n"
			+ "10\r\n"
			+ "20\r\n"
			+ "15\r\n"
			+ "25\r\n"
			+ "10\r\n"
			+ "20";
}
