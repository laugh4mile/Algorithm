package com.codingtest.bro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_0810_1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static boolean isVisited[][];
	static int max, board[][] = {
//			{3,2,3,2},
//			{2,1,1,2},
//			{1,1,2,1},
//			{4,1,1,1}
			{4,2,3,2},
			{2,1,2,4},
			{1,2,3,1},
			{4,1,4,3}
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		solution();
	}
	public static void solution() {
		isVisited = new boolean[4][4];
		for(int r=0; r<4; r++) {
			for(int c=0; c<4; c++) {
				bfs(r,c);
			}
		}
		if(max == 1) {
			System.out.println(-1);
		}else {
			System.out.println(7);
		}
	}
	private static void bfs(int r, int c) {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				isVisited[i][j] = false;
			}	
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 1));
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(max < front.d) {
				max = front.d;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc] && board[nr][nc] == board[front.r][front.c]) {
					queue.offer(new Node(nr, nc, front.d+1));
					isVisited[nr][nc] = true;
				}
			}
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<4 && c<4);
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
	}
}
