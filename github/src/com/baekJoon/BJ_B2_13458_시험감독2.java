package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_13458_시험감독2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, A[], B, C, supervisor[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		supervisor = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		B = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		// 입력 끝
		
		for(int i=0; i<N; i++) {
			int value = A[i];
			value -= B;
			supervisor[i] ++;
			if(value<=0) {
				continue;
			}
			int vice = (int) Math.ceil((double)value/C);
			supervisor[i] += vice;
		}
		long result = 0;
		for(int i=0; i<supervisor.length; i++) {
			result += supervisor[i];
		}
		System.out.println(result);
	}

	static String src =
			"3\r\n" + 
			"6 7 8\r\n" + 
			"4 3";
}