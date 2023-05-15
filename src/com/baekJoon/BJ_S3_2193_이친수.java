package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S3_2193_이친수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static long D[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		D = new long[N+1];
		D[0] = 1;
		D[1] = 1;
		
		for(int i=2; i<=N; i++) {
			D[i] = D[i-1] + D[i-2];
		}
		System.out.println(D[N-1]);
	}

	static String src = "90";

}
