package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2206_벽부수고이동하기_2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][], answer = -1;
	static boolean isVisited[][][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		isVisited = new boolean[N][M][2];
		for(int n=0; n<N; n++) {
			String line = input.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m) - '0';
			}
		}

		bfs(0,0);
		System.out.println(answer);
	}
	private static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(i, j,1, 1));
		isVisited[i][j][0] = true;

		while(!queue.isEmpty()){
			Node front = queue.poll();
			System.out.println(front);
			if(front.r == N-1 && front.c == M-1){
				answer = front.d;
				return;
			}
			for(int d=0; d<4; d++){
				int nr = front.r+dr[d];
				int nc = front.c+dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc][front.breakable]){
					isVisited[nr][nc][front.breakable] = true;
					if(map[nr][nc] == 0){
						queue.offer(new Node(nr, nc, front.breakable, front.d+1));
					}else{
						if(front.breakable == 1){
							queue.offer(new Node(nr, nc, 0, front.d+1));
						}
					}
				}
			}
		}

	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static class Node{
		int r;
		int c;
		int breakable;
		int d;

		public Node(int r, int c, int breakable, int d) {
			this.r = r;
			this.c = c;
			this.breakable = breakable;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Node{" +
					"r=" + r +
					", c=" + c +
					", breakable=" + breakable +
					", d=" + d +
					'}';
		}
	}
	
	static String src =
			"6 4\n" +
					"0100\n" +
					"1110\n" +
					"1000\n" +
					"0000\n" +
					"0111\n" +
					"0000";

}
