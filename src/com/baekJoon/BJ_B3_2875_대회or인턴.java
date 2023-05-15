package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B3_2875_대회or인턴 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		while(K!=0) {
			if(N/2 >= M) {
				N--;
				K--;
			}else {
				M--;
				K--;
			}
		}

		if(N/2 >= M) {
			System.out.println(M);
		}else {
			System.out.println(N/2);
		}
	}

	static String src =
			"2 5 3";
}
