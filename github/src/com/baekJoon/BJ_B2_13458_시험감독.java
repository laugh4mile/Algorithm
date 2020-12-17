package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_13458_시험감독 {
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
//		System.out.println(Arrays.toString(supervisor));
		cal();
	}

	private static void cal() {
		String result = String.valueOf(supervisor[0]);
		for(int i=1; i<supervisor.length; i++) {
			String p = String.valueOf(supervisor[i]);
			result = plus(result, p);
		}
		System.out.println(result);
	}

	private static String plus(String str1, String str2) {
		int gap = Math.abs(str1.length() - str2.length());
		String max = "";
		String result = "";
		StringBuffer min = new StringBuffer();
		if(str1.length() < str2.length()) {
			max = str2;
			for(int i=0; i<gap; i++) {
				min.append(0);
			}
			min.append(str1);
		}else {
			max = str1;
			for(int i=0; i<gap; i++) {
				min.append(0);
			}
			min.append(str2);
		}
		result = realCal(max,min);
		
		return result;
	}

	private static String realCal(String max, StringBuffer min) {
		StringBuffer result = new StringBuffer();
		StringBuffer result2 = new StringBuffer();
		String result3 = "";
		int sum = 0;
		int carry = 0;
		for(int i=max.length()-1; i>=0; i--) {
			sum = max.charAt(i) + min.charAt(i) - '0' - '0' + carry;
			if(sum > 9) {
				sum -= 10;
				carry = 1;
			}else {
				carry = 0;
			}
			result.append(sum);
		}
		if(carry == 1) {
			result.append(1);
		}
		for(int i=result.length()-1; i>=0 ; i--) {
			result2.append(result.charAt(i));
		}
		result3 = result2.toString();
		return result3;
	}

	static String src =
			"3\r\n" + 
			"6 7 8\r\n" + 
			"4 3";
}