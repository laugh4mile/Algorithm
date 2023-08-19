package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_17212_달나라토끼를위한구매대금지불도우미 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int dp[] = new int[100001];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;
		for(int i=8; i<100001; i++) {
			dp[i] = Math.min(dp[i-7]+1, dp[i-5]+1);
			dp[i] = Math.min(dp[i], dp[i-2]+1);
			dp[i] = Math.min(dp[i], dp[i-1]+1);
		}
		System.out.println(dp[N]);
	}

	static String src =
			"21";
}
