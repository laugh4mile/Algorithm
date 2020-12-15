package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B5_10757_큰수A더하기B {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		String A = tokens.nextToken();
		String B = tokens.nextToken();

		int size = Math.abs(A.length()- B.length());
		StringBuffer zeros = new StringBuffer();
		for(int i=0; i<size; i++) {
			zeros.append(0);
		}
		if(A.length() < B.length()) {
			zeros.append(A);
			cal(zeros,B);
		}else {
			zeros.append(B);
			cal(zeros,A);
		}
//		System.out.println(zeros.charAt(0));
//		System.out.println(B.charAt(0));
//		System.out.println(zeros.charAt(0)+B.charAt(0) - '0'-'0');
	}

	private static void cal(StringBuffer min, String max) {
		int sum = 0;
		int carry = 0;
		StringBuffer sb = new StringBuffer();
		for(int i=min.length()-1; i>=0; i--) {
			sum = min.charAt(i) + max.charAt(i) + carry  - '0'-'0';
			if(sum>9) {
				sum = sum-10;
				carry = 1;
			}else {
				carry = 0;
			}
			sb.append(sum);
		}
		if(carry == 1) {
//			System.out.println("zzz");
			sb.append(1);
		}
		for(int i=sb.length()-1; i>=0; i--) {
			System.out.print(sb.charAt(i));
		}
//		System.out.println(sb);
	}

	static String src =
			"9223372036854775807 9223372036854775808";
}
