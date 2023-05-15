package com.codingtest.devmatching.test2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q3 {
	static int[][] macaron = {
			{1,1},
			{2,1},
			{1,2},
			{3,3},
			{6,4},
			{3,1},
			{3,3},
			{3,3},
			{3,4},
			{2,1}
	};
//	static int[][] macaron = {
//			{1,1},
//			{1,2},
//			{1,4},
//			{2,1},
//			{2,2},
//			{2,3},
//			{3,4},
//			{3,1},
//			{3,2},
//			{3,3},
//			{3,4},
//			{4,4},
//			{4,3},
//			{5,4},
//			{6,1},
//	};
	static int[][] map = new int[6][6];
	static boolean[][] isVisited = new boolean[6][6];
	static boolean flag;
	public static void main(String[] args) {
		String[] answer = solution(macaron);
//		System.out.println(Arrays.toString(answer));
	}
	static String[] solution(int[][] macaron) {
		String[] answer = {};
		for(int i=0; i<macaron.length; i++) {
			setMacaron(macaron[i][0]-1, macaron[i][1]);
			flag = true;
			while(flag) {
				flag = false;
				boomMacaron();
				sortMacaron();
			}
		}
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
		System.out.println();
		return answer;
	}
	
	private static void sortMacaron() {
		for(int c=0; c<6; c++) {
			Queue<Integer> queue = new LinkedList<>();
			for(int r=5; r>=0; r--) {
				if(map[r][c] != 0) {
					queue.offer(map[r][c]);
				}
				map[r][c] = 0;
			}
			for(int r=5; r>=0; r--) {
				if(!queue.isEmpty()) {
					map[r][c] = queue.poll();
				}else {
					break;
				}
			}
		}
	}
	
	private static void boomMacaron() {
		for(int r=0; r<6; r++) {
			for(int c=0; c<6; c++) {
				isVisited[r][c] = false;
			}	
		}
		for(int r=0; r<6; r++) {
			for(int c=0; c<6; c++) {
				if(!isVisited[r][c] && map[r][c] != 0) {
					bfs(r,c);
				}
			}	
		}
	}
	
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		Queue<Node> queue2 = new LinkedList<>();
		queue.offer(new Node(r, c));
		queue2.offer(new Node(r, c));
		isVisited[r][c] = true;
		int color = map[r][c];
		int cnt = 0;
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			cnt++;
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == color) {
					isVisited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
					queue2.offer(new Node(nr, nc));
				}
			}
		}
		if(cnt>=3) {
			while(!queue2.isEmpty()) {
				Node front = queue2.poll();
				map[front.r][front.c] = 0;
				flag = true;
			}
		}
		
	}
	static void setMacaron(int column, int color) {
		for(int r=5; r>=0; r--) {
			if(map[r][column] == 0) {
				map[r][column] = color;
				break;
			}
		}
	}
	
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<6 && c<6);
	}
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
}
