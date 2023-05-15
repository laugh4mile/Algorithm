package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_2449_별찍기10 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		char map[][] = new char[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = '*';
			}	
		}
		makeHole(0, 0, N, map);
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				output.append(map[r][c]);
			}	
			output.append("\n");
		}
		output.close();
	}

	private static void makeHole(int nr, int nc, int n, char[][] map) {
		if(n<3) {
			return;
		}
		for(int r=nr+n/3; r<nr+n/3*2; r++) {
			for(int c=nc+n/3; c<nc+n/3*2; c++) {
				map[r][c] = ' ';
			}
		}
		int cnt = 0;
		for(int r=nr; r<nr+n; r+=n/3) {
			for(int c=nc; c<nc+n; c+=n/3) {
				if(++cnt == 5) continue;
				makeHole(r, c, n/3, map);
			}	
		}
	}

	static String src =
			"27";
}
