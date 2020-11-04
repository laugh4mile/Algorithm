package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G4_15685_드래곤커브 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,map[][] = new int[101][101], answer;
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int g = Integer.parseInt(tokens.nextToken());
			dirStore(y,x,d,g);
		}
		
		getSquare();
		System.out.println(answer);
	}
	
	private static void getSquare() {
		for(int r=0; r<map.length-1; r++) {
			for(int c=0; c<map.length-1; c++) {
				if(map[r][c] == 1 && map[r][c] == map[r+1][c] && map[r][c] == map[r][c+1] && map[r][c]== map[r+1][c+1]) {
					answer++;
				}
			}	
		}
	}

	private static void dirStore(int r, int c, int d, int g) {
		int cnt = 0;
		List<Integer> dir = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		dir.add(d);
		
		while(cnt < g) {
			for(int i=0; i<dir.size(); i++) {
				stack.push(dir.get(i));
			}
			
			while(!stack.isEmpty()) {
				switch (stack.pop()) {
				case 0:
					dir.add(1);
					break;
				case 1:
					dir.add(2);
					break;
				case 2:
					dir.add(3);
					break;
				case 3:
					dir.add(0);
					break;
				}
			}
			cnt++;
		}
		//여기까지 완벽
		makeMap(r,c,dir);
		
	}

	private static void makeMap(int r, int c, List<Integer> dir) {
		map[r][c] = 1;
//		int cnt = 0;
		for(int i=0; i<dir.size(); i++) {
			switch (dir.get(i)) {
			case 0: 
				c = c+1; 
				if(isIn(r, c)) {
					
				}
				map[r][c] = 1;
				break;
			case 1:
				r = r-1; 
				if(isIn(r, c)) {
					map[r][c] = 1;
				}
				break;
			case 2:
				c = c-1; 
				if(isIn(r, c)) {
					map[r][c] = 1;
				}
				break;
			case 3:
				r = r+1; 
				if(isIn(r, c)) {
					map[r][c] = 1;
				}
				break;

			}
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<map.length && c<map.length);
	}

	static class Node{
		int r;
		int c;
		int d;
		int g;
		public Node(int r, int c, int d, int g) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.g = g;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", d=" + d + ", g=" + g + "]";
		}
	}
	
	static String src =
			"3\r\n" + 
			"3 3 0 1\r\n" + 
			"4 2 1 3\r\n" + 
			"4 2 2 1";
}
