package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_7569_토마토 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int M,N,H, map[][][], max;
	static boolean isVisited[][][];
	static Queue<Node> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][N][M];
		isVisited = new boolean[H][N][M];
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				for(int m=0; m<M; m++) {
					map[h][n][m] = Integer.parseInt(tokens.nextToken());
					if(map[h][n][m] == 1) {
						isVisited[h][n][m] = true;
						queue.offer(new Node(h, n, m));
					}
				}
			}
		}
//		for(int h=0; h<H; h++) {
//			for(int n=0; n<N; n++) {
//				for(int m=0; m<M; m++) {
//					System.out.print(map[h][n][m]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		boolean returnZero = true;
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[h][r][c] != 0) { // 익지 않은 토마토가 하나라도있으면
						returnZero = false;
					}
				}		
			}	
		}
		if(!returnZero) {
			bfs();
			boolean flag = false;
			outer : for(int h=0; h<H; h++) {
				for(int r=0; r<N; r++) {
					for(int c=0; c<M; c++) {
						if(map[h][r][c] == 0) {
							flag = true;
							break outer;
						}
					}		
				}	
			}
			
			if(flag) {
				System.out.println(-1);
			}else {
				System.out.println(max-1);
			}
		}else {
			System.out.println(0);
		}
		
		
	}


	private static void bfs() {
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			for(int i=0; i<2; i++) {
				int nh = front.h + dh[i];
				if(isIn(nh) && !isVisited[nh][front.r][front.c] && map[nh][front.r][front.c] == 0) {
					map[nh][front.r][front.c] = map[front.h][front.r][front.c]+1;
					isVisited[nh][front.r][front.c] = true;
					queue.offer(new Node(nh, front.r, front.c));
				}
			}
			for(int j=0; j<4; j++) {
				int nr = front.r + dr[j];
				int nc = front.c + dc[j];
				
				if(isIn(nr, nc) && !isVisited[front.h][nr][nc] && map[front.h][nr][nc] == 0) {
					map[front.h][nr][nc] = map[front.h][front.r][front.c]+1;
					isVisited[front.h][nr][nc] = true;
					queue.offer(new Node(front.h, nr, nc));
				}
			}
		}
		
		for(int h=0; h<H; h++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(map[h][r][c] > max) { // 익지 않은 토마토가 하나라도있으면
						max = map[h][r][c];
					}
				}		
			}	
		}
		
		
		
	}
	
	static int dh[] = {1,-1};
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	
	static boolean isIn(int h) {
		return (h>=0 && h<H);
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	static class Node{
		int h;
		int r;
		int c;
		public Node(int h, int r, int c) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Node [h=" + h + ", r=" + r + ", c=" + c + "]";
		}
	}
	
	static String src =
			"3 3 2\r\n" + 
			"1 1 0\r\n" + 
			"1 1 0\r\n" + 
			"0 0 0\r\n" + 
			"0 0 0\r\n" + 
			"0 1 1\r\n" + 
			"0 1 1";
}
