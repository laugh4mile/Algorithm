package com.JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO_1733_오목 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int map[][], N = 19, cnt;
	static boolean isVisited[][], flag,over;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		map = new int [N][N];
		isVisited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());	
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken()); 
			}	
		}
		
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] != 0) {
					bfs1(r,c);
					bfs2(r,c);
					bfs3(r,c);
					bfs4(r,c);
					for(int i=0; i<N; i++) {
						for(int j=0; j<N; j++) {
							isVisited[i][j] = false;
						}
					}
				}
			}	
		}
		if(!flag) {
			System.out.println(0);
		}
	}
	private static void bfs1(int r, int c) { // 오른쪽
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			int nr = front.x + dx[0];
			int nc = front.y + dy[0];
			
			if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
				queue.offer(new Node(nr, nc));
				isVisited[nr][nc] = true;
				cnt++;
			}
		}
		
		if(cnt == 4) {
			if(isIn(r, c-1) && map[r][c-1]==map[r][c] ) {
				over = true;
			}else if(isIn(r, c+5) && map[r][c+5]==map[r][c]) {
				over = true;
			}
			if(!over) {
				System.out.println(map[r][c]);
				System.out.printf("%d %d",r+1,c+1);
				flag = true;
			}
			over = false;
		}
		cnt = 0;
		
	}
	
	private static void bfs2(int r, int c) { // 아래
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			int nr = front.x + dx[1];
			int nc = front.y + dy[1];
			
			if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
				queue.offer(new Node(nr, nc));
				isVisited[nr][nc] = true;
				cnt++;
			}
		}
		if(cnt == 4) {
			if(isIn(r-1, c) && map[r-1][c]==map[r][c] ) {
				over = true;
			}else if(isIn(r+5, c) && map[r+5][c]==map[r][c]) {
				over = true;
			}
			
			if(!over) {
				System.out.println(map[r][c]);
				System.out.printf("%d %d",r+1,c+1);
				flag = true;
			}
			over = false;
		}
		cnt = 0;
	}
	
	private static void bfs3(int r, int c) { // 오른쪽 아래
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			int nr = front.x + dx[2];
			int nc = front.y + dy[2];
			
			if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
				queue.offer(new Node(nr, nc));
				isVisited[nr][nc] = true;
				cnt++;
			}
		}
		
		if(cnt == 4) {
			if(isIn(r-1, c-1) && map[r-1][c-1]==map[r][c] ) {
				over = true;
			}else if(isIn(r+5, c+5) && map[r+5][c+5]==map[r][c]) {
				over = true;
			}
			
			if(!over) {
				System.out.println(map[r][c]);
				System.out.printf("%d %d",r+1,c+1);
				flag = true;
			}
			over = false;
		}
		cnt = 0;
		
	}
	
	private static void bfs4(int r, int c) { // 오른쪽 위
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			int nr = front.x + dx[3];
			int nc = front.y + dy[3];
			
			if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
				queue.offer(new Node(nr, nc));
				isVisited[nr][nc] = true;
				cnt++;
			}
		}
		
		if(cnt == 4) {
			if(isIn(r+1, c-1) && map[r+1][c-1]==map[r][c] ) {
				over = true;
			}else if(isIn(r-5, c+5) && map[r-5][c+5]==map[r][c]) {
				over = true;
			}
			
			if(!over) {
				System.out.println(map[r][c]);
				System.out.printf("%d %d",r+1,c+1);
				flag = true;
			}
			over = false;
		}
		cnt = 0;
		
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static int[] dx = {0,1,1,-1};
	static int[] dy = {1,0,1,1};
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;	
		}
	}
	
	static String src = 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 2 1 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
}