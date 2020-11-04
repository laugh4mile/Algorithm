package com.swcordingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Q6 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static long N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		long ans = 0;
		for(long i=N-1; i>1; i--) {
			if(N%i == 0) {
				ans = i;
			}
		}
		if(ans == 0) {
			ans = 1;
		}
		System.out.println(ans);
		
	}
	static String src = "9";
//			"4\r\n" +
//			"1\r\n" +
//			"2\r\n" +
//			"3\r\n" +
//			"3";
}
