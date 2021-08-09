package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_19238_스타트택시 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,fuel, passanger[][], destination[][], startR,startC,cur,plus;
	static boolean isVisited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		fuel = Integer.parseInt(tokens.nextToken());
		passanger = new int[N][N];
		destination = new int[N][N];
		isVisited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				int map = Integer.parseInt(tokens.nextToken());
				passanger[r][c] = map;
				destination[r][c] = map; // <- 여기가 문제인거 같다!!!!!!!!!!!!!!
			}	
		}
		tokens = new StringTokenizer(input.readLine());
		startR = Integer.parseInt(tokens.nextToken())-1;
		startC = Integer.parseInt(tokens.nextToken())-1;
		int cnt = 2;
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int pr = Integer.parseInt(tokens.nextToken())-1;
			int pc = Integer.parseInt(tokens.nextToken())-1;
			int dr = Integer.parseInt(tokens.nextToken())-1;
			int dc = Integer.parseInt(tokens.nextToken())-1;
			passanger[pr][pc] = cnt; 
			destination[dr][dc] = cnt++;
		} // 입력 끝
		
		boolean isFailed = false;
//		for(int x[] : passanger) {
//			System.out.println(Arrays.toString(x));
//		}
		for(int m=0; m<M; m++) {
			findPass(); // 가장 가까운 승객 찾기
			if(fuel<=0) {
				isFailed = true;
				break;
			}
			passanger[startR][startC] = 0;
			findDest(cur);
			if(destination[startR][startC] != cur) {
				isFailed = true;
				break;
			}
			if(fuel<0) break; // 0은 봐줌
			fuel += plus;
//			System.out.println(fuel);
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(passanger[r][c] > 1) {
					isFailed = true;
					break;
				}
			}	
		}
		if(isFailed) {
			System.out.println(-1);
		}else {
			System.out.println(fuel);
		}
	}
	private static void findDest(int cur) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				isVisited[r][c] = false;
			}	
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startR, startC, 0));
		isVisited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			if(destination[front.r][front.c] == cur) {
				startR = front.r;
				startC = front.c;
				fuel -= front.d;
				plus = front.d * 2;
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc] && destination[nr][nc] != 1) {
					isVisited[nr][nc] = true;
					queue.offer(new Node(nr, nc, front.d+1));
				}
			}
		}
		
	}
	
	private static void findPass() { // 가까운 승객 찾기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				isVisited[r][c] = false;
			}	
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(startR, startC, 0));
		isVisited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			if(passanger[front.r][front.c] > 1) {
				startR = front.r;
				startC = front.c;
				fuel -= front.d; // 연료 감소
				cur = passanger[front.r][front.c];
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				if(isIn(nr, nc) && !isVisited[nr][nc] && passanger[nr][nc] != 1) {
					isVisited[nr][nc] = true;
					queue.offer(new Node(nr, nc, front.d+1));
				}
			}
		}
		
	}
	static boolean isIn(int r, int c) {
		return(r>=0 && c>=0 && r<N && c<N);
	}
	static int dr[] = {-1,0,0,1}; // 상,좌,우,하 <- 순서 중요
	static int dc[] = {0,-1,1,0};
	static class Node{
		int r;
		int c;
		int d;
		public Node(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static String src =
			"6 5 19\r\n" + 
			"1 0 0 0 1 0\r\n" + 
			"1 0 1 0 1 0\r\n" + 
			"1 0 1 0 1 0\r\n" + 
			"1 0 1 0 1 0\r\n" + 
			"1 0 1 0 1 0\r\n" + 
			"0 0 1 0 0 0\r\n" + 
			"1 3\r\n" + 
			"6 1 1 6\r\n" + 
			"1 6 6 2\r\n" + 
			"5 2 2 4\r\n" + 
			"6 5 6 6\r\n" + 
			"4 6 1 2"; 
}
