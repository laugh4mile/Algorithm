package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S1_2156_포도주시식 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		int dp[][] = new int[n+1][3];// 0:1, 1:01, 2;001
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
			dp[1][0] = arr[1];
			dp[1][1] = arr[1];
			dp[1][2] = arr[1];
			dp[2][0] = arr[1] + arr[2];
			dp[2][1] = arr[2];
			dp[2][2] = arr[2];
			max = arr[1] + arr[2];
			
			for(int i=3; i<n+1; i++) {
				dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + arr[i];
				dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + arr[i];
				dp[i][1] = Math.max(dp[i][1], dp[i-2][0] + arr[i]);
				dp[i][2] = Math.max(dp[i-3][1], dp[i-3][2]) + arr[i];
				dp[i][2] = Math.max(dp[i][2], dp[i-3][0] + arr[i]);
				max = Math.max(max, dp[i][0]);
				max = Math.max(max, dp[i][1]);
				max = Math.max(max, dp[i][2]);
			}
			System.out.println(max);
		}
//		for(int x[] : dp) {
//			System.out.println(Arrays.toString(x));
//		}
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
