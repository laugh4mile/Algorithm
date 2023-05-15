package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_10835_카드게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens, tokens2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int A[] = new int [N];
		int B[] = new int [N];
		int dp[][] = new int[N][N];
		tokens = new StringTokenizer(input.readLine());
		tokens2 = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens2.nextToken());
			A[i] = a;
			B[i] = b;
		}
		
		for(int r=0; r<N; r++) {
			if((r>0 && dp[r-1][0] != 0)) {
				dp[r][0] = dp[r-1][0];
			}else {
				if(A[r] > B[0]) {
					dp[r][0] = B[0];
				}
			}
		}
		int sum = 0;
		for(int c=0; c<N; c++) {
			if(A[0] > B[c]) {
				sum += B[c];
				dp[0][c] = sum;
			}else {
				dp[0][c] = sum;
			}
		}
		for(int r=1; r<N; r++) {
			boolean flag = false;
			for(int c=1; c<N; c++) {
				
				if(!flag) {
					dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1] + B[c]);
				}else {
					dp[r][c] = Math.max(dp[r][c-1] ,dp[r-1][c]);
				}
			}	
		}
		for(int x[] : dp) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			if(answer < dp[N-1][i]) {
				answer = dp[N-1][i];
			}
		}
		System.out.println(answer);
	}
	static String src =
			"4\r\n"
			+ "2 1 2 3\r\n"
			+ "1 1 3 2";
//			"7\r\n"
//			+ "5 9 4 7 2 3 12\r\n"
//			+ "2 6 1 3 11 13 1";
}
