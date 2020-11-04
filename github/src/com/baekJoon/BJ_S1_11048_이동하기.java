package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_11048_이동하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, map[][], result[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
			}	
		}
	}
	static String src = 
			"3 4\r\n" + 
			"1 2 3 4\r\n" + 
			"0 0 0 5\r\n" + 
			"9 8 7 6";
}
