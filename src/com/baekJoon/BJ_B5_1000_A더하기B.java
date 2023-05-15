package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_B5_1000_A더하기B {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] agrs) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		System.out.println(Integer.parseInt(tokens.nextToken())+Integer.parseInt(tokens.nextToken()));
	}
}
