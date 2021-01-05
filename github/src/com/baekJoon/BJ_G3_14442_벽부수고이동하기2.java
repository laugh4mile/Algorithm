package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_14442_벽부수고이동하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,map[][];
	static boolean isVisited[][][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M][K+1];
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}	
		}
		bfs();
	}

	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, 0, 0));
		isVisited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			if(front.r == N-1 && front.c == M-1) {
				System.out.println(front.t+1);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				int nk = front.k;
				int nt = front.t + 1;
				if(isIn(nr, nc) && !isVisited[nr][nc][nk]&& map[nr][nc] == 0) {
					isVisited[nr][nc][nk] = true;
					queue.offer(new Node(nr, nc, nk, nt));
				}
				if(front.k != K) {
					nk = Math.min(front.k+1, K);
					
					if(isIn(nr, nc) && !isVisited[nr][nc][nk] && map[nr][nc] == 1) {
						isVisited[nr][nc][nk] = true;
						queue.offer(new Node(nr, nc, nk, nt));
					}
				}
			}
		}
		System.out.println(-1);
		return;
		
	}
	static class Node{
		int r;
		int c;
		int k;
		int t;
		public Node(int r, int c, int k, int t) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.t = t;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", k=" + k + ", t=" + t + "]";
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	static String src =
			"6 4 1\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1000\r\n" + 
			"0000\r\n" + 
			"0111\r\n" + 
			"0000";
}
