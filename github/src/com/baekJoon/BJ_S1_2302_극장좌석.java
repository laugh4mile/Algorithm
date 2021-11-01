package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2302_극장좌석 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		int seat[] = new int[N+1];
		boolean isVip[] = new boolean[N+1];
		for(int i=0; i<M; i++) {
			int vip = Integer.parseInt(input.readLine());
			isVip[vip] = true;
		}
		
		int dp[][] = new int[N+1][2];
		dp[0][1] = 1;
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i=2; i<N+1; i++) {
			dp[i][1] = dp[i-1][0] + dp[i-1][1];
			if(isVip[i] || isVip[i-1]){
				dp[i][0] = 0;
			}else {
				dp[i][0] = dp[i-2][0] + dp[i-2][1];
			}
		}
//		for(int x[] : dp) {
//			System.out.println(Arrays.toString(x));
//		}
		System.out.println(dp[N][0] + dp[N][1]);
		
	}

	static String src =
			"9\r\n" + 
			"2\r\n" + 
			"4\r\n" + 
			"7";
}
