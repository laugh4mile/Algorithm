package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_7562_나이트의이동 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N, map[][], cnt[][];
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N][N];
			cnt = new int[N][N];
			isVisited = new boolean[N][N];
			
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = 1;
			
			tokens = new StringTokenizer(input.readLine());
			int gr = Integer.parseInt(tokens.nextToken());
			int gc = Integer.parseInt(tokens.nextToken());
			map[gr][gc] = 2;
			
//			for(int[] x : map) {
//				System.out.println(Arrays.toString(x));
//			}
//			System.out.println();
	
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					if(map[i][j] == 1) {
//						bfs(i,j);
//					}
//				}
//			}
			bfs(r,c);
			System.out.println(cnt[gr][gc]);
		}
		
		
	}
	private static void bfs(int r, int c) {
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(r, c));
		isVisited[r][c] = true;
		cnt[r][c] = 0;
		
		while(!queue.isEmpty()) {
			Dot front = queue.poll();
			if(map[front.x][front.y] ==2) {
				break;
			}
			
			for(int i=0; i<8; i++) {
				int nr = front.x + dx[i];
				int nc = front.y + dy[i];
				
				if(isIn(nr, nc) && !isVisited[nr][nc]) {
					queue.offer(new Dot(nr, nc));
					isVisited[nr][nc] = true;
					cnt[nr][nc] = cnt[front.x][front.y]+1;
				}
			}
		}
		
	}
	static int dx[] = {-1,-2,-2,-1,1,2,2,1};
	static int dy[] = {-2,-1,1,2,2,1,-1,-2};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static class Dot{
		int x;
		int y;
		public Dot(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static String src = "3\r\n" + 
			"8\r\n" + 
			"0 0\r\n" + 
			"7 0\r\n" + 
			"100\r\n" + 
			"0 0\r\n" + 
			"30 50\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"1 1";

}
