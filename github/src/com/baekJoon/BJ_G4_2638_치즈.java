package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2638_치즈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],check[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		check = new int[N][M];
		// 새로 생성, 0으로 초기화 둘중 누가 빠른지 해보자
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		int t=0;
		while(remainIce()) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					check[r][c] = 0;
				}	
			}
			bfs(0,0);
			melt();
			t++;
		}
		System.out.println(t);
	}

	private static void melt() {
		int temp[][] = map.clone();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(temp[r][c] == 1 ) {
					int sum = 0;
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						sum += check[nr][nc];
					}
					if(sum>=2) {
						map[r][c] = 0;
					}
				}
			}	
		}
	}

	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		check[r][c] = 1;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && check[nr][nc] != 1 && map[nr][nc] == 0) {
					check[nr][nc] = 1;
					queue.offer(new Node(nr, nc));
				}
			}
			
		}
	}

	private static boolean remainIce() {
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1) {
					return true;
				}
			}	
		}
		return false;
	}
	
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static String src =
			"8 9\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 1 0 0 0 0\r\n" + 
			"0 0 0 1 1 0 1 1 0\r\n" + 
			"0 0 1 1 1 1 1 1 0\r\n" + 
			"0 0 1 1 1 1 1 0 0\r\n" + 
			"0 0 1 1 0 1 1 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0";
}
