package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, N, M, R, C, L, map[][];
	static boolean isVisited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T =Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			L = Integer.parseInt(tokens.nextToken());
			
			map = new int[N][M];
			isVisited = new boolean[N][M];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<M; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
//			for(int x[] : map) {
//				System.out.println(Arrays.toString(x));
//			}
			
			int answer = bfs(R,C);
			
			System.out.println("#"+t+" "+answer);
		}
		
	}
	
	private static int bfs(int r, int c) {
		int answer = 1;
		int hours = 0;
		isVisited[r][c] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, map[r][c]));
		
		while(!queue.isEmpty()) {
			if(hours == L-1) {
				break;
			}
			
			int size = queue.size();
			
			while(size-- > 0) {
				Node front = queue.poll();
				
				int dirs[] = tunnel[map[front.r][front.c]];
				
				for(int d=0; d<dirs.length; d++) {
					if(dirs[d] == 0) continue;
					
					int nr = front.r + dr[d];
					int nc = front.c + dc[d];
					
					if(!isIn(nr, nc)) continue;
					if(isVisited[nr][nc]) continue;
					
					if(tunnel[map[nr][nc]][(d+2) % 4] == 1) {
						isVisited[nr][nc] = true;
						queue.offer(new Node(nr, nc, map[nr][nc]));
						answer++;
					}
				}
			}
			hours++;
		}
		return answer;
	}

	static class Node{
		int r;
		int c;
		int value;
		public Node(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}


		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", value=" + value + "]";
		}
		
	}
	static int tunnel[][] =  {	// 터널 종류 // 상우하좌
			{0, 0, 0, 0},	// 아
			{1, 1, 1, 1},	// 모든 방향 가능
			{1, 0, 1, 0},	
			{0, 1, 0, 1},	
			{1, 1, 0, 0},	
			{0, 1, 1, 0},	
			{0, 0, 1, 1},	
			{1, 0, 0, 1},	
	};
	
	static int dr[] = {-1,0,1,0}; // 상우하좌
	static int dc[] = {0,1,0,-1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static String src = 
			"5\r\n" + 
			"5 6 2 1 3\r\n" + 
			"0 0 5 3 6 0\r\n" + 
			"0 0 2 0 2 0\r\n" + 
			"3 3 1 3 7 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"5 6 2 2 6\r\n" + 
			"3 0 0 0 0 3\r\n" + 
			"2 0 0 0 0 6\r\n" + 
			"1 3 1 1 3 1\r\n" + 
			"2 0 2 0 0 2\r\n" + 
			"0 0 4 3 1 1\r\n" + 
			"10 10 4 3 9\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 7 5 0 5 0 0 0\r\n" + 
			"0 0 3 2 2 6 0 0 0 0\r\n" + 
			"0 4 7 2 2 2 7 0 0 4\r\n" + 
			"0 3 0 1 1 2 2 0 0 5\r\n" + 
			"0 5 6 1 1 1 1 6 2 5\r\n" + 
			"7 4 1 2 0 0 4 6 0 0\r\n" + 
			"5 3 1 7 0 2 2 6 5 7\r\n" + 
			"7 3 2 1 1 7 1 0 2 7\r\n" + 
			"3 4 0 0 4 0 5 1 0 1\r\n" + 
			"20 20 13 11 13\r\n" + 
			"0 0 0 1 4 4 4 0 0 0 0 0 0 0 0 1 2 3 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 4 2 7 7 2 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 6 2 4 4 2 0 4 7 0 6 0\r\n" + 
			"0 0 0 7 5 5 3 0 0 7 5 0 5 6 4 2 6 3 1 5\r\n" + 
			"0 0 0 1 2 6 3 3 7 0 3 6 2 4 5 6 7 7 5 7\r\n" + 
			"0 0 0 3 7 6 1 5 3 3 4 5 7 6 0 4 3 3 1 1\r\n" + 
			"0 1 2 1 5 6 1 6 1 6 5 1 6 0 0 3 4 1 7 6\r\n" + 
			"0 2 3 2 2 7 3 0 0 3 2 5 2 1 0 6 5 1 6 5\r\n" + 
			"0 2 5 7 0 7 1 3 3 4 1 3 3 0 2 3 3 2 4 1\r\n" + 
			"4 0 0 7 2 4 2 2 1 3 1 6 5 5 6 2 5 1 1 6\r\n" + 
			"5 6 4 0 3 6 5 2 2 6 1 2 0 1 7 5 7 2 2 2\r\n" + 
			"1 6 3 1 4 4 1 0 3 0 4 2 7 2 0 2 3 6 2 5\r\n" + 
			"1 5 7 2 1 1 4 4 2 1 0 2 7 1 6 2 6 6 2 2\r\n" + 
			"3 7 0 6 5 0 4 0 6 6 7 1 3 1 1 1 5 1 6 6\r\n" + 
			"0 4 0 1 6 2 1 0 7 0 4 2 5 2 7 0 2 7 1 6\r\n" + 
			"0 7 3 0 1 7 6 2 0 0 4 2 4 1 3 3 7 0 1 3\r\n" + 
			"0 1 1 4 3 7 4 5 2 2 4 7 4 7 7 4 6 0 1 6\r\n" + 
			"0 5 2 2 1 4 6 3 7 0 6 3 5 0 0 6 4 4 2 1\r\n" + 
			"0 1 2 4 5 6 0 2 0 0 5 6 2 4 6 4 7 6 3 7\r\n" + 
			"7 7 4 2 3 0 0 4 0 0 7 2 7 5 6 1 4 5 5 4\r\n" + 
			"50 50 20 12 18\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 4 5 0 0 0 0 0 4 2 0 5 2 1 5 3 3 0 0 4 0 5 1 7 2 6 0 7 0 0 0 2 0 0 0 0 0 0 0\r\n" + 
			"6 7 0 0 0 0 0 0 0 0 0 0 4 5 5 3 6 3 0 2 3 3 0 0 5 6 1 5 3 4 7 6 2 2 1 1 6 5 6 4 6 2 0 0 0 0 2 3 1 0\r\n" + 
			"0 2 6 5 7 6 0 0 0 0 0 0 6 2 0 5 6 2 0 4 1 5 0 0 2 0 7 7 0 6 0 6 2 2 4 1 2 2 1 6 6 6 0 2 2 5 0 6 5 0\r\n" + 
			"0 0 0 4 7 2 7 3 7 0 0 0 0 6 7 6 5 1 1 1 2 2 1 3 1 2 7 6 1 2 1 2 4 1 6 1 1 7 3 1 6 6 6 1 1 1 7 0 0 0\r\n" + 
			"0 0 0 5 4 0 6 3 3 7 0 0 0 6 4 3 2 5 3 1 6 1 0 4 1 0 5 7 6 3 1 1 3 6 1 1 6 3 6 7 3 3 6 5 0 7 2 2 4 6\r\n" + 
			"0 6 0 7 6 0 7 4 0 5 3 0 4 3 2 0 5 7 3 0 1 3 6 7 7 5 1 7 5 2 0 5 3 1 3 7 1 1 1 5 2 5 1 3 6 7 7 6 4 3\r\n" + 
			"5 2 0 2 6 5 0 5 6 1 6 5 5 1 7 1 2 3 6 5 1 6 7 7 6 4 1 7 5 2 0 1 3 4 6 4 5 7 2 6 5 6 2 5 6 5 6 5 1 6\r\n" + 
			"1 2 0 7 0 5 5 0 7 6 2 2 1 3 5 5 3 6 3 7 6 4 1 3 1 3 7 0 3 7 0 2 5 6 1 3 4 1 5 1 7 4 1 7 7 0 4 7 5 5\r\n" + 
			"7 6 0 3 5 1 4 0 5 2 5 0 1 3 5 5 4 4 6 1 6 5 7 6 2 1 6 5 5 3 0 5 7 1 1 3 6 2 2 2 4 5 7 4 5 1 1 0 7 3\r\n" + 
			"2 5 4 0 3 1 4 5 6 3 7 0 4 5 3 6 4 5 1 7 4 7 3 1 1 7 7 1 1 5 6 4 7 1 2 6 4 1 7 2 7 1 6 0 5 0 0 0 1 0\r\n" + 
			"3 0 2 5 1 7 1 1 1 6 5 1 3 1 3 1 1 7 1 3 6 5 5 3 1 3 1 6 2 3 2 6 6 1 1 7 5 7 5 7 1 6 0 3 5 1 5 3 0 0\r\n" + 
			"0 0 3 2 0 1 4 1 4 1 0 7 3 2 2 4 2 4 4 6 1 1 1 7 2 4 7 4 3 6 3 5 1 6 1 3 7 7 2 6 3 2 1 0 4 6 2 6 3 0\r\n" + 
			"0 0 5 4 7 2 4 6 4 1 6 7 2 2 1 6 2 1 5 4 7 2 2 1 0 7 6 1 7 2 5 7 0 4 1 6 4 0 3 0 0 5 5 0 7 7 0 3 0 0\r\n" + 
			"0 0 6 4 3 1 3 1 4 7 2 1 2 4 3 4 1 6 2 1 5 1 1 6 0 7 2 7 2 4 7 4 0 3 7 7 3 3 5 2 0 4 3 0 4 2 0 1 3 5\r\n" + 
			"0 1 0 5 6 4 4 6 5 7 0 6 1 4 5 6 2 1 2 4 4 1 1 2 6 1 6 2 0 3 7 3 0 0 5 1 7 6 6 6 1 3 4 2 1 0 7 0 5 5\r\n" + 
			"0 7 2 1 4 2 7 3 0 2 1 4 3 5 1 1 1 1 7 1 4 4 1 7 6 0 1 2 0 5 2 0 0 0 5 4 0 3 7 5 3 1 4 1 2 7 2 6 6 4\r\n" + 
			"0 1 3 0 3 4 6 3 4 2 4 0 7 5 1 1 2 7 1 6 4 2 2 0 5 6 3 3 1 1 0 0 0 3 0 4 5 4 3 1 1 6 1 6 2 0 1 4 7 7\r\n" + 
			"0 3 0 0 2 6 1 4 7 5 1 4 3 2 5 1 4 3 6 3 0 2 4 5 7 5 6 2 0 5 6 3 6 4 6 2 0 0 6 0 7 2 2 6 0 0 0 0 0 0\r\n" + 
			"0 6 7 1 6 4 3 6 0 2 6 7 6 2 1 6 6 6 2 0 0 7 3 0 1 1 2 0 0 0 3 1 6 7 5 6 4 1 7 5 2 0 2 6 0 0 0 0 4 0\r\n" + 
			"0 6 7 7 3 3 0 2 0 1 6 4 1 1 1 6 2 3 3 4 2 3 5 0 5 7 7 6 2 7 2 7 3 1 0 5 6 7 1 6 4 1 5 0 0 0 0 0 0 0\r\n" + 
			"0 7 3 0 4 3 0 0 6 6 0 5 1 1 1 1 1 6 0 0 7 0 0 0 2 4 3 2 3 3 6 0 0 1 0 2 6 7 3 4 0 3 2 4 0 0 0 0 0 7\r\n" + 
			"0 0 4 7 2 0 0 0 1 4 2 4 7 7 2 4 2 4 0 5 6 0 0 0 7 0 2 7 4 4 1 6 1 4 2 3 6 2 0 6 5 3 5 0 3 5 6 0 0 1\r\n" + 
			"0 0 7 4 7 0 3 0 4 4 6 2 4 7 0 5 7 1 3 6 5 6 6 7 3 3 6 6 4 2 0 0 3 0 4 7 2 6 4 0 6 2 4 6 7 1 7 2 7 1\r\n" + 
			"0 0 2 6 0 0 6 5 0 4 1 2 2 2 2 7 2 1 0 4 6 4 1 0 1 1 2 2 0 4 4 2 0 0 3 0 3 6 2 2 7 6 6 0 4 6 0 2 2 2\r\n" + 
			"0 0 4 4 7 1 1 1 7 3 7 6 2 3 3 0 5 0 0 6 1 2 6 3 1 7 0 4 7 4 3 6 1 5 1 0 3 7 4 0 3 0 5 6 2 0 0 3 0 5\r\n" + 
			"0 0 7 3 0 5 4 0 7 4 0 0 4 5 7 1 3 2 3 3 5 3 5 3 5 5 5 5 4 2 3 6 0 3 1 7 2 4 5 3 0 0 5 3 6 0 0 7 3 6\r\n" + 
			"0 0 3 5 0 0 1 1 1 0 0 0 5 3 5 5 1 2 7 0 4 3 1 6 7 1 5 7 4 4 5 7 0 3 6 3 3 7 7 4 1 3 5 2 0 0 0 7 7 4\r\n" + 
			"0 0 7 6 3 5 0 7 2 7 7 5 4 0 0 7 0 4 0 0 3 2 3 1 5 7 4 6 0 3 5 5 2 0 6 0 0 0 2 1 1 4 3 6 2 0 5 1 1 6\r\n" + 
			"0 0 1 0 4 1 0 2 5 0 0 0 6 7 3 7 0 0 0 0 4 3 3 3 0 1 0 0 0 1 5 1 5 4 5 1 7 0 0 5 0 5 6 0 3 2 5 0 3 4\r\n" + 
			"0 0 0 0 0 4 0 2 3 1 6 6 6 3 5 3 6 0 0 0 4 7 0 6 1 7 1 0 0 5 5 2 5 1 0 1 1 3 3 4 1 4 2 0 6 3 0 0 6 4\r\n" + 
			"6 4 2 2 0 0 0 3 3 0 0 1 4 0 5 0 2 0 7 0 1 7 7 1 5 7 0 0 0 3 1 5 5 6 0 6 2 6 4 0 7 6 5 1 3 3 7 0 2 5\r\n" + 
			"0 0 0 7 7 0 0 4 4 3 1 6 1 0 1 3 3 1 4 5 7 3 7 0 0 4 0 0 0 7 3 7 2 2 0 1 5 0 7 5 5 2 5 1 0 2 0 0 3 2\r\n" + 
			"0 0 0 3 0 0 0 0 1 2 6 7 1 6 7 0 3 5 2 7 3 0 4 5 2 0 0 0 0 2 5 7 3 7 5 6 0 0 2 2 5 4 7 6 4 5 1 4 4 6\r\n" + 
			"0 4 3 0 0 0 0 3 5 6 3 2 0 3 6 0 6 0 0 1 4 3 6 2 4 7 4 7 1 5 0 4 0 0 2 0 0 0 3 7 6 1 2 5 3 5 2 3 3 3\r\n" + 
			"0 0 0 1 4 0 0 2 1 0 2 0 0 1 7 3 4 3 3 4 7 0 6 7 4 7 3 1 6 1 7 3 4 4 7 5 2 1 3 7 2 5 2 3 3 2 3 0 1 2\r\n" + 
			"0 0 0 0 1 1 0 0 5 7 3 6 6 0 0 6 5 4 2 7 0 0 4 5 5 0 5 7 3 3 0 3 5 5 3 6 0 0 3 5 4 0 0 7 5 1 6 0 0 7\r\n" + 
			"0 0 0 0 5 6 3 1 5 2 0 7 7 7 0 0 1 0 3 6 4 1 6 7 2 1 6 5 2 0 0 7 4 5 0 0 0 0 0 6 6 0 0 5 6 0 2 3 4 5\r\n" + 
			"0 0 7 1 0 1 6 5 6 0 0 5 4 5 7 1 1 6 5 2 2 0 3 7 4 5 2 6 4 0 0 3 4 0 0 0 0 0 0 7 7 7 7 6 4 3 4 4 0 0\r\n" + 
			"0 0 0 1 3 0 0 3 7 1 1 0 4 1 4 4 2 6 1 6 2 2 7 4 2 4 1 7 1 6 4 3 3 1 3 4 0 0 3 2 0 2 0 1 3 3 4 7 1 5\r\n" + 
			"0 0 0 3 4 0 0 2 0 5 5 0 0 1 4 4 0 4 0 1 6 6 4 2 1 0 0 3 7 0 4 3 3 2 3 5 3 5 0 4 0 5 0 3 0 7 7 3 5 6\r\n" + 
			"0 0 0 7 2 0 0 4 2 2 6 2 2 5 0 5 0 3 4 3 5 5 2 0 4 0 0 5 0 0 4 1 6 4 4 3 4 0 0 5 0 1 1 2 0 7 3 4 0 4\r\n" + 
			"0 0 1 1 4 4 1 0 0 0 3 5 4 5 4 2 7 4 6 1 6 7 0 3 0 7 1 7 6 6 3 0 5 7 6 6 4 7 3 4 5 0 0 0 0 6 1 1 5 3\r\n" + 
			"0 0 4 2 5 7 4 4 2 1 2 1 3 4 7 2 7 2 1 6 3 3 0 7 5 6 6 4 5 5 3 3 2 7 5 3 1 4 7 0 0 0 0 0 0 3 1 5 6 5\r\n" + 
			"0 0 0 4 4 1 0 0 6 0 0 7 5 7 5 1 7 3 6 0 2 4 3 4 7 7 3 0 0 0 1 5 5 0 6 7 7 7 4 4 3 6 3 7 5 0 1 1 0 2\r\n" + 
			"0 0 0 1 3 4 7 2 5 0 0 4 4 0 5 2 2 0 1 7 0 1 1 3 6 5 2 6 2 7 7 3 6 7 1 3 4 6 7 5 3 7 4 6 0 0 0 4 3 1\r\n" + 
			"0 0 0 2 1 6 3 5 4 0 0 6 0 0 6 7 0 0 5 2 0 7 7 0 7 0 0 7 7 6 0 0 1 1 0 1 0 1 3 1 0 0 4 7 7 0 0 0 2 6\r\n" + 
			"0 0 0 2 4 0 6 7 2 4 1 5 6 3 0 0 0 0 4 2 7 1 1 5 2 0 0 7 2 2 3 1 3 5 5 7 7 4 0 3 4 2 3 0 0 4 6 6 0 1\r\n" + 
			"0 0 0 4 6 1 0 3 6 4 7 3 5 0 0 0 0 0 0 7 0 0 3 6 2 1 0 2 3 4 6 7 5 0 7 0 5 4 5 1 5 0 0 0 0 4 5 3 1 0\r\n" + 
			"1 3 6 5 5 2 3 7 6 1 0 6 7 3 2 5 6 7 6 6 0 0 7 1 0 5 5 0 3 0 2 0 7 4 5 3 2 5 1 5 3 0 0 0 1 2 0 1 0 0\r\n" + 
			"1 7 3 0 2 0 7 0 4 6 1 1 5 0 7 0 5 7 7 2 6 0 0 1 0 2 3 3 4 2 7 5 3 7 0 0 4 6 6 6 3 0 0 0 7 7 7 5 7 2";
}
