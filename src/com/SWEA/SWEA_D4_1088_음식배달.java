package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_D4_1088_음식배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,map[][];
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}	
			} // 입력 끝
			
		}
	}
	static String src =
			"3\r\n" + 
			"5\r\n" + 
			"0 0 0 0 0\r\n" + 
			"0 1 1 1 0\r\n" + 
			"0 1 10 1 0\r\n" + 
			"0 1 1 1 0  \r\n" + 
			"0 0 0 0 0\r\n" + 
			"8\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"0 1 10 1 0 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 1 0\r\n" + 
			"0 0 0 0 1 10 1 0\r\n" + 
			"0 0 0 0 1 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"8\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"0 1 20 1 0 0 0 0\r\n" + 
			"0 1 1 1 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 1 0\r\n" + 
			"0 0 0 0 1 30 1 0\r\n" + 
			"0 0 0 0 1 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0";
}
