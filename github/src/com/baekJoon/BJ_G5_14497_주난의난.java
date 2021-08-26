package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14497_주난의난 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		char map [][] = new char[N][M];
		tokens = new StringTokenizer(input.readLine());
		int startR = Integer.parseInt(tokens.nextToken());
		int startC = Integer.parseInt(tokens.nextToken());
		int endR = Integer.parseInt(tokens.nextToken());
		int endC = Integer.parseInt(tokens.nextToken());
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		
		for(char x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		
		
	}

	static String src =
			"5 7\r\n" + 
			"3 4 1 2\r\n" + 
			"1#10111\r\n" + 
			"1101001\r\n" + 
			"001*111\r\n" + 
			"1101111\r\n" + 
			"0011001";
}
