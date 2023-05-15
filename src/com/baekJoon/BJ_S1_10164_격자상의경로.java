package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_10164_격자상의경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		int answer = solution();
		System.out.println(answer);
		
	}

	private static int solution() {
		int dp[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			dp[i][0] = 1;
		}
		for(int i=0; i<M; i++) {
			dp[0][i] = 1;
		}
		for(int r=1; r<N; r++) {
			for(int c=1; c<M; c++) {
				dp[r][c] = dp[r-1][c] + dp[r][c-1];
			}	
		}
		if (K==0) return dp[N-1][M-1]; // 0이면 마지막 인덱스 리턴
		K--;
		int nr = K/M;
		int nc = K%M;
		for(int i=nr; i<N; i++) {
			dp[i][nc] = dp[nr][nc];
		}
		for(int i=nc; i<M; i++) {
			dp[nr][i] = dp[nr][nc];
		}
		for(int r=nr+1; r<N; r++) {
			for(int c=nc+1; c<M; c++) {
				dp[r][c] = dp[r-1][c] + dp[r][c-1];
			}	
		}

		return dp[N-1][M-1];
	}

	static String src =
			"1 1 0";
}
