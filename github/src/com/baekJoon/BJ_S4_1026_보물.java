package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_1026_보물 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int A[] = new int[N];
		int B[] = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer += A[i]*B[N-i-1];
		}
		System.out.println(answer);
	}

	static String src =
			"9\r\n" + 
			"5 15 100 31 39 0 0 3 26\r\n" + 
			"11 12 13 2 3 4 5 9 1";
}
