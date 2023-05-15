package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_16924_십자가찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
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
			output.append("-1");
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
				output.append("-1");
			}else {
				output.append(list.size() +"\n");
				for(Cross x : list) {
					output.append(x.r+" "+x.c+" "+x.k+"\n");
				}
			}
		}
		output.close();
	}
	private static void fillCross(int r, int c) {
		int size = 1;
		while(true) {
			for(int nr= r-size; nr<=r+size; nr++) {
				if(!isIn(nr,c) || map[nr][c] !='*') return;
			}
			for(int nc=c-size; nc<=c+size; nc++) {
				if(!isIn(r,nc) || map[r][nc] !='*') return;
			}
			for(int nr=r-size; nr<=r+size; nr++) {
				isChecked[nr][c] = true;
			}
			for(int nc=c-size; nc<=c+size; nc++) {
				isChecked[r][nc] = true;
			}
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
			"5 5\r\n"
			+ ".*...\r\n"
			+ "****.\r\n"
			+ ".****\r\n"
			+ "..**.\r\n"
			+ ".....";
}
