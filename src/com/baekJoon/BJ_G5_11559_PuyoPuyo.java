package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_11559_PuyoPuyo {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int answer;
	static boolean flag;
	static char map[][] = new char[12][6];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		for(int r=0; r<12; r++) {
			String line = input.readLine();
			for(int c=0; c<6; c++) {
				map[r][c] = line.charAt(c);
			}	
		}

		fuck : while(true) {
			outer: for(int r=0; r<12; r++) {
				for(int c=0; c<6; c++) {
					if(map[r][c] != '.') {
						bfs(r,c);
					}
				}
			}
			if(flag) { // 부쉈다?
				answer++;
			}else {
				break fuck;
			}
			downMap();
			flag = false;
		}
		System.out.println(answer);
		
	}
	
	private static void bfs(int r, int c) {
		boolean isVisited[][] = new boolean[12][6];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		int cnt = 0; // 4 개 이상인지 확인
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			cnt++;
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
		}
		if(cnt > 3) { // 4이상 -> 지워버리자
			flag = true;
			isVisited = new boolean[12][6];
			queue = new LinkedList<>();
			queue.offer(new Node(r, c));
			isVisited[r][c] = true;
			while(!queue.isEmpty()) {
				Node front = queue.poll();
				for(int d=0; d<4; d++) {
					int nr = front.r + dr[d];
					int nc = front.c + dc[d];
					
					if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
						queue.offer(new Node(nr, nc));
						isVisited[nr][nc] = true;
						map[nr][nc] = '.';
					}
				}
			}
			map[r][c] = '.';
		}
		
	}

	private static void downMap() {
		for(int c=0; c<6; c++) {
			Stack<Character> stack = new Stack<>();
			for(int r=0; r<12; r++) {
				if(map[r][c] != '.') {
					stack.add(map[r][c]); // 스택에 담고
					map[r][c] = '.'; // .으로 바꿈
				}
			}
			for(int r=11; r>=0; r--) {
				if(!stack.isEmpty()) {
					map[r][c] = stack.pop();
				}
			}
			stack.clear();
		}
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<12 && c<6);
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
	
	static String src =
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"......\r\n" + 
			"....R.\r\n" + 
			".Y..P.\r\n" + 
			".G..PR\r\n" + 
			"RRYYYR\r\n" + 
			"RRGGGR";
}
