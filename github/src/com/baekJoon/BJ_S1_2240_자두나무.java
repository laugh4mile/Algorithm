package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2240_자두나무 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int T = Integer.parseInt(tokens.nextToken());
		int W = Integer.parseInt(tokens.nextToken());
		
		int plum[][] = new int[T+1][2];
		for(int t=1; t<T+1; t++) {
			int tree = Integer.parseInt(input.readLine());
			if(tree == 1) {
				plum[t][0] = 1;
			}else {
				plum[t][1] = 1;
			}
		}
		
		int dp[][] = new int[T+1][W+1];
		for(int i=1; i<T+1; i++) {
			dp[i][0] = dp[i-1][0] + plum[i][0];
		}
		
		for(int r=1; r<T+1; r++) {
			for(int c=1; c<W+1; c++) {
				if(c%2 == 1) {
					dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + plum[r][1]; 
				}else {
					dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + plum[r][0]; 
				}
			}	
		}
		
//		for(int x[] : dp) {
//			System.out.println(Arrays.toString(x));
//		}
		int max = 0;
		for(int i=0; i<W+1; i++) {
			if(max < dp[T][i]) {
				max = dp[T][i];
			}
		}
		System.out.println(max);
	}

	static String src =
			"7 2\r\n" + 
			"2\r\n" + 
			"1\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"2\r\n" + 
			"1\r\n" + 
			"1";
}
