package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14502_연구소 {
	static BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
	static StringTokenizer tokens;
	static int N,M, map[][], copy[][], copy2[][], cn,max;
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		copy = new int[N][M];
		copy2 = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				copy[n][m] = map[n][m];
				copy2[n][m] = map[n][m];
			}
		}
		combi(0,0);
		System.out.println(max);
	}
	
	private static void combi(int cnt, int start) { // 64c3인데 시간초과 안나나?
		if(cnt == 3) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(map[n][m] == 2) {
						bfs(n, m);
						
					}
				}
			}
			boolean exception = false;
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(copy[n][m] != copy2[n][m]) {
						exception = true;
					}
				}
			}
			cn = 0;
			if(!exception) {
				countSafe(map);
			}else {
				countSafe(copy);
			}
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					copy[n][m] = map[n][m];
				}
			}
			return;
		}
		for(int i=start; i<N*M; i++) {
			int nr = i/M;
			int nc = i%M;
			
			if(map[nr][nc] == 0) {
				map[nr][nc] = 1;
				combi(cnt+1, i+1);
				map[nr][nc] = 0;
			}
		}
	}
	
	static void bfs(int r, int c) {
		for(int i =0; i<N; i++) {
			for(int j=0; j<M; j++) {
				isVisited[i][j] = false;
			}
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = front.row + dx[i];
				int nc = front.col + dy[i];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
		}
	}
	
	private static void countSafe(int[][] arr) {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(arr[n][m] == 0) {
					cn++;
				}
			}
		}
		if(cn > max) {
			max = cn;
		}
	}

	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static class Node{
		int row;
		int col;
		
		public Node(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static String src = 
			"7 4\r\n" + 
			"0 2 2 0\r\n" + 
			"0 1 0 0\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 0 0\r\n" + 
			"0 0 0 0";
}


