package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 못풀겠음. 솔루션 봐도 아리송
public class BJ_S1_2293_동전1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(tokens.nextToken());
		int k = Integer.parseInt(tokens.nextToken());
		long dp[] = new long[k+1];
		int coins[] = new int[n];
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(coins); // 정렬이 아닌가?
		dp[0] = 1;
		for(int i=0; i<n; i++) { // 1,2,5
			for(int j=coins[i]; j<=k; j++) {
				dp[j] = dp[j] + dp[j-coins[i]];
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[k]);
	}
	
	static String src =
			"3 10\r\n" + 
			"1\r\n" + 
			"2\r\n" + 
			"5";
}