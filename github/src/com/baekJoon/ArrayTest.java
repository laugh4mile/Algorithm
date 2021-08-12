package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayTest {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], temp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		N = (int)Math.pow(2, N);
		map = new int[N][N];
		temp = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		
		printMap();
		
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				temp[r][c] = map[c][r];
			}	
		}		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				temp[r][c] = map[c][r];
			}	
		}		
		
		printTemp();
	}
	
	private static void printMap() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.printf("%3d",map[r][c]);
			}	
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	private static void printTemp() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.printf("%3d",temp[r][c]);
			}	
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	static String src =
			"3 1\r\n"
			+ "1 2 3 4 5 6 7 8\r\n"
			+ "9 10 11 12 13 14 15 16\r\n"
			+ "17 18 19 20 21 22 23 24\r\n"
			+ "25 26 27 28 29 30 31 32\r\n"
			+ "33 34 35 36 37 38 39 40\r\n"
			+ "41 42 43 44 45 46 47 48\r\n"
			+ "49 50 51 52 53 54 55 56\r\n"
			+ "57 58 59 60 61 62 63 64\r\n"
			+ "1";
}
