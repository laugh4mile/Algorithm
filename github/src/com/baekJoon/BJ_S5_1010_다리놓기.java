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

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			answer = 0;
			combi(0, 0, N, M);
			System.out.println(answer);
		}
	}
	static int answer;
	private static void combi(int start, int cnt, int N, int M) {
		if(cnt == N) {
			answer++;
			return;
		}
		for(int i=start; i<M; i++) {
			combi(i, cnt+1, N, M);
		}
	}

	static String src =

			"3\r\n" + 
			"2 2\r\n" + 
			"1 5\r\n" + 
			"13 29";
}
