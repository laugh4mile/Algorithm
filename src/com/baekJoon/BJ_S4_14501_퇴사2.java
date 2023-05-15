package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_14501_퇴사2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int dp[] = new int[21];
		int arr[][] = new int[N+2][2];
		for(int i=1; i<N+1; i++) {
			tokens = new StringTokenizer(input.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=1; i<N+2; i++) {
			dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i]+arr[i][1]);
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		System.out.println(dp[N+1]);
	}

	static String src =
			"10\r\n"
			+ "1 1\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 4\r\n"
			+ "1 5\r\n"
			+ "1 6\r\n"
			+ "1 7\r\n"
			+ "1 8\r\n"
			+ "1 9\r\n"
			+ "1 10";
}
