package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_3987_보이저1호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M, PR,PC, answer, max = Integer.MIN_VALUE;
	static char map[][];
	static boolean isVisited[][][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[502][502];
		isVisited = new boolean[N][M][4];
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		tokens = new StringTokenizer(input.readLine());
		PR = Integer.parseInt(tokens.nextToken())-1;
		PC = Integer.parseInt(tokens.nextToken())-1;
		
		move(new Node(PR,PC,0)); // U
		move(new Node(PR,PC,3)); // R
		move(new Node(PR,PC,1)); // D
		move(new Node(PR,PC,2)); // L 순서 중요!
		
		switch (answer) {
		case 0:
			System.out.println("U");
			break;
		case 1:
			System.out.println("D");
			break;
		case 2:
			System.out.println("L");
			break;
		case 3:
			System.out.println("R");
			break;
		}
		if(max == Integer.MAX_VALUE) {
			System.out.println("Voyager");
		}else {
			System.out.println(max);
		}
	}

	private static void move(Node curNode) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(curNode);
		isVisited[curNode.r][curNode.c][curNode.dir] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(map[front.r][front.c] == 'C') break;
			
			int nr = front.r;
			int nc = front.c;
			int dir = front.dir;
			switch (dir) {
			case 0: // 상
				nr--;
				break;
			case 1: // 하
				nr++;
				break;
			case 2: // 좌
				nc--;
				break;
			case 3: // 우
				nc++;
				break;
			}
			if(isIn(nr, nc)) {
				if(map[nr][nc] == '/' || map[nr][nc] == '\\') {
					dir = turn(map[nr][nc],dir);
				}
				if(!isVisited[nr][nc][dir]) {
					isVisited[nr][nc][dir] = true;
					queue.offer(new Node(nr, nc, dir));
					cnt++;
				}else {
					cnt = Integer.MAX_VALUE;
					break;
				}
			}else {
				cnt++;
				break;
			}
		}
		if(max < cnt) {
			max = cnt;
			answer = curNode.dir;
		}
	}

	private static int turn(char c, int dir) {
		switch (dir) {
		case 0: // 상
			if(c=='/') {
				dir = 3;
			}else {
				dir = 2;
			}
			break;
		case 1: // 하
			if(c=='/') {
				dir = 2;
			}else {
				dir = 3;
			}
			break;
		case 2: // 좌
			if(c=='/') {
				dir = 1;
			}else {
				dir = 0;
			}			
			break;
		case 3: // 우
			if(c=='/') {
				dir = 0;
			}else {
				dir = 1;
			}
			break;
		}
		return dir;
	}

	static class Node{
		int r;
		int c;
		int dir;
		public Node(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}
	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<M);
	}
	static String src =
			"5 5\r\n" + 
			"../.\\\r\n" + 
			".....\r\n" + 
			".C...\r\n" + 
			"...C.\r\n" + 
			"\\.../\r\n" + 
			"3 3";
}
