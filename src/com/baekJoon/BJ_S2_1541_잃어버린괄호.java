package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1541_잃어버린괄호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine(),"-");
		String start = tokens.nextToken();
		StringTokenizer tokens3 = new StringTokenizer(start, "+");
		int answer = 0;
		while(tokens3.hasMoreTokens()) {
			answer += Integer.parseInt(tokens3.nextToken());
		}
		while(tokens.hasMoreTokens()) {
			StringTokenizer tokens2 = new StringTokenizer(tokens.nextToken(), "+");
			int temp = 0;
			while(tokens2.hasMoreTokens()) {
				temp += Integer.parseInt(tokens2.nextToken());
			}
			answer -= temp;
		}
		System.out.println(answer);
	}

	static String src =
			"55-50+40";
}
