package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B3_2440_별찍기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append('*');
		}
		for(int i=0; i<N; i++) {
			output.append(sb.substring(i)+"\n");
		}
		output.close();
	}

	static String src =
			"5";
}
