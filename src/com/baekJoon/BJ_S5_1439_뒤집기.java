package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_1439_뒤집기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String S = input.readLine();
		String ones = S.replace('0',' ');
		String zeros = S.replace('1',' ');
		StringTokenizer tokens = new StringTokenizer(ones);
		StringTokenizer tokens2 = new StringTokenizer(zeros);
		
		System.out.println(Math.min(tokens.countTokens(), tokens2.countTokens()));
	}

	static String src =
			"11101101";
}
