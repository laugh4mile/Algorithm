package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_20058_마법사상어와파이어스톰 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,Q,P, map[][], temp[][],remainIce,maxIceberg;
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		Q = Integer.parseInt(tokens.nextToken());
		P = (int) Math.pow(2, N);
		map = new int[P][P];
		isVisited = new boolean[P][P];
		for(int r=0; r<P; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<P; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				remainIce += map[r][c];
			}	
		}
		tokens = new StringTokenizer(input.readLine());
		for(int q=0; q<Q; q++) {
			int side = (int) Math.pow(2, Integer.parseInt(tokens.nextToken())); // 0이면 어쩐담?
			temp = new int[side][side];
			for(int r=0; r<P; r=r+side) {
				for(int c=0; c<P; c=c+side) {
					spinMap(r,c,side);
				}	
			}
			fireStorm();
		}
		if(remainIce > 0) {
			getMaxIceberg();
			System.out.println(remainIce);
			System.out.println(maxIceberg);
		}else {
			System.out.println(0);
			System.out.println(0);
		}
	}
	

	private static void getMaxIceberg() {
		for(int r=0; r<P; r++) {
			for(int c=0; c<P; c++) {
				if(!isVisited[r][c] && map[r][c] != 0) {
					bfs(r,c);
				}
			}	
		}
	}

	private static void bfs(int r, int c) {
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		int cnt = 1;
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] != 0) {
					isVisited[nr][nc] = true;
					queue.offer(new Node(nr, nc));
					cnt++;
				}
			}
		}
		if(maxIceberg < cnt) {
			maxIceberg = cnt;
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
	}
	
	private static void fireStorm() {
		temp = new int[P][P];
		int cnt;
		for(int r=0; r<P; r++) {
			for(int c=0; c<P; c++) {
				if(map[r][c] == 0) continue;
				temp[r][c] = map[r][c];
				cnt=0;
				for(int d=0; d<4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(!isIn(nr, nc)) {
						cnt++;
					}else if(map[nr][nc] == 0) {
						cnt++;
					}
				}
				if(cnt >= 2) {
					temp[r][c]--;
					remainIce--;
				}
			}	
		}
		for(int r=0; r<P; r++) {
			for(int c=0; c<P; c++) {
				map[r][c] = temp[r][c];
			}	
		}
	}

	private static void spinMap(int curR, int curC, int side) {
		int tr,tc;
		tr=0;
		for(int r=curR; r<curR+side; r++) {
			tc=0;
			for(int c=curC; c<curC+side; c++) {
				temp[tr][tc] = map[r][c];
				tc++;
			}	
			tr++;
		}
		tr=0;
		for(int r=curR; r<curR+side; r++) {
			tc=0;
			for(int c=curC; c<curC+side; c++) {
				map[r][c] = temp[side-1-tc][tr];
				tc++;
			}	
			tr++;
		}
	}

	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<P && c<P);
	}
	
	static int dr[] = {0,1,0,-1};
	static int dc[] = {-1,0,1,0};

	static String src =
			"3 10\r\n"
			+ "1 0 3 4 5 6 7 0\r\n"
			+ "8 0 6 5 4 3 2 1\r\n"
			+ "1 2 0 4 5 6 7 0\r\n"
			+ "8 7 6 5 4 3 2 1\r\n"
			+ "1 2 3 4 0 6 7 0\r\n"
			+ "8 7 0 5 4 3 2 1\r\n"
			+ "1 2 3 4 5 6 7 0\r\n"
			+ "0 7 0 5 4 3 2 1\r\n"
			+ "1 2 3 1 2 3 1 2 3 1";
}
