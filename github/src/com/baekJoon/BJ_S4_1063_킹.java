package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_1063_킹 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int map[][] = new int[8][8];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		String king = tokens.nextToken();
		String stone = tokens.nextToken();
		int N = Integer.parseInt(tokens.nextToken());
		
		int kc = king.charAt(0)-'A';
		int kr = 7 - (king.charAt(1)-'1');
		
		int sc = stone.charAt(0)-'A';
		int sr = 7 - (stone.charAt(1)-'1');
		map[kr][kc] = 1;
		map[sr][sc] = 2;
		
		for(int i=0; i<N; i++) {
			int d = getDirection(input.readLine());
			int nkr = kr + dr[d]; 
			int nkc = kc + dc[d];
			if(isIn(nkr, nkc)) {
				if(map[nkr][nkc] == 0) {
					map[kr][kc] = 0;
					kr = nkr;
					kc = nkc;
					map[kr][kc] = 1;
				}else { // 돌의 위치로 이동할 경우
					int nsr = sr + dr[d];
					int nsc = sc + dc[d];
					if(isIn(nsr, nsc)) {
						map[kr][kc] = 0;
						kr = nkr;
						kc = nkc;
						map[kr][kc] = 1;
						
						sr = nsr;
						sc = nsc;
						map[sr][sc] = 2;
					}
				}
			}
		}
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println(kr + " " +kc);
//		System.out.println(sr + " " +sc);
		char answerKc = (char) (kc + 'A');
		int answerKr = 8-kr;
		char answerSc = (char) (sc + 'A');
		int answerSr = 8-sr;
		System.out.println(answerKc+""+answerKr);
		System.out.println(answerSc+""+answerSr);
		
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<8 && c<8);
	}
	static int dr[] = {0,-1,-1,-1,0,1,1,1};
	static int dc[] = {-1,-1,0,1,1,1,0,-1};
	
	private static int getDirection(String comm) {
		int dir = -1;
		switch (comm) {
		case "L":
			dir = 0;
			break;
		case "LT":
			dir = 1;
			break;
		case "T":
			dir = 2;			
			break;
		case "RT":
			dir = 3;			
			break;
		case "R":
			dir = 4;			
			break;
		case "RB":
			dir = 5;			
			break;
		case "B":
			dir = 6;			
			break;
		case "LB":
			dir = 7;			
			break;
		}
		
		return dir;
	}

	static String src =
			"A3 A2 5\r\n" + 
			"B\r\n" + 
			"L\r\n" + 
			"LB\r\n" + 
			"RB\r\n" + 
			"LT";
}
