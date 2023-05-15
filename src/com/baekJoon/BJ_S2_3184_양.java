package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_3184_양 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,totalWolf,totalSheep;
	static boolean isVisited[][];
	static char map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char [R][C];
		isVisited = new boolean[R][C];
		for(int r=0; r<R; r++) {
			String line = input.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(!isVisited[r][c] && map[r][c] != '#') {
					bfs(r,c);
				}
			}	
		}
		System.out.println(totalSheep +" "+ totalWolf);
	}

	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c));
		isVisited[r][c] = true;
		int sheep = 0, wolf = 0;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(map[front.r][front.c] == 'o') {
				sheep++;
			}else if(map[front.r][front.c] == 'v') {
				wolf++;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] != '#') {
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
		}
		if(sheep > wolf) {
			totalSheep += sheep;
		}else {
			totalWolf += wolf;
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C);
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

	static String src =
			"9 12\r\n" + 
			".###.#####..\r\n" + 
			"#.oo#...#v#.\r\n" + 
			"#..o#.#.#.#.\r\n" + 
			"#..##o#...#.\r\n" + 
			"#.#v#o###.#.\r\n" + 
			"#..#v#....#.\r\n" + 
			"#...v#v####.\r\n" + 
			".####.#vv.o#\r\n" + 
			".......####.";
}
