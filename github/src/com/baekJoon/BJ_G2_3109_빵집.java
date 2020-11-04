package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G2_3109_빵집 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, cnt;
	static char  map[][];
	static boolean isVisited[][], flag;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		isVisited = new boolean[R][C];
		
		for(int r=0; r<R; r++) {
			String line = input.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
//		for(char[] x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
		for(int r=0; r<R ; r++) {
			dfs(r,0);
			flag = false;
		}
		System.out.println(cnt);
		
//		for(boolean[] x : isVisited) {
//			System.out.println(Arrays.toString(x));
//		}
		
	}
	
	private static void dfs(int r, int c) {
//		System.out.println();
		if(c == C-1) {
			flag = true;
			isVisited[r][c] = true;
			cnt++;
			return;
		}
		
		Node front = new Node(r, c);
		isVisited[r][c] = true;
		
		List<Node> childs = new LinkedList<>();
		
		for(int i=0; i<3; i++) {
			if(isIn(front.x+dx[i], front.y+dy[i]) && map[front.x+dx[i]][front.y+dy[i]] != 'x') {
				childs.add(new Node(front.x+dx[i] , front.y+dy[i]));
			}
		}
//			System.out.println(childs.toString());
		for(int i=0; i<childs.size(); i++) {
			Node child = childs.get(i);
			if(!isVisited[child.x][child.y]) {
				dfs(child.x, child.y);
				if(flag) {
					return;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C);
	}
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
	}
	
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	
	static String src = 
			"5 5\r\n" + 
			".xx..\r\n" + 
			"..x..\r\n" + 
			".....\r\n" + 
			"...x.\r\n" + 
			"...x.";
}
