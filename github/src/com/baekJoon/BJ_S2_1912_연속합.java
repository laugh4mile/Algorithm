package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1912_연속합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		dp[0] = arr[0];
		int max = dp[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max = Math.max(dp[i], max);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}

	static String src =
			"5\r\n"
			+ "-1 -2 -3 -4 -5";
}
