package com.cordingtest.woowa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.cordingtest.woowa.Q4.Node;

public class Q4 {
	static int n = 4;
	static int[][] board = 
			{
				{11, 9, 8, 12},
				{2, 15, 4, 14},
				{1, 10, 16, 3},
				{13, 7, 5, 6}
			};
	static int arr[][] = new int[n][n]; 
	static boolean isVisited[][] = new boolean[n][n];
	
	static int answer = 0, startR,startC;
	public static void main(String[] args) {
		
		//result 는 22
//		bfs(r,c,1);
		for(int num=1; num<=n*n; num++) {
			clear();
			bfs(startR,startC,num);
		}
		for(int[] x : arr) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(answer+n*n);
//		for(boolean[] x : isVisited) {
//			System.out.println(Arrays.toString(x));
//		}
//		
	}
	


	private static void clear() {
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				isVisited[r][c] = false;
				arr[r][c] = 0;
			}	
		}
	}



	private static void bfs(int r, int c, int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			System.out.println(front);
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(nr < 0) {
					nr = n-1;
				}
				if(nr > n-1) {
					nr = 0;
				}
				if(nc < 0) {
					nc = n-1;
				}
				if(nc > n-1) {
					nc = 0;
				}
				if(!isVisited[nr][nc]) {
					isVisited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
					arr[nr][nc] = arr[front.r][front.c] + 1;
					if(board[nr][nc] == num) {
						startR = nr;
						startC = nc;						
					}
				}
			}
		}
		answer += arr[startR][startC];
//		startR = lastR;
//		startC = lastC;
		
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
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}
}
