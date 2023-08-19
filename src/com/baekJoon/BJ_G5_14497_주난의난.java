package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_14497_주난의난 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, distance[][];
	static boolean isVisited[][];
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		distance = new int[N][M];
		isVisited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				distance[r][c] = Integer.MAX_VALUE;
			}	
		}
		map = new char[N][M];
		
		tokens = new StringTokenizer(input.readLine());
		int startR = Integer.parseInt(tokens.nextToken())-1;
		int startC = Integer.parseInt(tokens.nextToken())-1;
		int endR = Integer.parseInt(tokens.nextToken())-1;
		int endC = Integer.parseInt(tokens.nextToken())-1;
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		map[endR][endC] = '1';
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		dijkstra(startR, startC);
		System.out.println(distance[endR][endC]);
	}

	private static void dijkstra(int startR, int startC) {
		distance[startR][startC] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startR, startC, 0));
		
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			
			if(!isVisited[front.r][front.c]) {
				isVisited[front.r][front.c] = true;
				
				for(int d=0; d<4; d++) {
					int nr = front.r + dr[d];
					int nc = front.c + dc[d];
					if(isIn(nr, nc) && distance[nr][nc] > distance[front.r][front.c] + (map[nr][nc] - '0')) {
						distance[nr][nc] = distance[front.r][front.c] + (map[nr][nc] - '0');
						pq.offer(new Node(nr, nc, distance[nr][nc]));
					}
				}
			}
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int v;
		public Node(int r, int c, int v) {
			super();
			this.r = r;
			this.c = c;
			this.v = v;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.v, o.v);
		}
		
	}
	static String src =
			"3 3\r\n" + 
			"2 2 1 1\r\n" + 
			"#00\r\n" + 
			"0*0\r\n" + 
			"000";
}
