package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G1_16362_Parentheses {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		
		String answer = solve(str);
		System.out.println(answer);
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
		
		// error 검사 2
		for (int i = 0; i < N; i++) {
			if (arr[i] == '(') { // 여는 괄호일 경우 앞에 여는 괄호나 연산자만 올 수 있다.
				if(i>0 && (arr[i-1] == ')' || arr[i-1] == 'c')) {
					return error;
				}
			}else if (arr[i] == ')') { // 닫는 괄호일 경우 앞에 닫는 괄호나 문자만 올 수 있다.
				if(i>0 && (arr[i-1] == '(' || arr[i-1] == 'o')) {
					return error;
				}
			}else if (arr[i] == 'c'){ // 알파벳일 경우 앞에 여는 괄호나 연산자만 올 수 있다.
				if(i>0 && (arr[i-1] == ')' || arr[i-1] == 'c')) {
					return error;
				}
			}else { // 연산자일 경우 앞에 닫는 괄호나 문자만 올 수 있다.
				if(i>0 && (arr[i-1] == '(' || arr[i-1] == 'o')) {
					return error;
				}
			}
		}
		str = str.replace("o(coc)", "");
		while(true) {
			if(str.contains("(coc)")) {
				str = str.replace("(coc)", "c");
			}else {
				break;
			}
		}
		// improper 검사 
		if(arr[0] == '(' && arr[N-1] == ')') {
			return improper;
		}
		if(str.contains("(c)")) {
			return improper;
		}
		if(str.contains("cococ")) {
			return improper;
		}
		return proper;
	}

	static String src = 
			"( (((a+b)+(c+d)) + ((a+b) + (c+d))) % (((a+b)+(c+d)) + ((a+b) + (c+d)))) * ( (((a+b)+(c+d)) + ((a+b) + (c+d))) % (((a+b)+(c+d)) + ((a+b) + (c+d))))";
}