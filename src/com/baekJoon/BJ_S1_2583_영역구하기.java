package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2583_영역구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int M,N,K,map[][],cn;
	static boolean isVisited[][];
	static List<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[M][N];
		isVisited = new boolean[M][N];
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int r1 = Integer.parseInt(tokens.nextToken());
			int c1 = Integer.parseInt(tokens.nextToken());
			int r2 = Integer.parseInt(tokens.nextToken());
			int c2 = Integer.parseInt(tokens.nextToken());
			
			for(int r=c1; r<c2; r++) {
				for(int c=r1; c<r2; c++) {
					map[r][c] = 1;
				}
			}
		}
		int cnt = 0;
//		for(int r=0; r<M; r++) {
//			for(int c=0; c<N; c++) {
//				System.out.print(map[r][c]);
//			}
//			System.out.println();
//		}
		for(int r=0; r<M; r++) {
			for(int c=0; c<N; c++) {
//				System.out.print(map[r][c]);
				if(!isVisited[r][c]&& map[r][c] == 0) {
					bfs(r,c);
					cnt++;
					result.add(cn);
					cn=0;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(result);
		for(int i=0; i< result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
//		System.out.println(result);
	}
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			cn++;
			for(int i=0; i<4; i++) {
				int nr = front.r+dx[i];
				int nc = front.c+dy[i];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == 0) {
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
		}
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<M && c<N);
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
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static String src = "5 7 3\r\n" + 
			"0 2 4 4\r\n" + 
			"1 1 2 5\r\n" + 
			"4 0 6 2";
}
