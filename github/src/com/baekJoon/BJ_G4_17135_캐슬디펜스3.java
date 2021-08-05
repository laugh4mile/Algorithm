package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,D,map[][],temp[][], maxKill;
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		for(int i=0; i<M-2; i++) {
			for(int j=i+1; j<M-1; j++) {
				for(int k=j+1; k<M; k++) {
					defence(i, j, k);
				}	
			}	
		}
		System.out.println(maxKill);
	}
	
	private static void defence(int i, int j, int k) {
		int kill = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				temp[r][c] = map[r][c];
			}	
		}
		for(int t = 0; t<N; t++) {
			bfs(i);
			bfs(j);
			bfs(k);
			kill = killAndMove(kill);
		}
		if(maxKill < kill) {
			maxKill = kill;
		}
	}

	private static int killAndMove(int kill) {
		for(int r=N-1; r>=0; r--) { // 앞으로 한칸씩 전진하므로 뒤에서부터 해야함
			for(int c=0; c<M; c++) {
				if(temp[r][c] == 3) {
					temp[r][c] = 0;
					kill++;
				}else if(temp[r][c] == 1) {
					temp[r][c] = 0;
					if(isIn(r+1, c)) {
						temp[r+1][c] = 1;
					}
				}
			}
		}
		return kill;
	}

	private static void bfs(int start) {
		isVisited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(N, start, 0));
//		isVisited(N,start) // 이거하면 범위 초과 에러날듯?
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(isIn(front.r, front.c) && temp[front.r][front.c] != 0) {
				temp[front.r][front.c] = 3;
				break;
			}
			if(front.d < D) {
				for(int d=0; d<3; d++) {
					int nr = front.r + dr[d];
					int nc = front.c + dc[d];
					if(isIn(nr, nc) && !isVisited[nr][nc]) { // map[nr][nc] 가 뭔진 상관없을듯?
						queue.offer(new Node(nr, nc, front.d+1));
						isVisited[nr][nc] = true;
					}
				}
			}
		}
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
	
	static int dr[] = {0,-1,0}; // 왼, 위, 오
	static int dc[] = {-1,0,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static String src =
			"6 5 2\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 1 0 1 0\r\n"
			+ "1 1 0 0 0\r\n"
			+ "0 0 0 1 1\r\n"
			+ "1 1 0 1 1\r\n"
			+ "0 0 1 0 0";
}
