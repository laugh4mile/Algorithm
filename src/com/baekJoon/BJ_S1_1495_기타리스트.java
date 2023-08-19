package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1495_기타리스트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, S, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		boolean dp[][] = new boolean[N+1][M+1];
		dp[0][S] = true;
		tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<N+1; i++) {
			int volume = Integer.parseInt(tokens.nextToken());
			for(int j=0; j<M+1; j++) {
				if(isIn(j-volume) && dp[i-1][j-volume]) {
					dp[i][j] = true;
				}
				if(isIn(j+volume) && dp[i-1][j+volume]) {
					dp[i][j] = true;
				}
			}
		}
		int answer = -1;
		for(int i=M; i>=0; i--) {
			if(dp[N][i]) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
	static boolean isIn(int v) {
		return (v>=0 && v<=M);
	}
	static String src =

			"14 40 243\r\n" + 
			"74 39 127 95 63 140 99 96 154 18 137 162 14 88";
}
