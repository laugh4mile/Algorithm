package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_2294_동전2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		int coins[] = new int[n];
		int dp[] = new int[10001];
		Arrays.fill(dp, 10001);
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(input.readLine());
			if(coins[i] < 10001) {
				dp[coins[i]] = 1;
			}
		}
		for(int i=1; i<=k; i++) {
			for(int j=0; j<n; j++) {
				if(i-coins[j] >= 0 && dp[i] > dp[i-coins[j]]+1) {
					dp[i] = dp[i-coins[j]]+1;
				}
			}
		}
//		for(int i=0; i<=k; i++) {
//			System.out.print(dp[i]+" ");
//		}
		if(dp[k] > 10000) {
			System.out.println(-1);
		}else {
			System.out.println(dp[k]);
		}
	}

	static String src =
			"3 1\r\n"
			+ "2\r\n"
			+ "7\r\n"
			+ "10";
}
