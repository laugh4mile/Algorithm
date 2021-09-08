package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_1010_다리놓기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int arr[][] = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			output.append(combi(M,N)+"\n");
		}
		output.close();
	}
	private static int combi(int n, int r) {
		if(arr[n][r] > 0) return arr[n][r];
		if(n==r || r==0) return arr[n][r] = 1;
		return arr[n][r] = combi(n-1, r-1) + combi(n-1, r);
	}

	static String src =
			"3\r\n" + 
			"2 2\r\n" + 
			"1 5\r\n" + 
			"13 29";
}
