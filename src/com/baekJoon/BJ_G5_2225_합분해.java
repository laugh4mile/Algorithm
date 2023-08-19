package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_2225_합분해 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int mod = 1_000_000_000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int dp[][] = new int[N+1][K+1];
		for(int n=1; n<N+1; n++) {
			dp[n][1] = 1;
		}
		for(int k=1; k<K+1; k++) {
			dp[1][k] = k;
		}
		
		for(int n=2; n<N+1; n++) {
			for(int k=2; k<K+1; k++) {
				dp[n][k] = (dp[n-1][k] + dp[n][k-1]) % mod; 
			}	
		}
		
		System.out.println(dp[N][K]);
		
	}

	static String src =
			"20 2";
}
