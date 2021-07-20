package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_20056_마법사상어와파이어볼 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K;
	static List<FireBall> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken()); 
			int c = Integer.parseInt(tokens.nextToken()); 
			int m = Integer.parseInt(tokens.nextToken()); 
			int s = Integer.parseInt(tokens.nextToken()); 
			int d = Integer.parseInt(tokens.nextToken());
			list.add(new FireBall(r, c, m, s, d));
		}
		for(int k=0; k<K; k++) {
			move();
		}
	}
	private static void move() {
		for(int i=0; i<list.size(); i++) {
			FireBall front = list.get(i);
			int nr = (front.r + N + ((front.s % N) * dr[front.d]))%N;
			int nc = (front.c + N + ((front.s % N) * dc[front.d]))%N;
			
		}
	}
	static class FireBall{
		int r;
		int c;
		int m;
		int s;
		int d;
		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		@Override
		public String toString() {
			return "FireBall [r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
	}
	static int dr[] = {-1,-1,0,1,1,1,0,-1}; // 8 방향. 순서 중요함.
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	static String src =
			"4 2 1\r\n"
			+ "1 1 5 2 2\r\n"
			+ "1 4 7 1 6";
}
