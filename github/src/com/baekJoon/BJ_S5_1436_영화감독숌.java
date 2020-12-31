package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_1436_영화감독숌 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		int num = 665;
		int index = 0;
		while(true) {
			if(Integer.toString(num).contains("666")) {
				index++;
			}
			if(index == N) {
				break;
			}
			num++;
		}
		System.out.println(num);
	}

	static String src =
			"8";
}
