package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_3085_사탕게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, max=1;
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new char[N][N];
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		
		solve();
		System.out.println(max);
	}

	private static void solve() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				int nr = r+1;
				int nc = c+1;
				
				if(isIn(r, nc)) {
					char temp = map[r][c];
					map[r][c] = map[r][nc];
					map[r][nc] = temp;
					getMaxCandy();
					temp = map[r][nc];
					map[r][nc] = map[r][c];
					map[r][c] = temp;
				}
				
				if(isIn(nr, c)) {
					char temp = map[r][c];
					map[r][c] = map[nr][c];
					map[nr][c] = temp;
					getMaxCandy();
					temp = map[nr][c];
					map[nr][c] = map[r][c];
					map[r][c] = temp;
				}
			}	
		}
	}

	private static void getMaxCandy() {
		char peek = '0';
		for(int r=0; r<N; r++) {
			int cnt = 0;
			for(int c=0; c<N; c++) {
				if(peek == '0') {
					peek = map[r][c];
					cnt = 1;
				}else {
					if(peek == map[r][c]) {
						cnt++;
						if(max < cnt) {
							max = cnt;
						}
					}else {
						cnt = 1;
						peek = map[r][c];
					}
				}
			}
		}
		peek = '0';
		for(int c=0; c<N; c++) {
			int cnt = 0;
			for(int r=0; r<N; r++) {
				if(peek == '0') {
					peek = map[r][c];
					cnt = 1;
				}else {
					if(peek == map[r][c]) {
						cnt++;
						if(max < cnt) {
							max = cnt;
						}
					}else {
						cnt = 1;
						peek = map[r][c];
					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static String src =
			"4\r\n" + 
			"CCCC\r\n" + 
			"YDYD\r\n" + 
			"DYDY\r\n" + 
			"YDYD";
}
