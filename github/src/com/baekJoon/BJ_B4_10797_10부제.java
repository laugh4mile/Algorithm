package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B4_10797_10부제 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		int sum = 0;
		while(tokens.hasMoreTokens()) {
			if(Integer.parseInt(tokens.nextToken()) == N) {
				sum++;
			}
		}
		System.out.println(sum);
	}

	static String src =
			"5\r\n" + 
			"1 3 0 7 4";
}
