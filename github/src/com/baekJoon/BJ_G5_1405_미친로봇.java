package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1405_미친로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, dir[];
	static boolean isVisited[][];
	static double answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		isVisited = new boolean[30][30];
		dir = new int [4];
		for(int d=0; d<4; d++) {
			dir[d] = Integer.parseInt(tokens.nextToken());
		}
		isVisited[15][15] = true;
		dfs(15,15,0,1);
		System.out.println(answer);
//		System.out.printf("%.9f",answer);
	}

	private static void dfs(int r, int c, int cnt, double probability) {
		if (cnt == N) {
			answer += probability;
			return;
		}
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isIn(nr, nc) && !isVisited[nr][nc]) {
				isVisited[nr][nc] = true;
				dfs(nr,nc,cnt+1,probability*dir[d]/100);
				isVisited[nr][nc] = false;
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<30 && c<30);
	}
	
	static int dr[] = {0,0,1,-1}; // 동서남북
	static int dc[] = {1,-1,0,0};

	static String src =
			"2 25 25 25 25";
}
