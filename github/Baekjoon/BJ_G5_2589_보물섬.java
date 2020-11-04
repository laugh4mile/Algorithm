package com.BackJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_2589_보물섬 {
	
	static int N,M,max=Integer.MIN_VALUE, cal[][];
	static char map[][];
	static StringTokenizer tokens;
	static boolean isVisited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[N][M];
		cal = new int[N][M];
		isVisited = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			String line = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = line.charAt(m);
			}
		}
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
//		bfs(0, 0);
//		for(int x[] : cal) {
//			System.out.println(Arrays.toString(x));
//		}
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m] == 'L') {
					bfs(n,m);
					getMax();
				}
			}
		}
		System.out.println(max);
		// 구현하세요.
		
		
//		return max; // 리턴값을 수정하세요
	} // end of execute
	
	static void getMax() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cal[i][j] > max) {
					max = cal[i][j];
				}
			}	
		}
	}
	
	private static void bfs(int x, int y) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				isVisited[i][j] = false;
				cal[i][j] = 0;
			}	
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			for(int d=0; d<4; d++) {
				int nx = front.x + dx[d];
				int ny = front.y + dy[d];
				
				if(isIn(nx, ny) && !isVisited[nx][ny] && map[nx][ny]=='L') {
					queue.offer(new Node(nx, ny));
					isVisited[nx][ny] = true;
					cal[nx][ny] = cal[front.x][front.y]+1;
				}
				
			}
		}
		
	}
	
	static boolean isIn (int x, int y) {
		return (x>=0 && y>=0 && x<N && y<M);
	}
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
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
			"5 7\r\n" + 
			"WLLWWWL\r\n" + 
			"LLLWLLL\r\n" + 
			"LWLWLWW\r\n" + 
			"LWLWLLL\r\n" + 
			"WLLWLWW\r\n" + 
			"";
} // end of class
