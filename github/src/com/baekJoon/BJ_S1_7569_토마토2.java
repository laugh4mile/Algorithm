package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_7569_토마토2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int M,N,H,map[][][], nonRipen, time;
	static boolean isVisited[][][];
	static Queue<Tomato> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][N][M];
		isVisited = new boolean[H][N][M];
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<M; c++) {
					map[h][r][c] = Integer.parseInt(tokens.nextToken());
					if(map[h][r][c] == 0) {
						nonRipen++;
					}else if(map[h][r][c] == 1) {
						isVisited[h][r][c] = true;
						queue.offer(new Tomato(h, r, c, 0));
					}
				}	
			}	
		}
		if(nonRipen == 0) {
			System.out.println(0);
		}else {
			bfs();
			if(nonRipen == 0) {
				System.out.println(time);
			}else {
				System.out.println(-1);
			}
		}
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			Tomato front = queue.poll();
			if(time < front.time) {
				time = front.time;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(front.h, nr, nc) && !isVisited[front.h][nr][nc] && map[front.h][nr][nc] == 0) {
					isVisited[front.h][nr][nc] = true;
					queue.offer(new Tomato(front.h, nr, nc, front.time+1));
					nonRipen--;
				}
			}
			for(int d=0; d<2; d++) {
				int nh = front.h+dh[d];
				if(isIn(nh, front.r, front.c) && !isVisited[nh][front.r][front.c] && map[nh][front.r][front.c] == 0) {
					isVisited[nh][front.r][front.c] = true;
					queue.offer(new Tomato(nh, front.r, front.c, front.time+1));
					nonRipen--;
				}
			}
		}
	}
	static class Tomato{
		int h;
		int r;
		int c;
		int time;
		public Tomato(int h, int r, int c, int time) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Tomato [h=" + h + ", r=" + r + ", c=" + c + ", time=" + time + "]";
		}
	}
	
	static int dh[] = {1,-1};
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	
	static boolean isIn(int h, int r, int c) {
		return(h>=0 && r>=0 && c>=0 && h<H && r<N && c<M);
	}
	static String src =
			"4 3 2\r\n"
			+ "1 1 1 1\r\n"
			+ "1 1 1 1\r\n"
			+ "1 1 1 1\r\n"
			+ "1 1 1 1\r\n"
			+ "-1 -1 -1 -1\r\n"
			+ "1 1 1 -1";
}
