package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_10835_카드게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int A[] = new int [N];
		int B[] = new int [N];
		tokens = new StringTokenizer(input.readLine());
		int max = 0;
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(tokens.nextToken());
			A[i] = a;
			if(max < a) {
				max = a;
			}
		}
		tokens = new StringTokenizer(input.readLine());
		int answer = 0;
		for(int i=0; i<N; i++) {
			int b = Integer.parseInt(tokens.nextToken());
			B[i] = b;
			if(max > b) answer += b;
		}
		System.out.println(answer);
	}

	static String src =
			"4\r\n" + 
			"1 2 3 4\r\n" + 
			"4 1 2 3";
}
