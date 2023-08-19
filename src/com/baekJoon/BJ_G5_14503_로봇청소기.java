package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14503_로봇청소기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][];
	static boolean isCleaned[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		isCleaned = new boolean[N][M];
		tokens = new StringTokenizer(input.readLine());
		int startR = Integer.parseInt(tokens.nextToken());
		int startC = Integer.parseInt(tokens.nextToken());
		int startD = Integer.parseInt(tokens.nextToken());
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		cleaning(startR,startC,startD);
	}
	private static void cleaning(int startR, int startC, int startD) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startR, startC, startD));
		int cnt = 0;
		outer : while(!queue.isEmpty()) {
			Node front = queue.poll();
//			System.out.println(front);
			if(!isCleaned[front.r][front.c]) {
				isCleaned[front.r][front.c] = true;
				cnt++;
			}
			int nd = front.d;
			for(int d=0; d<4; d++) {
				nd = (nd+3)%4; // 방향 바꾸기~
	
				int nr = front.r + dr[nd]; // 방향 공식 발견함
				int nc = front.c + dc[nd];
				if(isIn(nr, nc) && !isCleaned[nr][nc] && map[nr][nc] == 0) {
					queue.offer(new Node(nr, nc, nd));
					continue outer;
				}
			}
			int reverseD = (nd+2)%4;
			int nr = front.r + dr[reverseD];
			int nc = front.c + dc[reverseD];
			if(isIn(nr, nc) && map[nr][nc] == 0) {
				queue.offer(new Node(nr, nc, nd));
			}
		}
		System.out.println(cnt);
	}
	static class Node{
		int r;
		int c;
		int d;
		public Node(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}
	static int dr[] = {-1,0,1,0}; // 북, 동, 남, 서
	static int dc[] = {0,1,0,-1};
	static boolean isIn(int r, int c) {
		return(r>=0 && c>=0 && r<N && c<M);
	}
	static String src =
			"11 10\r\n"
			+ "7 4 0\r\n"
			+ "1 1 1 1 1 1 1 1 1 1\r\n"
			+ "1 0 0 0 0 0 0 0 0 1\r\n"
			+ "1 0 0 0 1 1 1 1 0 1\r\n"
			+ "1 0 0 1 1 0 0 0 0 1\r\n"
			+ "1 0 1 1 0 0 0 0 0 1\r\n"
			+ "1 0 0 0 0 0 0 0 0 1\r\n"
			+ "1 0 0 0 0 0 0 1 0 1\r\n"
			+ "1 0 0 0 0 0 1 1 0 1\r\n"
			+ "1 0 0 0 0 0 1 1 0 1\r\n"
			+ "1 0 0 0 0 0 0 0 0 1\r\n"
			+ "1 1 1 1 1 1 1 1 1 1";
}
