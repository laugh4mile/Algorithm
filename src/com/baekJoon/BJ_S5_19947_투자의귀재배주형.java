package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_19947_투자의귀재배주형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int H = Integer.parseInt(tokens.nextToken());
		int Y = Integer.parseInt(tokens.nextToken());
		int dp[] = new int[11];
		dp[0] = H;
		dp[1] = dp[0]+dp[0]/20;
		dp[2] = dp[1]+dp[1]/20;
		dp[3] = dp[0]+dp[0]/5;
		dp[4] = Math.max(dp[1]+dp[1]/5, dp[3] + dp[3]/20);
		dp[5] = dp[0] + dp[0]*7/20;
		for(int i=6; i<=Y; i++) {
			dp[i] = Math.max(dp[i-1]+dp[i-1]/20, dp[i-3]+dp[i-3]/5);
			dp[i] = Math.max(dp[i], dp[i-5]+dp[i-5]*7/20);
		}
		System.out.println(dp[Y]);
	}

	static String src =
			"25542 10";
}
