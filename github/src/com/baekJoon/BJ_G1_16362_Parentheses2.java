package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G1_16362_Parentheses2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		
		System.out.println(solve(str));
	}

	private static String solve(String str) {
		String error =  "error";
		String proper =  "proper";
		String improper =  "improper";
		str = str.replace(" ", ""); // 공백 제거
		int N = str.length();
		char[] arr = new char[N];
		int cnt = 0;
		
		// error 검사 1 + 문자 치환
		for (int i = 0; i < N; i++) {
			if(str.charAt(i) == '(') {
				arr[i] = '(';
				cnt++;
			}else if(str.charAt(i) == ')') {
				arr[i] = ')';
				if(cnt<=0) {
					return error;
				}
				cnt--;
			}else if(Character.isLowerCase(str.charAt(i))) { // 문자는 전부 c 로 치환.
				arr[i] = 'c';
			}else { // 연산자는 전부 o 로 치환.
				arr[i] = 'o';
			}
		}
		if (cnt != 0) return error;
		str = new String(arr);
		String str1 = str;
		while(true) {
			if(str1.contains("coc")) {
				str1 = str1.replace("coc", "c");
			}else if(str1.contains("(c)")) {
				str1 = str1.replace("(c)", "c");
			}else {
				break;
			}
		}
		if(!str1.equals("c")) return error; 
		
		while(true) {
			if(str.contains("(coc)")) {
				str = str.replace("(coc)", "c");
			}else {
				break;
			}
		}
		if(str.equals("c") || str.equals("coc")) return proper; 
		
		return improper;
	}

	static String src = 
			"x + y + z";
}