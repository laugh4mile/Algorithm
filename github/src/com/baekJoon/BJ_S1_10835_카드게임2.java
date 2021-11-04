package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_10835_카드게임2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens, tokens2;
	static int A[], B[], dp[][], N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		A = new int [N];
		B = new int [N];
		dp = new int[N][N];
		tokens = new StringTokenizer(input.readLine());
		tokens2 = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens2.nextToken());
			A[i] = a;
			B[i] = b;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dp[i][j] = -1;
			}	
		}
		solve(0, 0);	
		
		for(int x[] :dp) {
			System.out.println(Arrays.toString(x));
		}
	}
	private static int solve(int i, int j) {
		if(i==N || j==N) return 0;
		if(dp[i][j] != -1) return dp[i][j];
		
		dp[i][j] = Math.max(solve(i+1, j), solve(i+1, j+1));
		
		if(A[i] > B[j]) {
			return Math.max(dp[i][j], solve(i, j+1) + B[j]);
		}
		return dp[i][j];
	}
	static String src =
			"4\r\n"
			+ "2 1 2 3\r\n"
			+ "1 1 3 2";
//			"7\r\n"
//			+ "5 9 4 7 2 3 12\r\n"
//			+ "2 6 1 3 11 13 1";
}
