package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_S1_11052_카드구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(input.readLine()); // 1 <= N <= 1000
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<=N; i++) {
			dp[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i/2; j++) {
				dp[i] = Math.max(dp[i], dp[i-j]+dp[j]);
			}
		}
		System.out.println(dp[N]);
		
	}

	static String src =
			"2\r\n"
			+ "3 5 15 16";
}
