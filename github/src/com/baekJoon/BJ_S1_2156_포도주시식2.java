package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S1_2156_포도주시식2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		int dp[] = new int[n+1];
		int arr[] = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
		int max = 0;
		if(n==1) {
			System.out.println(arr[1]);
		}else if(n==2) {
			System.out.println(arr[1]+arr[2]);
		}else {
			max = arr[1] + arr[2];
			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];
			for(int i=3; i<n+1; i++) {
				dp[i] = dp[i-1];
				dp[i] = Math.max(dp[i], dp[i-2]+arr[i]);
				dp[i] = Math.max(dp[i], dp[i-3]+arr[i-1]+arr[i]);
				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
		}
	}

	static String src =
			"6\r\n"
			+ "100\r\n"
			+ "100\r\n"
			+ "1\r\n"
			+ "1\r\n"
			+ "100\r\n"
			+ "100";
}
