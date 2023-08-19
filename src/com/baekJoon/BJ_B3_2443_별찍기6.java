package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B3_2443_별찍기6 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				output.append(" ");
			}
			for(int j=i; j<N*2-1-i; j++) {
				output.append("*");
			}
			output.append("\n");
		}
		output.close();
	}

	static String src =

			"5";
}
