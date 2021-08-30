package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_2839_설탕배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int n = N;
		int answer = 0;
		while(n>0) {
			if(n%5 == 0) {
				answer++;
				n -= 5;
			}else if(n%3 == 0) {
				answer++;
				n -= 3;
			}else if(n>5) {
				n -= 5;
				answer++;
			}else {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}

	static String src =
			"8";
}
