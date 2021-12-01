package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_2573_빙산_2 {
	static BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
	static StringTokenizer tokens;
	static int N,M,map[][];
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		for(int r=0; r<N; r++){
			for(int c=0; c<M; c++){

			}
		}
	}

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node{" +
					"r=" + r +
					", c=" + c +
					'}';
		}
	}

	static boolean isIn(int r, int c){
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};

	static String src ="5 7\r\n" +
			"0 0 0 0 0 0 0\r\n" + 
			"0 2 4 5 3 0 0\r\n" + 
			"0 3 0 2 5 2 0\r\n" + 
			"0 7 6 2 4 0 0\r\n" + 
			"0 0 0 0 0 0 0";
}