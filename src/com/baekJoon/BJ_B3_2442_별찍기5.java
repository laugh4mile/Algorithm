package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B3_2442_별찍기5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-i-1; j++) {
				output.append(" ");
			}
			for(int j=0; j<i*2+1; j++) {
				output.append("*");
			}
			output.append("\n");
		}
		output.close();
	}

	static String src =

			"5";
}
