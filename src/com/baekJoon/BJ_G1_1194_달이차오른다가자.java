package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G1_1194_달이차오른다가자 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M, key, count[][], result, cnt;
	static char[][] map;
	static boolean isVisited[][][], gameOver;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[N][M];
		count = new int[N][M];
		isVisited = new boolean[N][M][77];
		int startR = 0;
		int startC = 0;
		
		for(int n=0; n<N; n++) {
			String temp = input.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = temp.charAt(m);
				if(map[n][m] == '0') {
					startR = n;
					startC = m;
				}
			}	
		}
		
		bfs(startR,startC);
		
		for(char x[] : map){
			System.out.println(Arrays.toString(x));
		}
		
		if(gameOver) {
//			System.out.println(result);
			System.out.println(cnt);
		}else {
			System.out.println(-1);
		}
		
//		for(int x[] : count){
//			System.out.println(Arrays.toString(x));
//		}
	}
	private static void bfs(int startR, int startC) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startR, startC));
		isVisited[startR][startC][key] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			cnt++;
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc][key] && map[nr][nc] != '#') {
					if( 'a' <= map[nr][nc] && map[nr][nc] <= 'f') {
						int temp = map[nr][nc];
						key |= 1 << (temp - 'a');
						isVisited[nr][nc][key] = true;
						queue.offer(new Node(nr, nc));
					}else if( 'A' <= map[nr][nc] && map[nr][nc] <= 'F' ){
						int temp = 1 << map[nr][nc] - 'A';
						int check = key & temp;
						if(check == 0) { // 열쇠가 없다
							continue; // 있다
						}else {
							isVisited[nr][nc][key] = true;
							queue.offer(new Node(nr, nc));
						}
					}else if(map[nr][nc] == '1') {
						result = count[nr][nc];
						queue.clear();
						gameOver = true;
						break;
					}else { // . 인 경우
						isVisited[nr][nc][key] = true;
						queue.offer(new Node(nr, nc));
					}
				}
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
	
	static int dr[] = {0,0,1,-1};
	static int dc[] = {1,-1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static String src =
			"7 8\r\n" + 
			"a#c#eF.1\r\n" + 
			".#.#.#..\r\n" + 
			".#B#D###\r\n" + 
			"0....F.1\r\n" + 
			"C#E#A###\r\n" + 
			".#.#.#..\r\n" + 
			"d#f#bF.1";

}
