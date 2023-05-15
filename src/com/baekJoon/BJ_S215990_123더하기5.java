package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S215990_123더하기5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		
		long dp[][] = new long[100001][3];
		dp[1][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		for(int i=4; i<100001; i++) {
			dp[i][0] = (dp[i-1][1]+dp[i-1][2]) % 1000000009;
			dp[i][1] = (dp[i-2][0]+dp[i-2][2]) % 1000000009;
			dp[i][2] = (dp[i-3][0]+dp[i-3][1]) % 1000000009;
		}
		long answer[] = new long[100001];
		for(int i=1; i<100001; i++) {
			answer[i] = (dp[i][0]+dp[i][1]+dp[i][2]) % 1000000009; 
		}
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(input.readLine());
			sb.append(answer[n] +"\n");
		}
		System.out.println(sb);
	}

	static String src =
			"3\r\n" + 
			"4\r\n" + 
			"7\r\n" + 
			"10";
}