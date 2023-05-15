package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_2448_별찍기11 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		char map[][] = new char[N][2*N-1];
		int cnt;
		for(int r=0; r<N; r++) {
			cnt = N-1-r;
			for(int c=cnt; c<cnt+4*r+1; c++) {
				map[r][c] = '*';
				cnt--;
			}
		}
		makeHole(0,0,N,map);
		for(int r=0; r<N; r++) {
			for(int c=0; c<2*N-1; c++) {
				if(map[r][c] == '*') {
					output.append(map[r][c]);
				}else {
					output.append(" ");
				}
			}
			output.append("\n");
		}
		output.close();
	}


	private static void makeHole(int nr, int nc, int n, char[][] map) {
		if(n==3) {
			map[nr+1][nc+2] = ' ';
			return;
		}
		
		int cnt = 0;
		for(int r=nr+n/2; r<nr+n; r++) {
			for(int c=nc+n/2+cnt; c<nc+n/2*3-1-cnt; c++) {
				map[r][c] = ' ';
			}	
			cnt++;
		}
		makeHole(nr, nc+n/2, n/2, map);
		makeHole(nr+n/2, nc, n/2, map);
		makeHole(nr+n/2, nc+n, n/2, map);
		
	}


	static String src =
			"3";
}
