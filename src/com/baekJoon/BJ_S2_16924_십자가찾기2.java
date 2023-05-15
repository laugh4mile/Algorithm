package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_16924_십자가찾기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static char map[][];
	static boolean isChecked[][];
	static List<Cross> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[N][M];
		isChecked = new boolean[N][M];
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
				if(line.charAt(c) == '.') {
					isChecked[r][c] = true;
				}
			}
		}
		if(map[0][0] == '*' || map[0][M-1] == '*' || map[N-1][0] == '*' || map[N-1][M-1] == '*') {
			System.out.println(-1);
		}else {
			for(int r=1; r<N-1; r++) {
				for(int c=1; c<M-1; c++) {
					if(map[r][c] == '*') {
						fillCross(r,c);
					}
				}	
			}
			boolean flag = false;
			outer : for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(!isChecked[r][c]) {
						flag = true;
						break outer;
					}
				}	
			}
			if(flag) {
				System.out.println(-1);
			}else {
				System.out.println(list.size());
				for(Cross x : list) {
					System.out.println(x.r+" "+x.c+" "+x.k);
				}
			}
		}
	}
	private static void fillCross(int r, int c) {
		int size = 1;
		int U=r,R=c,D=r,L=c;
		while(true) {
			U--;
			R++;
			D++;
			L--;
			if(!isIn(U, L) || !isIn(D,R)) return;
			if(map[U][c] != '*' || map[D][c] != '*' || map[r][R] != '*' || map[r][L] != '*') return;
			
			isChecked[r][c] = true;
			isChecked[U][c] = true;
			isChecked[r][R] = true;
			isChecked[D][c] = true;
			isChecked[r][L] = true;
			
			list.add(new Cross(r+1, c+1, size));
			size++;
		}
	}
	static boolean isIn(int r, int c){
		return (r>=0 && r<N && c>=0 && c<M);
	}
	
	static class Cross{
		int r;
		int c;
		int k;
		public Cross(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Cross [r=" + r + ", c=" + c + ", k=" + k + "]";
		}
	}
	static String src =
			"6 8\r\n"
			+ "....*...\r\n"
			+ "...**...\r\n"
			+ "..*****.\r\n"
			+ "...**...\r\n"
			+ "....*...\r\n"
			+ "........";
}
