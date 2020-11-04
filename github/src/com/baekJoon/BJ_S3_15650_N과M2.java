package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_15650_N과M2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N,M, result[];
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		result = new int[M];
		
		combi(0,0);
	}
	private static void combi(int start, int cnt) {
		if(cnt == M) {
			for(int i=0; i<result.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<N; i++) {
			result[cnt] = i+1;
			combi(i+1, cnt+1);
		}
	}
	static String src = "4 2";

}
