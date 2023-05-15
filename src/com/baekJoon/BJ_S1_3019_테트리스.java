package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_3019_테트리스 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int C, P, map[], answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		P = Integer.parseInt(tokens.nextToken());
		map = new int[C];
		tokens = new StringTokenizer(input.readLine());
		
		for(int c=0; c<C; c++) {
			map[c] = Integer.parseInt(tokens.nextToken());
		}
		solve();
		System.out.println(answer);
	}

	private static void solve() {
		switch (P) {
		case 1:
			answer += C;
			for(int c=0; c<C-3; c++) {
				if(map[c]== map[c+1] && map[c]== map[c+2] && map[c]== map[c+3]) {
					answer++;
				}
			}
			break;
		case 2:
			for(int c=0; c<C-1; c++) {
				if(map[c]== map[c+1]) {
					answer++;
				}
			}
			break;
		case 3:
			for(int c=0; c<C-2; c++) {
				if(map[c] == map[c+1] && map[c+2] == map[c]+1) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c] == map[c+1]+1) {
					answer++;
				}
			}
			break;
		case 4:
			for(int c=0; c<C-2; c++) {
				if(map[c] == map[c+1]+1 && map[c] == map[c+2]+1) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c] == map[c+1]-1) {
					answer++;
				}
			}
			break;
		case 5:
			for(int c=0; c<C-2; c++) {
				if(map[c]== map[c+1] && map[c]== map[c+2]) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c] == map[c+1]+1) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c] == map[c+1]-1) {
					answer++;
				}
			}
			for(int c=0; c<C-2; c++) {
				if(map[c]== map[c+1]+1 && map[c]== map[c+2]) {
					answer++;
				}
			}
			break;
		case 6:
			for(int c=0; c<C-2; c++) {
				if(map[c]== map[c+1] && map[c]== map[c+2]) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c]== map[c+1]) {
					answer++;
				}
			}
			for(int c=0; c<C-2; c++) {
				if(map[c]== map[c+1]-1 && map[c]== map[c+2]-1) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c]== map[c+1]+2) {
					answer++;
				}
			}
			break;
		case 7:
			for(int c=0; c<C-2; c++) {
				if(map[c]== map[c+1] && map[c]== map[c+2]) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c]== map[c+1]) {
					answer++;
				}
			}
			for(int c=0; c<C-2; c++) {
				if(map[c]== map[c+1] && map[c]== map[c+2]+1) {
					answer++;
				}
			}
			for(int c=0; c<C-1; c++) {
				if(map[c]== map[c+1]-2) {
					answer++;
				}
			}
			break;
		}
	}

	static String src =
			"6 6\r\n" + 
			"3 1 1 1 1 1";
}
