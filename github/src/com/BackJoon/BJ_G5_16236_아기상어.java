package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_16236_아기상어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,map[][],shark = 2, cnt, move[][],eatCnt,shX,shY;
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		move = new int[N][N];
		isVisited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j] == 9) {
					shX = i;
					shY = j;
					map[i][j] = 0; // 아기상어의 위치를 기억해둔 후 0으로 바꿈
				}
			}	
		}
//		for(int []x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		if(!havefish()) { // 생선이 없다면 0
			System.out.println(0);
		}else {
			if(!canEat()) { // 생선이 있어도 shark보다 큰것만 있으면 0
				System.out.println(0);
			}else { // 먹을수 있는 생선이 존재하는 경우
				for(int i=0; i<N*N; i++) {
					
					bfs(shX,shY);
				}
//				dfs(shX,shY);
				for(int []x : map) {
					System.out.println(Arrays.toString(x));
				}
				System.out.println(cnt);
			}
		}
	}
	
	static void bfs(int x, int y){
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				isVisited[i][j] = false;
				move[i][j] = 0;
			}	
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		isVisited[x][y] = true;
		
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(map[front.x][front.y]!=0 && map[front.x][front.y] < shark) { // 탐색지점이 빈칸이 아니고(물고기) 아기상어보다 작으면
				map[front.x][front.y] = 0; // 먹은 자리는 0이됨
				eatCnt++; // 먹은 횟수++
				cnt += move[front.x][front.y];
				if(eatCnt == shark) {
					shark++;
					eatCnt = 0;
				}
				shX = front.x;
				shY = front.y;
				break;
			}
			
			for(int d=0; d<4; d++) {
				int nx = front.x + dx[d];
				int ny = front.y + dy[d];
				if(isIn(nx, ny) && !isVisited[nx][ny] &&map[nx][ny] <= shark) {
					queue.offer(new Node(nx, ny));
					isVisited[nx][ny] = true;
					if(map[nx][ny]==0 || map[nx][ny] == front.w) {
						
					}
					move[nx][ny] = move[front.x][front.y]+1;
				}
			}
		}
	}
	
	static class Fish implements Comparable<Fish> {
		int r,c;
		int dist;
		public Fish(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		// 1순위 거리, 2순위 r, 3순위 c
		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.r == o.r) {
					return Integer.compare(this.c, o.c);
				}else {
					return Integer.compare(this.r, o.r);
				}
			}else {
				return Integer.compare(this.dist, o.dist);
			}
		}
		
	}
	
//	private static void dfs(int x, int y) {
//	int eatCnt = 0;
//	isVisited[x][y] = true;
//	
//	cnt++;
//	if(map[x][y]!=0 && map[x][y] < shark) { // 탐색지점이 빈칸이 아니고(물고기) 아기상어보다 작으면
//		map[x][y] = 0; // 먹어 버렷
//		eatCnt++;
//		if(eatCnt == shark) {
//			shark++;
//		}
//	}			
//	for(int d=0; d<4; d++) {
//		int nx = x + dx[d];
//		int ny = y + dy[d];
//		if(isIn(nx, ny) && !isVisited[nx][ny] &&map[nx][ny] <= shark) {
//			isVisited[nx][ny] = true;;
//			dfs(nx, ny);
//		}
//	}
//}
	
	
	static class Node { // bfs에 쓸 queue에 저장할 좌표를 Node라는 클래스로 조질거임
		int x;
		int y;
		int w = x*N + y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static boolean canEat() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] < shark) { // shark 보다 작은게 있으면 먹을게 있는거임
					return true;
				}
			}	
		}
		return false;
	}
	
	static boolean isIn(int x, int y) { // x,y 가 map의 범위안에 있는지 체크
		return (x>=0 && y>=0 && x<N && y<N);
	}
	
	static int dx[] = {-1,0,0,1}; // 4방탐색을 위한 x 좌표
	static int dy[] = {0,-1,1,0}; // 4방탐색을 위한 y 좌표
	
	static boolean havefish() { // 물고기가 존재하는지 검사.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0 && map[i][j] != 9) { // 0이나 9가 아닌게 하나라도 있으면 생선이 존재하는거임
					return true;
				}
			}	
		}
		return false;
	}
	
	static String src = 
			"6\r\n" + 
			"1 1 1 1 1 1\r\n" + 
			"2 2 6 2 2 3\r\n" + 
			"2 2 5 2 2 3\r\n" + 
			"2 2 2 4 6 3\r\n" + 
			"0 0 0 0 0 6\r\n" + 
			"0 0 0 0 0 9";
}
