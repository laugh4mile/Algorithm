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
		input = new BufferedReader(new StringReader(src));
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
		
		while(!queue.isEmpty()) {
			int front = R-queue.poll(); // 거꾸로 봐야함
			stickThrow(front, dir); // 맵을 부숨. dir = false : 좌, true : 우
			Queue<Node> q = new LinkedList<>();
			isVisited = new boolean[R][C];
			for(int c=0; c<C;c++) {
				if(map[R-1][c] == 'x') {
					q.offer(new Node(R-1, c));
					isVisited[R-1][c] = true;
				}
			}
			while(!q.isEmpty()) {
				Node node = q.poll();
				for(int d=0; d<4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == 'x') {
						q.offer(new Node(nr, nc));
						isVisited[nr][nc] = true;
					}
				}
			}
			List<Node> list = new ArrayList<>();
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(!isVisited[r][c] && map[r][c] == 'x') {
						list.add(new Node(r, c));
					}
				}	
			}
			if(list.size() != 0) {
				drop(list);// 리스트를 바닥또는 x에 닿을때까지 내린다.
			}
			
		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}

	
	private static void drop(List<Node> list) {
		for(Node node : list) {
			map[node.r][node.c] = '.';
		}
		int cnt = 0;
		outer : for(int i=1; i<R; i++) {
			for(Node node : list) {
				if(node.r+i>=R || map[node.r+i][node.c] == 'x') {
					break outer;
				}
			}
			cnt = i;
		}
		for(Node node : list) {
			map[node.r+cnt][node.c] = 'x';
		}
		
	}


	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
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
			"10 10\r\n" + 
			"xxxxxxxxxx\r\n" + 
			"....x.....\r\n" + 
			"...xxx....\r\n" + 
			".....x....\r\n" + 
			"....xx....\r\n" + 
			".....x....\r\n" + 
			"xxxxxx....\r\n" + 
			"..x.......\r\n" + 
			".xxxx.....\r\n" + 
			"...xxxxxxx\r\n" + 
			"10\r\n" + 
			"9 8 7 6 5 4 3 2 1 1";
}
