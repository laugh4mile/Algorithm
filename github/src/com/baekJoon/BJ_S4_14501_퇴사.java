package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_14501_퇴사 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int dp[] = new int[N+2];
		int arr[][] = new int[N+2][2];
		for(int i=1; i<N+1; i++) {
			tokens = new StringTokenizer(input.readLine());
			arr[i][0] = Integer.parseInt(tokens.nextToken());
			arr[i][1] = Integer.parseInt(tokens.nextToken());
			for(int j=i+arr[i][0]; j<N+2; j++) {
				dp[j] = Math.max(dp[j], dp[i]+arr[i][1]);
			}
		}
		System.out.println(dp[N+1]);
	}

	static String src =
			"10\r\n"
			+ "5 50\r\n"
			+ "4 40\r\n"
			+ "3 30\r\n"
			+ "2 20\r\n"
			+ "1 10\r\n"
			+ "1 10\r\n"
			+ "2 20\r\n"
			+ "3 30\r\n"
			+ "4 40\r\n"
			+ "5 50";
}
