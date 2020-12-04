package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N, num[], max, min;
	static char operator[],result[];
	static boolean isSelected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(input.readLine());
			num = new int[N];
			operator = new char[N-1];
			result = new char[N-1];
			isSelected = new boolean[N-1];
			tokens = new StringTokenizer(input.readLine());
			int plus = Integer.parseInt(tokens.nextToken());
			int minus = Integer.parseInt(tokens.nextToken());
			int mul = Integer.parseInt(tokens.nextToken());
			int div = Integer.parseInt(tokens.nextToken());
			int cnt = 0;
			for(int i=0; i<plus; i++) {
				operator[cnt++] = '+';
			}
			for(int i=0; i<minus; i++) {
				operator[cnt++] = '-';
			}
			for(int i=0; i<mul; i++) {
				operator[cnt++] = '*';
			}
			for(int i=0; i<div; i++) {
				operator[cnt++] = '/';
			}
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(tokens.nextToken());
			}
			
//			System.out.println(Arrays.toString(operator));
//			System.out.println(Arrays.toString(num));
			permutation(0);
			
			System.out.println("#"+t+" "+ (max-min));
			
		}
	}

	private static void permutation(int cnt) {
		if(cnt == N-1) {
			int value = calculation(result);
			if(value > max) {
				max = value;
			}
			if(value < min) {
				min = value;
			}
			return;
		}
		for(int i=0; i<N-1; i++) {
			if(isSelected[i]) continue;
			result[cnt] =  operator[i];
			
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}

	private static int calculation(char[] result) {
		int value = num[0];
//		System.out.println(value);
		for(int i=0; i<N-1; i++) {
			if(result[i]=='+') {
				value = value + num[i+1];
//				System.out.println(value);
			}
			if(result[i]=='-') {
				value = value - num[i+1];
//				System.out.println(value);
			}
			if(result[i]=='*') {
				value = value * num[i+1];
//				System.out.println(value);
			}
			if(result[i]=='/') {
				value = value / num[i+1];
//				System.out.println(value);
			}
		}
		return value;
	}

	static String src =
			"10\r\n" + 
			"5\r\n" + 
			"2 1 0 1\r\n" + 
			"3 5 3 7 9\r\n" +
			"6\r\n" + 
			"4 1 0 0\r\n" + 
			"1 2 3 4 5 6 \r\n" + 
			"5\r\n" + 
			"1 1 1 1\r\n" + 
			"9 9 9 9 9 \r\n" + 
			"6\r\n" + 
			"1 4 0 0\r\n" + 
			"1 2 3 4 5 6 \r\n" + 
			"4\r\n" + 
			"0 2 1 0\r\n" + 
			"1 9 8 6\r\n" + 
			"6\r\n" + 
			"2 1 1 1\r\n" + 
			"7 4 4 1 9 3 \r\n" + 
			"7\r\n" + 
			"1 4 1 0\r\n" + 
			"2 1 6 7 6 5 8 \r\n" + 
			"8\r\n" + 
			"1 1 3 2\r\n" + 
			"9 2 5 3 4 9 5 6 \r\n" + 
			"10\r\n" + 
			"1 1 5 2\r\n" + 
			"8 5 6 8 9 2 6 4 3 2 \r\n" + 
			"12\r\n" + 
			"2 1 6 2\r\n" + 
			"2 3 7 9 4 5 1 9 2 5 6 4 ";
}
