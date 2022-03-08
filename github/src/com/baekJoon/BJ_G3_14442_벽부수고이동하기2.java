package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G3_14442_벽부수고이동하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,map[][],distance[][];
	static boolean isVisited[][][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		distance = new int[N][M];
		isVisited = new boolean[N][M][K+1]; // 0개 ~ K개
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c) - '0';
				distance[r][c] = Integer.MAX_VALUE;
			}
		}
		bfs(0,0);
		if(distance[N-1][M-1] == Integer.MAX_VALUE){
			System.out.println(-1);
		}else{
			System.out.println(distance[N-1][M-1]);
		}
	}
	static void bfs(int r, int c){
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r,c,0,1));
		distance[r][c] = 1;
		isVisited[r][c][0] = true;

		while(!queue.isEmpty()){
			Node front = queue.poll();
			if(distance[front.r][front.c] > front.d){
				distance[front.r][front.c] = front.d;
			}
//			System.out.println(front);
			for(int d=0; d<4; d++){
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];

				if(isIn(nr,nc) && !isVisited[nr][nc][front.v]){
					isVisited[nr][nc][front.v] = true;
					if(map[nr][nc] == 0){
						queue.offer(new Node(nr,nc,front.v,front.d+1));
					}else{
						if(front.v < K){
							queue.offer(new Node(nr,nc,front.v+1, front.d+1));
						}
					}
				}
			}

		}
	}

	static class Node {
		int r;
		int c;
		int v; // 부순 벽의 개수
		int d; // 현재 이동거리

		public Node(int r, int c, int v, int d) {
			this.r = r;
			this.c = c;
			this.v = v;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Node{" +
					"r=" + r +
					", c=" + c +
					", v=" + v +
					", d=" + d +
					'}';
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	static String src =
			"4 4 3\n" +
					"0111\n" +
					"1111\n" +
					"1111\n" +
					"1110";
}
