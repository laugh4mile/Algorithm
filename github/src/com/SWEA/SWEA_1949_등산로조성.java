package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.SWEA.SWEA_1949_등산로조성.Node;
	
/**
 * @author yhs
 * @date 2020. 12. 2
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 1) 최고점에서 시작해야한다는점
 * 2) 한곳 한정 0~K만큼 깎을수 있다
 * 3) 등산로가 0이 되도 된다
 * [입력사항]
 * [출력사항]
 */

public class SWEA_1949_등산로조성 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,K,map[][], max = Integer.MIN_VALUE;
	static boolean isVisited[][], flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			map = new int[N][N];
			isVisited = new boolean[N][N];
			int startR = 0;
			int startC = 0;
			int top = 0;
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c] > top) {
						top = map[r][c];
					}
				}	
			}
			
			int result = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c] == top) {
//						System.out.println(top);
//						bfs(r,c);
						isVisited[r][c] = true;
						dfs(r, c, 1);
						if(max > result) {
							result = max;
						}
						resetArr(isVisited);
					}
				}
			}
			
//			for(int x[] : map) {
//				System.out.println(Arrays.toString(x));
//			}
			System.out.println("#"+t+" "+result);
			max = 0;
		}
	}
	
	private static void resetArr(boolean[][] isVisited) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				isVisited[r][c] = false;
			}	
		}
	}

	private static void dfs(int r, int c, int cnt) {
		if(cnt > max) {
			max = cnt;
		}
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isIn(nr, nc) && !isVisited[nr][nc]) {
				if(map[nr][nc] < map[r][c]) {
					isVisited[nr][nc] = true;
					dfs(nr, nc, cnt+1);
					isVisited[nr][nc] = false;
				}else if(!flag && map[nr][nc] - K < map[r][c]) {
					flag = true;
					int temp = map[nr][nc];
					map[nr][nc] = map[r][c]-1;
					isVisited[nr][nc] = true;
					dfs(nr, nc, cnt+1);
					isVisited[nr][nc] = false;
					map[nr][nc] = temp;
					flag = false;
				}
			}
		}
		
	}
	
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c));
		isVisited[r][c] = true;
		boolean flag = false; 
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc]) {
					if(map[nr][nc] < map[front.r][front.c]) {
						queue.add(new Node(nr, nc));
						isVisited[nr][nc] = true;
					}else if(!flag && map[nr][nc] - K < map[front.r][front.c]) {
						flag = true;
						map[nr][nc] = map[front.r][front.c]-1;
						queue.add(new Node(nr, nc));
					}
				}
			}
		}
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
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}

	static String src =
			"10\r\n" + 
	
			"5 1\r\n" + 
			"9 3 2 3 2\r\n" + 
			"6 3 1 7 5\r\n" + 
			"3 4 8 9 9\r\n" + 
			"2 3 7 7 7\r\n" + 
			"7 6 5 5 8\r\n" + 
			
			"3 2\r\n" + 
			"1 2 1\r\n" + 
			"2 1 2\r\n" + 
			"1 2 1\r\n" + 
			
			"5 2\r\n" + 
			"9 3 2 3 2\r\n" + 
			"6 3 1 7 5\r\n" + 
			"3 4 8 9 9\r\n" + 
			"2 3 7 7 7\r\n" + 
			"7 6 5 5 8\r\n" + 
			
			"4 4\r\n" + 
			"8 3 9 5\r\n" + 
			"4 6 8 5\r\n" + 
			"8 1 5 1\r\n" + 
			"4 9 5 5\r\n" + 
			
			"4 1\r\n" + 
			"6 6 1 7\r\n" + 
			"3 6 6 1\r\n" + 
			"2 4 2 4\r\n" + 
			"7 1 3 4\r\n" + 
			
			"5 5\r\n" + 
			"18 18 1 8 18\r\n" + 
			"17 7 2 7 2\r\n" + 
			"17 8 7 4 3\r\n" + 
			"17 9 6 5 16\r\n" + 
			"18 10 17 13 18\r\n" + 
			
			"6 4\r\n" + 
			"12 3 12 10 2 2\r\n" + 
			"13 7 13 3 11 6\r\n" + 
			"2 2 6 5 13 9\r\n" + 
			"1 12 5 4 10 5\r\n" + 
			"11 10 12 8 2 6\r\n" + 
			"13 13 7 4 11 7\r\n" + 
			
			"7 3\r\n" + 
			"16 10 14 14 15 14 14\r\n" + 
			"15 7 12 2 6 4 9\r\n" + 
			"10 4 11 4 6 1 1\r\n" + 
			"16 4 1 1 13 9 14\r\n" + 
			"3 12 16 14 8 13 9\r\n" + 
			"3 4 17 15 12 15 1\r\n" + 
			"6 6 13 6 6 17 12\r\n" + 
			
			"8 5\r\n" + 
			"2 3 4 5 4 3 2 1\r\n" + 
			"3 4 5 6 5 4 3 2\r\n" + 
			"4 5 6 7 6 5 4 3\r\n" + 
			"5 6 7 8 7 6 5 4\r\n" + 
			"6 7 8 9 8 7 6 5\r\n" + 
			"5 6 7 8 7 6 5 4\r\n" + 
			"4 5 6 7 6 5 4 3\r\n" + 
			"3 4 5 6 5 4 3 2\r\n" + 
			
			"8 2\r\n" + 
			"5 20 15 11 1 17 10 14\r\n" + 
			"1 1 11 16 1 14 7 5\r\n" + 
			"17 2 3 4 5 13 19 20\r\n" + 
			"6 18 5 16 6 7 8 5\r\n" + 
			"10 4 5 4 9 2 10 16\r\n" + 
			"2 7 16 5 8 9 10 11\r\n" + 
			"12 19 18 8 7 11 15 12\r\n" + 
			"1 20 18 17 16 15 14 13";
}
