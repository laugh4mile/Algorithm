package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_4485_녹색옷을입은애가젤다지 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,map[][],distance[][],cnt=1;
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		while(true) {
			N = Integer.parseInt(input.readLine());
			if(N == 0) break;
			map = new int[N][N];
			distance = new int[N][N];
			isVisited = new boolean[N][N];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					distance[r][c] = Integer.MAX_VALUE;
				}
			}
			dijkstra(0,0);
			int answer = distance[N-1][N-1]+map[N-1][N-1];
			System.out.println("Problem "+ cnt++ +": " + answer);
		}
	}
	private static void dijkstra(int startI, int startJ) {
		distance[startI][startJ] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startI, startJ, 0));
		
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			if(!isVisited[front.r][front.c]) {
				isVisited[front.r][front.c] = true;
				for(int d=0; d<4; d++) {
					int nr = front.r + dr[d];
					int nc = front.c + dc[d];
					if(isIn(nr, nc) && !isVisited[nr][nc] && distance[nr][nc] > distance[front.r][front.c] + map[front.r][front.c]) {
						distance[nr][nc] = distance[front.r][front.c] + map[front.r][front.c];
						pq.offer(new Node(nr, nc, distance[nr][nc]));
					}
				}
			}
		}  
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
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	static String src =
			"3\r\n" + 
			"5 5 4\r\n" + 
			"3 9 1\r\n" + 
			"3 2 7\r\n" + 
			"5\r\n" + 
			"3 7 2 0 1\r\n" + 
			"2 8 0 9 1\r\n" + 
			"1 2 1 8 1\r\n" + 
			"9 8 9 2 0\r\n" + 
			"3 6 5 1 5\r\n" + 
			"7\r\n" + 
			"9 0 5 1 1 5 3\r\n" + 
			"4 1 2 1 6 5 3\r\n" + 
			"0 7 6 1 6 8 5\r\n" + 
			"1 1 7 8 3 2 3\r\n" + 
			"9 4 0 7 6 4 1\r\n" + 
			"5 8 3 2 4 8 3\r\n" + 
			"7 4 8 4 8 3 4\r\n" + 
			"0";
}
