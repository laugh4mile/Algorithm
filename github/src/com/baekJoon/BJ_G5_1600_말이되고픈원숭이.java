package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1600_말이되고픈원숭이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int K,W,H,map[][];
	static boolean isVisited[][][]; // r, c, 말 이동유무
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		K = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][W];
		isVisited = new boolean[H][W][31];
		for(int r=0; r<H; r++){
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<W; c++){
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		bfs(0,0);
	}
	

	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c, 0, 0));
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			int fr = front.r;
			int fc = front.c;
			int fk = front.k;
			if(fr == H-1 && fc == W-1) {
				System.out.println(front.depth);
				return;
			}
			if(!isIn(fr, fc) || map[fr][fc] == 1) continue;
			if(isVisited[fr][fc][fk]) continue;
			// 조건에 맞는 놈만 큐에넣는것이 아니라 큐에 넣은놈이 조건에 맞는지 확인할 수 있다.
			isVisited[fr][fc][fk] = true;
			for(int d=0; d<4; d++) {
				int nr = fr + dr[d];
				int nc = fc + dc[d];
				queue.offer(new Node(nr, nc, fk, front.depth+1));
			}
			if (front.k == K) continue;
			for(int d=0; d<8; d++) {
				int nr = fr + kr[d];
				int nc = fc + kc[d];
				queue.offer(new Node(nr, nc, fk+1, front.depth+1));
			}
		}
		System.out.println(-1);
	}


	static class Node{
		int r;
		int c;
		int k;
		int depth;
		public Node(int r, int c, int k, int depth) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.depth = depth;
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	static int kr[] = {-2,-2,-1,-1,1,1,2,2};
	static int kc[] = {-1,1,-2,2,-2,2,-1,1};
	
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<H && c<W);
	}
	

	static String src =
			"1\r\n" + 
			"4 4\r\n" + 
			"0 0 0 0\r\n" + 
			"1 0 0 0\r\n" + 
			"0 0 1 0\r\n" + 
			"0 1 0 0";
}
