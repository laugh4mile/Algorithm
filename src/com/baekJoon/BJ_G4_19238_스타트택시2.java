package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_19238_스타트택시2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,fuel, passanger[][], taxiR,taxiC,cur,plus;
	static boolean isVisited[][];
	static List<Node> dest = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		fuel = Integer.parseInt(tokens.nextToken());
		passanger = new int[N][N];
		isVisited = new boolean[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				int map = Integer.parseInt(tokens.nextToken());
				passanger[r][c] = map;
			}	
		}
		tokens = new StringTokenizer(input.readLine());
		taxiR = Integer.parseInt(tokens.nextToken())-1;
		taxiC = Integer.parseInt(tokens.nextToken())-1;
		int cnt = 2;
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int pr = Integer.parseInt(tokens.nextToken())-1;
			int pc = Integer.parseInt(tokens.nextToken())-1;
			int dr = Integer.parseInt(tokens.nextToken())-1;
			int dc = Integer.parseInt(tokens.nextToken())-1;
			passanger[pr][pc] = cnt; 
			dest.add(new Node(dr, dc, cnt++));
		} // 입력 끝

		boolean isFailed = false;
		System.out.println("초기 연료 : "+fuel);
		System.out.println();
		for(int m=0; m<M; m++) {
			findPass(); // 가장 가까운 승객 찾기
			System.out.println(fuel);
			if(fuel<=0) {
				isFailed = true;
				break;
			}
			passanger[taxiR][taxiC] = 0; // 해당 승객은 이제 제외함.
			
			findDest(cur); // cur = 승객 번호이자 도착번호
			System.out.println(fuel);
			if(fuel<0) { // 0은 봐줌
				isFailed = true;
				break; 
			}
			fuel += plus;
			plus = 0;
			System.out.println(fuel);
			System.out.println();
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(passanger[r][c] > 1) { // 승객이 남은 경우 실패이다.
					isFailed = true;
					break;
				}
			}	
		}
		System.out.println();
		if(isFailed || dest.size() > 0) { // 목적지가 남아도 실패이다.
			System.out.println(-1);
		}else {
			System.out.println(fuel);
		}
	}
	
	private static void findPass() { // 가까운 승객 찾기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				isVisited[r][c] = false;
			}	
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(taxiR, taxiC, 0));
		isVisited[taxiR][taxiC] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			if(passanger[front.r][front.c] > 1) { // 만약 승객을 발견하면
				taxiR = front.r; // 택시 위치 초기화
				taxiC = front.c; 
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
	
	private static void findDest(int cur) { // cur 승객의 목적지 찾기
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				isVisited[r][c] = false;
			}	
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(taxiR, taxiC, 0));
		isVisited[taxiR][taxiC] = true;
		
		outer : while(!queue.isEmpty()) {
			Node front = queue.poll();
			for(int i=0; i<dest.size(); i++) {
				if(front.r == dest.get(i).r && front.c == dest.get(i).c && dest.get(i).d == cur) {
					taxiR = front.r;
					taxiC = front.c;
					fuel -= front.d;
					plus = front.d * 2;
					dest.remove(i); // 해당 목적지는 삭제.
					break outer;
				}
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
			"6 3 2\r\n" + 
			"0 0 1 0 0 0\r\n" + 
			"0 0 1 0 0 0\r\n" + 
			"0 0 0 1 0 0\r\n" + 
			"0 0 0 1 0 0\r\n" + 
			"0 0 0 0 1 0\r\n" + 
			"0 0 0 1 0 0\r\n" + 
			"1 1\r\n" + 
			"1 1 1 2\r\n" + 
			"1 2 2 2\r\n" + 
			"2 2 2 3"; 
}
