package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_19597_문자열뒤집기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		StringBuilder answer = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(input.readLine());
			String [] words = new String[N];
			for(int n=0; n<N; n++) {
				words[n] = input.readLine();
			}
			answer.append(solve(words)+"\n"); 
		}
		System.out.println(answer);
	}

	private static String solve(String[] words) {
		int answer[] = new int[words.length];
		String preStr = words[0];
//		StringBuilder reverse = new StringBuilder(preStr);
		String reverseStr = "";
	
		for(int i=1; i<words.length; i++) {
			String curStr = words[i];
			StringBuilder reverse = new StringBuilder(curStr);
			reverseStr = reverse.reverse().toString();
			if(preStr.compareTo(curStr) < 0) {
				preStr = curStr;
				answer[i] = 0;
			}else if(preStr.compareTo(reverseStr) < 0) {
				preStr = reverseStr;
				answer[i] = 1;
			}else { // 바꿔도 안바꿔도 기존보다 작으면 i를 거슬러 올라가며 맞을때 까지 preStr을 바꿔야한다.
				i--;
				reverse = new StringBuilder(preStr);
				preStr = reverse.reverse().toString();
				answer[i] = 1;
			}
		}
		
		return Arrays.toString(answer).replaceAll("[^a-zA-Z0-9]", "");
	}

	static String src =
			"2\r\n"
			+ "3\r\n"
			+ "ABC\r\n"
			+ "ABD\r\n"
			+ "XY\r\n"
			+ "3\r\n"
			+ "BAA\r\n"
			+ "BCA\r\n"
			+ "ADA";
}
