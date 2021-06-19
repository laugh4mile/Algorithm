package com.codingtest.thgc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Q2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		str = input.readLine();
		int N = str.length();
//		System.out.println(N);
		System.out.println(str.charAt(N-1)+ " " + str.charAt(N-2));
		
	}
	static String src = "APPLE";
//			"4\r\n" +
//			"1\r\n" +
//			"2\r\n" +
//			"3\r\n" +
//			"3";
}
