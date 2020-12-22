package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14500_테트로미노 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, map[][], sum, max, max2;
	static boolean isVisited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				sum += map[r][c];
				isVisited[r][c] = true;
				dfs(r,c,0);
				isVisited[r][c] = false;
				sum -= map[r][c];
				countFuckyou(r,c);
			}	
		}
		System.out.println(Math.max(max, max2));
	}
	private static void countFuckyou(int r, int c) {
		int cross = map[r][c], sum[] = new int[4]; // +, ㅗ,ㅜ,ㅓ,ㅏ
		
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isIn(nr, nc)) {
				cross += map[nr][nc];
			}
		}
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isIn(nr, nc)) {
				if(max2 < cross - map[nr][nc]) {
					max2 = cross - map[nr][nc];
				}
			}else {
				if(max2 < cross) {
					max2 = cross;
				}
			}
		}
		
	}
	private static void dfs(int r, int c, int depth) {
		if(depth == 3) {
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(isIn(nr, nc) && !isVisited[nr][nc]) {
				sum += map[nr][nc];
				isVisited[nr][nc] = true;
				dfs(nr, nc, depth+1);
				isVisited[nr][nc] = false;
				sum -= map[nr][nc];
			}
		}
	}

	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static String src =
			"5 10\r\n" + 
			"1 2 1 2 1 2 1 2 1 1\r\n" + 
			"2 1 2 1 2 1 2 1 2 1\r\n" + 
			"1 2 1 2 1 2 1 2 1 1\r\n" + 
			"2 1 2 1 2 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 10 10 10 10";
}
