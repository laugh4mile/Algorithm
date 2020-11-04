package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BJ_G5_10026_적록색약 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N,cnt1,cnt2;
	static boolean isVisited[][];
	static char map[][],map2[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new char [N][N];
		map2 = new char [N][N];
		isVisited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String line = input.readLine();
			map[i] = line.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map2[i][j] = map[i][j];
				if(map[i][j] == 'R') {
					map2[i][j] = 'G';
				}
			}	
		}
		
//		for(char[] x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isVisited[i][j]) {
					bfs(i,j,map);
					cnt1++;
				}
			}	
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				isVisited[r][c] = false;
			}	
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isVisited[i][j]) {
					bfs(i,j,map2);
					cnt2++;
				}
			}	
		}
		System.out.print(cnt1+ " ");
		System.out.print(cnt2);
		
		
	}
	private static void bfs(int i, int j, char [][]map) {
//		for(int r=0; r<N; r++) {
//			for(int c=0; c<N; c++) {
//				isVisited[r][c] = false;
//			}	
//		}
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(i, j));
		isVisited[i][j] = true;
		
		while(!queue.isEmpty()) {
			Dot front = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = front.r + dx[d];
				int nc = front.c + dy[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[front.r][front.c]) {
					queue.offer(new Dot(nr, nc));
					isVisited[nr][nc] = true;
				}
				
			}
			
		}
		
	}
	
	static class Dot{
		int r;
		int c;
		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	static String src ="5\r\n" + 
			"RRRBB\r\n" + 
			"GGBBB\r\n" + 
			"BBBRR\r\n" + 
			"BBRRR\r\n" + 
			"RRRRR";
}
