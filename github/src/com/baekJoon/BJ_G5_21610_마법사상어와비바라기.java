package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_21610_마법사상어와비바라기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][];
	static List<Cloud> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		list.add(new Cloud(N-2, 0));
		list.add(new Cloud(N-2, 1));
		list.add(new Cloud(N-1, 0));
		list.add(new Cloud(N-1, 1));
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int d = Integer.parseInt(tokens.nextToken())-1; // 0 부터 할거임
			int s = Integer.parseInt(tokens.nextToken());
			move(d,s);
			System.out.println(list);
		}
	}
	
	private static void move(int d, int s) {
		for(int i=0; i<list.size(); i++) {
			list.get(i).r = (N + list.get(i).r + dr[d]*(s%N)) % N;
			list.get(i).c = (N + list.get(i).c + dc[d]*(s%N)) % N;
			map[list.get(i).r][list.get(i).c]++;
			
		}
	}

	static int dr[] = {0,-1,-1,-1,0,1,1,1}; // 8방향. 순서 중요.
	static int dc[] = {-1,-1,0,1,1,1,0,-1};
	
	static boolean isIn (int r, int c){
		return(r>=0 && c>=0 && r<N && c<N);
	}
	
	static class Cloud{
		int r;
		int c;
		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Cloud [r=" + r + ", c=" + c + "]";
		}
	}
	
	static String src =
			"5 4\r\n"
			+ "0 0 1 0 2\r\n"
			+ "2 3 2 1 0\r\n"
			+ "4 3 2 9 0\r\n"
			+ "1 0 2 9 0\r\n"
			+ "8 8 2 1 0\r\n"
			+ "1 3\r\n"
			+ "3 4\r\n"
			+ "8 1\r\n"
			+ "4 8";
}
