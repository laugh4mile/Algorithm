package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_16954_움직이는미로탈출 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static char map[][];
	static boolean isVisited[][][];
	static final int N = 8;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		map = new char[N][N];
		isVisited = new boolean[N][N][9];
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		dropMap();
//		System.out.println();
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		bfs();
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(N-1, 0, 0));
		isVisited[N-1][0][0] = true;
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			int fr = front.r;
			int fc = front.c;
			int fd = front.down;
			if(fr == 0 && fc == N-1) {
				System.out.println(1);
				return;
			}
			
			for(int d=0; d<9; d++) {
				int nr = fr + dr[d];
				int nc = fc + dc[d];
				int nd = Math.min(fd+1, 8);
				if(!isIn(nr, nc)) continue;
				if(isIn(nr-fd, nc) && map[nr-fd][nc] == '#') continue;
				if(isIn(nr-fd-1, nc) && map[nr-fd-1][nc] == '#') continue;
				if(isVisited[nr][nc][nd]) continue;
				queue.offer(new Node(nr, nc, nd));
				isVisited[nr][nc][nd] = true;
			}
		}
		System.out.println(0);
		return;
	}
	static class Node{
		int r;
		int c;
		int down;
		public Node(int r, int c, int down) {
			super();
			this.r = r;
			this.c = c;
			this.down = down;
		}
	}
	
	static int dr[] = {-1,-1,-1,0,0,0,1,1,1}; // 9방향
	static int dc[] = {-1,0,1,-1,0,1,-1,0,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}

	
	static String src =
			"........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"#.......\r\n" + 
			".#######\r\n" + 
			"#.......\r\n" + 
			"........";
}