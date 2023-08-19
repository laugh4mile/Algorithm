package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class _ArrayTest {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,P, map[][], temp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		P = (int)Math.pow(2, N);
		map = new int[P][P];
		temp = new int[P][P];
		for(int r=0; r<P; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<P; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		printMap();
//		spinRight(); // 오른쪽으로 90도 회전
//		printTemp(); 
		
		int t = 1;
		int term = (int) Math.pow(2, t);
//		int newN = (int) Math.pow(2, term);
		temp = new int[term][term];
		for(int r=0; r<P; r=r+term) { // 좌표와 term을 알면 돌릴 수 있지 않을까?
			for(int c=0; c<P; c=c+term) {
//				spinRight(r,c,term);
				spinLeft(r, c, term);
			}	
		}
		printMap();
	}
	
	private static void spinLeft(int curR, int curC, int term) {
		temp = new int[P][P];
		for(int j=0;j<term;j++)
			for(int i=0;i<term;i++)
				temp[i][j]=map[curR+term-1-j][curC+i];
//				temp[i][j]=map[curR+j][curC+term-1+i];
		for(int i=0;i<term;i++)
			for(int j=0;j<term;j++)
				map[curR+i][curC+j]=temp[i][j];
	}

	private static void spinRight(int curR, int curC, int term) {
		temp = new int[P][P];
		for(int i=0;i<term;i++)
	        for(int j=0;j<term;j++)
	            temp[i][j]=map[curR+term-1-j][curC+i];
	    for(int i=0;i<term;i++)
	        for(int j=0;j<term;j++)
	            map[curR+i][curC+j]=temp[i][j];
	}

	private static void spinRight2(int curR, int curC, int term) {
		System.out.println(curR +" "+curC+" "+term);
		int tr = 0, tc;
		for(int r=curR; r<curR+term; r++) {
			tc = 0;
			for(int c=curC; c<curC+term; c++) {
				temp[tr][tc] = map[r][c];
				tc++;
			}
			tr++;
		}
		
		tr = 0;
		for(int r=curR; r<curR+term; r++) {
			tc = 0;
			for(int c=curC; c<curC+term; c++) {
				map[r][c] = temp[term-1-tc][tr];
				tc++;
			}
			tr++;
		}
		printTemp();
	}

	private static void spinRight() {
		for(int r=0; r<P; r++) {
			for(int c=0; c<P; c++) {
				temp[r][c] = map[P-1-c][r];
			}	
		}
	}


	private static void printMap() {
		System.out.println("원본");
		for(int r=0; r<P; r++) {
			for(int c=0; c<P; c++) {
				System.out.printf("%3d",map[r][c]);
			}	
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	private static void printTemp() {
		for(int r=0; r<temp.length; r++) {
			for(int c=0; c<temp[0].length; c++) {
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
