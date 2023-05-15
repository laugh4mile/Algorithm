package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S1_2011_암호코드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int answer = solution(input.readLine());
		
		System.out.println(answer);
	}

	private static int solution(String str) {
		int n = str.length();
		int mod = 1_000_000;
		int[] arr = new int[n+1];
		for(int i=0; i<n; i++) {
			arr[i+1] = str.charAt(i) - '0';
		}

		int dp[] = new int[n+1];
		dp[0] = 1;
		if(arr[1] == 0) {
			return 0;
		}
		dp[1] = 1;
		for(int i=2; i<n+1; i++) {
			if(arr[i] == 0) {
				if(arr[i-1]*10 + arr[i] == 0 || arr[i-1]*10 + arr[i] > 26) {
					return 0;
				}else {
					dp[i] = dp[i-2];
				}
			}else {
				if(arr[i-1] != 0 && arr[i-1]*10 + arr[i] <= 26) {
					dp[i] = (dp[i-1] + dp[i-2]) % mod;
				}else {
					dp[i] = dp[i-1];
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
	static String src =
			"8100";
}
