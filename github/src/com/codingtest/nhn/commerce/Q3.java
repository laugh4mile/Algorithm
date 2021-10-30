package com.codingtest.nhn.commerce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int[][] map;
	static int N, M, K, max, result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][K];
		result = new int[N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		combi(0,0);
		System.out.println(max);
	}
	

	private static void combi(int cnt, int sum) {
		if(sum > K || cnt > N) return;
		if(cnt == N) {
			if(sum == K) {
				getMax(result);
			}
			return;
		}
		for(int i=0; i<=K; i++) {
			if(i>M) return;
			result[cnt] = i; 
			combi(cnt+1, sum+i);
		}
	}


	private static void getMax(int[] result) {
		int sum = 0;
		for(int i=0; i<N; i++) {
			if(result[i] == 0) continue;
			sum += map[i][M-result[i]];
		}
		max = Math.max(max, sum);
	}


	static String src =
			"10 5 10\r\n" + 
			"38 90 74 49 82 \r\n" + 
			"41 99 61 72 83 \r\n" + 
			"96 43 48 16 48 \r\n" + 
			"34 96 93 27 75 \r\n" + 
			"66 25 3 27 27 \r\n" + 
			"93 12 1 42 66 \r\n" + 
			"23 32 23 47 32 \r\n" + 
			"7 41 8 39 47 \r\n" + 
			"82 11 64 56 34 \r\n" + 
			"76 43 22 97 76 ";
}
