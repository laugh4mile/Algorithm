package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1309_동물원 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int mod = 9901;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int dp[] = new int[N+1];
		dp[0] = 1; 
		dp[1] = 3; 
				
		for(int i=2; i<N+1; i++) {
			dp[i] = (dp[i-1]*2 + dp[i-2]) % mod;
		}
		System.out.println(dp[N]);
	}

	static String src =
			"100000";
}
