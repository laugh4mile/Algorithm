package com.codingtest.devmatching2;

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
	static int[][] map = new int[6][6];
	static boolean[][] isVisited = new boolean[6][6];
	public static void main(String[] args) {
		String[] answer = solution(macaron);
		System.out.println(Arrays.toString(answer));
	}
	static String[] solution(int[][] macaron) {
		String[] answer = {};
		for(int i=0; i<macaron.length; i++) {
			Arrays.fill(isVisited, false);
			setMacaron(macaron[i][0], macaron[i][1]);
			boomMacaron();
			sortMacaron();
		}
		
		return answer;
	}
	
	private static void sortMacaron() {
		
	}
	private static void boomMacaron() {
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
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
		}
	}
	static void setMacaron(int column, int color) {
		for(int r=5; r>=0; r--) {
			if(map[r][color] == 0) {
				map[r][color] = color;
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
