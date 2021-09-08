package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S5_14916_거스름돈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		int dp[] = new int[100001];
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		for(int i=5; i<100001; i++) {
			if(i%5 == 0) {
				dp[i] = i/5;
			}else {
				dp[i] = dp[i-2]+1;
			}
		}
		System.out.println(dp[n]);
	}

	static String src =

			"14";
}
