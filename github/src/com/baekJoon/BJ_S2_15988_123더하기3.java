package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_15988_123더하기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		long dp[] = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<1000001; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		StringBuilder sb = new StringBuilder(); 
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(input.readLine());
			sb.append(dp[n]%1000000009+"\n");
		}
		System.out.println(sb);
//		System.out.println();
//		System.out.println();
//		System.out.println(dp[1000000]%1000000009);
	}

	static String src =
			"3\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"10";
}
