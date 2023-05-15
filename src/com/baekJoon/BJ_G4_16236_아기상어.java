package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_16236_아기상어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], sharkSize=2;
	static Node shark = new Node(0, 0);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 9) {
					shark.r = r;
					shark.c = c;
				}
			}	
		}
		int answer = 0;
		int eatCnt = 0;
		
		while(canEat(map,sharkSize)) {
			map[shark.r][shark.c] = 0;
			int value = bfs(shark.r, shark.c);
			if(value == 0) {
				break;
			}
			answer += value;
			eatCnt++;
			if(eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
		}
		System.out.println(answer);
	}

	static boolean canEat(int[][] map, int sharkSize) {
		boolean flag = false;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if (map[r][c] < sharkSize && map[r][c] != 0) {
					flag = true;
				}
			}	
		}
		return flag; // 먹을 수 있는 물고기가 있으면  true 아니면 false
	}
	
	private static int bfs(int r, int c) {
		int move[][] = new int[N][N];
		boolean isVisited[][] = new boolean[N][N];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(map[front.r][front.c] < sharkSize && map[front.r][front.c] != 0) { // 먹을 수 있는 물고기는 pq에 담자
				int d = move[front.r][front.c];
				pq.offer(new Fish(front.r, front.c, d));
			}
			
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] <= sharkSize) {
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
					move[nr][nc] = move[front.r][front.c] + 1;
				}
			}
		}
		
		if(!pq.isEmpty()) {
			Fish closestFish = pq.poll();
			shark.r = closestFish.r;
			shark.c = closestFish.c;
			return move[shark.r][shark.c];
		}else {
			return 0;
		}
	}
		
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class Fish implements Comparable<Fish>{
		int r;
		int c;
		int d;
		public Fish(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		public int compareTo(Fish o) {
			if(this.d == o.d) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}else {
					return Integer.compare(this.r, o.r); 
				}
			}
			return Integer.compare(this.d, o.d);
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}

	static String src =
			"6\r\n" + 
			"1 1 1 1 1 1\r\n" + 
			"2 2 6 2 2 3\r\n" + 
			"2 2 5 2 2 3\r\n" + 
			"2 2 2 4 6 3\r\n" + 
			"0 0 0 0 0 6\r\n" + 
			"0 0 0 0 0 9";
}
