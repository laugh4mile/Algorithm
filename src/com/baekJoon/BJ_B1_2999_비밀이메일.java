package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_2999_비밀이메일 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int N = str.length();
		int sqrt = (int) Math.sqrt(N);
		int R = 0, C = 0;
		for(int i=1; i<=sqrt; i++) {
			if(N%i==0) {
				R = i;
				C = N/i;
			}
		}
		int cnt = 0;
		char map[][] = new char[R][C];
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				map[r][c] = str.charAt(cnt++);
			}	
		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}	
		}
	}
	static String src =
			"boudonuimilcbsai";
}