package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_2933_미네랄 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R, C, N;
	static boolean isVisited[][], dir;
	static char map[][];
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String line = input.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			int stick = Integer.parseInt(tokens.nextToken());
			queue.offer(stick);
		}
		
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		while(!queue.isEmpty()) {
			int front = R-queue.poll(); // 거꾸로 봐야함
			stickThrow(front, dir); // 맵을 부숨. dir = false : 좌, true : 우
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					isVisited = new boolean[R][C];
					if(!isVisited[r][c] && map[r][c] == 'x') {
						bfs(r,c);
					}
				}	
			}
		}
		for(char x[] : map) {
			System.out.println(Arrays.toString(x));
		}
	}

	private static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		list.add(new Node(r, c));
		q.offer(new Node(r, c));
		isVisited[r][c] = true;
		boolean flag = false;
		while(!q.isEmpty()) {
			Node front = q.poll();
			if(front.r == R-1) {
				flag = true;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == 'x') {
					q.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
					list.add(new Node(nr, nc));
				}
			}
		}
		
		if(!flag) {
			
			List<Node> list2 = new ArrayList<>(); // 열중에 가장 r이 큰값만 담을 리스트
			
			Collections.sort(list);
			int cs = -1;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).c != cs) {
					cs = list.get(i).c; 
					list2.add(list.get(i));
				}
			}
			int min = Integer.MAX_VALUE; // 차이값의 최소 : 내려갈 칸 수
			for(int i=0; i<list2.size(); i++) {
				if(R - list2.get(i).r-1 < min) {
					min = R - list2.get(i).r - 1; 
				}
			}
//		System.out.println(min);
			if(min != 0) { // 내려갈 칸수가 0이아니면 min만큼 내릴거임 
				for(int i=0; i<list.size(); i++) {
					map[list.get(i).r][list.get(i).c] = '.';
				}
				for(int i=0; i<list.size(); i++) {
					map[list.get(i).r+min][list.get(i).c] = 'x';
				}
			}
		}
		
		
		
	}
	
	static class Node implements Comparable<Node>{
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
		@Override
		public int compareTo(Node o) {
			if(this.c == o.c) {
				return Integer.compare(o.r, this.r);
			}
			return Integer.compare(this.c, o.c);
		}
	}
	
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	
	static boolean isIn(int r, int c) {
		return(r>=0 && c>=0 && r<R && c<C);
	}
	
	private static void stickThrow(int front, boolean turn) {
		if(!turn) { // -> 방향
			for(int c=0; c<C; c++) {
				if(map[front][c] == 'x') {
					map[front][c] = '.';
					break;
				}
			}
		}else { // <- 방향
			for(int c=C-1; c>=0; c--) {
				if(map[front][c] == 'x') {
					map[front][c] = '.';
					break;
				}
			}
		}
		dir = !dir;
	}

	static String src =
			"8 8\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"...x.xx.\r\n" + 
			"...xxx..\r\n" + 
			"..xxx...\r\n" + 
			"..x.xxx.\r\n" + 
			"..x...x.\r\n" + 
			".xxx..x.\r\n" + 
			"5\r\n" + 
			"6 6 4 3 1";
}
