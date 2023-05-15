package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1261_알고스팟 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],distance[][];
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		distance = new int[N][M];
		isVisited = new boolean[N][M];
		for(int n=0; n<N; n++) {
			String line = input.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m) - '0';
				distance[n][m] = Integer.MAX_VALUE;
			}	
		}
		dijkstra(0,0);
		System.out.println(distance[N-1][M-1]);
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
		return (r>=0 && c>=0 && r<N && c<M);
	}
	static String src =
			"3 3\r\n" + 
			"011\r\n" + 
			"111\r\n" + 
			"110";
}
