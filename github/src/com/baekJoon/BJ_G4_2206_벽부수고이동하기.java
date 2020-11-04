package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2206_벽부수고이동하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],check[][],cnt, min = Integer.MAX_VALUE;
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		isVisited = new boolean[N][M];
		for(int n=0; n<N; n++) {
			String line = input.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m) - '0';
				if(map[n][m] == 1) {
					cnt++;
				}
			}	
		}
		
//		for(int []x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1) {
					map[r][c] = 0;
					bfs(0,0);
					map[r][c] = 1;
				}
			}	
		}
		if(!isVisited[N-1][M-1]) {
			System.out.println(-1);
		}else {
			System.out.println(min+1);
		}
//		for(boolean []x : isVisited) {
//			System.out.println(Arrays.toString(x));
//		}
		
	}
	private static void bfs(int i, int j) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				isVisited[r][c] = false;
			}	
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(i, j));
		isVisited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(front.x == N-1 && front.y == M-1) {
				if(check[N-1][M-1] < min ) {
					min = check[N-1][M-1];
				}
			}
			
			for(int d=0; d<4; d++) {
				int nr = front.x+dx[d];
				int nc = front.y+dy[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc]==0) {
					queue.offer(new Node(nr, nc));
					check[nr][nc] = check[front.x][front.y]+1;
					isVisited[nr][nc] = true;
				}
			}
		}
		
	}
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static String src = "6 4\r\n" + 
			"0100\r\n" + 
			"1110\r\n" + 
			"1000\r\n" + 
			"0000\r\n" + 
			"0111\r\n" + 
			"0000";

}
