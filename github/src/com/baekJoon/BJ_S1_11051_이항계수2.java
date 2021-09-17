package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_11051_이항계수2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int mod = 10_007;
		long dp[][] = new long [N+1][N+1];
		for(int i=0; i<=N; i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
			}	
		}
		System.out.println(dp[N][K]);
	}

	static String src =

			"5 2";
}
