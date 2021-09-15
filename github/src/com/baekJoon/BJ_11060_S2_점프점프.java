package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_11060_S2_점프점프 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int dp[] = new int[N+101];
		int arr[] = new int[N+1];
		tokens = new StringTokenizer(input.readLine());
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		dp[1] = 0;
		for(int i=1; i<N+1; i++) {
			for(int j=0; j<arr[i]; j++) {
//				if()
			}
		}
//		for(int i=1; i<11; i++) {
//			System.out.print(dp[i]+" ");
//		}
	}

	static String src =

			"10\r\n" + 
			"1 2 0 1 3 2 1 5 4 2";
}
