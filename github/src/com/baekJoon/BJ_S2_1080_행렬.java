package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1080_행렬 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		char A[][] = new char[N][M];
		char B[][] = new char[N][M];
		
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				A[r][c] = line.charAt(c);
			}
		}
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				B[r][c] = line.charAt(c);
			}
		}
		
		int answer = 0;
		for(int r=0; r<N-2; r++) {
			for(int c=0; c<M-2; c++) {
				if(A[r][c] != B[r][c]) {
					A = flip(A,r,c);
					answer++;
				}
			}	
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(A[r][c] != B[r][c]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
		
	}

	private static char[][] flip(char[][] a, int R, int C) {
		for(int r=R; r<R+3; r++) {
			for(int c=C; c<C+3; c++) {
				if(a[r][c] == '1') {
					a[r][c] = '0';
				}else {
					a[r][c] = '1';
				}
			}	
		}
		return a;
	}

	static String src =
			"18 3\r\n" + 
			"001\r\n" + 
			"100\r\n" + 
			"100\r\n" + 
			"000\r\n" + 
			"011\r\n" + 
			"010\r\n" + 
			"100\r\n" + 
			"100\r\n" + 
			"010\r\n" + 
			"010\r\n" + 
			"010\r\n" + 
			"110\r\n" + 
			"101\r\n" + 
			"101\r\n" + 
			"000\r\n" + 
			"110\r\n" + 
			"000\r\n" + 
			"110\r\n" + 
			"001\r\n" + 
			"100\r\n" + 
			"011\r\n" + 
			"000\r\n" + 
			"100\r\n" + 
			"010\r\n" + 
			"011\r\n" + 
			"100\r\n" + 
			"101\r\n" + 
			"101\r\n" + 
			"010\r\n" + 
			"001\r\n" + 
			"010\r\n" + 
			"010\r\n" + 
			"111\r\n" + 
			"110\r\n" + 
			"111\r\n" + 
			"001";
}
