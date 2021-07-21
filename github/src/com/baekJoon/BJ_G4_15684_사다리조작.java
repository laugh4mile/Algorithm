package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_15684_사다리조작 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,M,ladder[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		ladder = new int[R][C];
		int cnt = 1;
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			ladder[r][c] = cnt;
			ladder[r][c+1] = cnt++;
		}
		for(int x[] : ladder) {
			System.out.println(Arrays.toString(x));
		}
		for(int c=0; c<C; c++) {
			
		}
	}

	static String src =
			"5 5 6\r\n"
			+ "1 1\r\n"
			+ "3 2\r\n"
			+ "2 3\r\n"
			+ "5 1\r\n"
			+ "5 4";
}
