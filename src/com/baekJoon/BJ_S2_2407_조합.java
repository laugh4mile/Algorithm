package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_S2_2407_조합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int R = Integer.parseInt(tokens.nextToken());
		BigInteger dp[][] = new BigInteger[101][101];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(i==j || j==0) {
					dp[i][j] = new BigInteger("1");
				}else {
					dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
				}
			}	
		}
		System.out.println(dp[N][R]);
	}


	static String src =
			"100 6";
}
