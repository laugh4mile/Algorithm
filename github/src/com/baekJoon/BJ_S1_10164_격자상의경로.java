package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_10164_격자상의경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int dp[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			dp[i][0] = 1;
		}
		for(int i=0; i<M; i++) {
			dp[0][i] = 1;
		}
		outer : for(int r=1; r<N; r++) {
			for(int c=1; c<M; c++) {
				dp[r][c] = dp[r-1][c] + dp[r][c-1];
				if(M*r+c+1==K) break outer;
			}	
		}
		System.out.println(K/M+" "+K%M);
		for(int r=K/M; r<N; r++) {
			for(int c=K%M-1; c<M; c++) {
				
			}	
		}
		
		for(int x[]: dp) {
			System.out.println(Arrays.toString(x));
		}
	}

	static String src =
			"3 5 8";
}
