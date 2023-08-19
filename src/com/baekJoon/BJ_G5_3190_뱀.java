package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_3190_뱀 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, K, L, d=0, playTime, before;
	static boolean gameOver, body;
	static Queue<Move> queue = new LinkedList<>();
	static List<Node> list = new ArrayList<>();
	static Deque<Node> deque = new ArrayDeque<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		K = Integer.parseInt(input.readLine());
		for(int k=0; k<K; k++) { // 사과는 list에 담을거임
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken()) -1 ;
			int c = Integer.parseInt(tokens.nextToken()) -1 ;
			list.add(new Node(r, c));
		}
		L = Integer.parseInt(input.readLine());
		for(int l=0; l<L; l++) { // 이동 정보는 queue에 담을거임
			tokens = new StringTokenizer(input.readLine());
			int t = Integer.parseInt(tokens.nextToken());
			char dir = tokens.nextToken().charAt(0);
			int distance = t - before;
			before = t;
			queue.offer(new Move(distance, dir));
		}
		deque.offerFirst(new Node(0, 0)); // 처음 시작은 0,0 에서 시작
		d = 0; // 처음 방향은 0 (우)
		palygame();
		System.out.println(playTime);
	}
	private static void palygame() {
		int sr = 0;
		int sc = 0;
		while(!queue.isEmpty()) { // 
			Move front = queue.poll();
			char dir = front.d;
			int l = front.l;
			// 방향도 조절해야함
			sr = deque.getFirst().r;
			sc = deque.getFirst().c;
			
			if(d==0){ // 우
				go0(sr,sc,l,dir);// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			else if(d==1){ // 상
				go1(sr,sc,l,dir);// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			else if(d==2){ // 좌
				go2(sr,sc,l,dir);// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			else if(d==3){ // 하
				go3(sr,sc,l,dir);// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			if(gameOver) {
				break;
			}
		}
		if(!gameOver) {
			if(d==0){ // 우
				go0(sr,sc,N,'X');// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			else if(d==1){ // 상
				go1(sr,sc,N,'X');// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			else if(d==2){ // 좌
				go2(sr,sc,N,'X');// 시작r, 시작c, 이동할 거리, 다음 방향
			}
			else if(d==3){ // 하
				go3(sr,sc,N,'X');// 시작r, 시작c, 이동할 거리, 다음 방향
			}
		}
	}
	
	private static void go0(int sr, int sc, int l, char nextDir) {
		for(int i=1; i<=l; i++) {
			playTime++;
			int nc = sc + i;
			if(isIn(nc) && !isBreak(sr, nc)) {
				if(checkApple(sr,nc)) { // 사과가 있는 지점이라면 first만 추가
					deque.offerFirst(new Node(sr, nc));
				}else { // 사과가 없는 지점이라면 first 추가 후 last 삭제
					deque.offerFirst(new Node(sr, nc));
					deque.pollLast();
				}
			}else { // 범위를 벗어나거나 몸에 부딛힌다면
				gameOver = true;
				break;
			}
		}
		
		if(nextDir =='L') {
			d = 1;
		}else { // dir == 'D'
			d = 3;
		}
	}
	
	private static void go1(int sr, int sc, int l, char nextDir) {
		for(int i=1; i<=l; i++) {
			playTime++;
			int nr = sr - i;
			if(isIn(nr) && !isBreak(nr, sc)) {
				if(checkApple(nr,sc)) { // 사과가 있는 지점이라면 first만 추가
					deque.offerFirst(new Node(nr, sc));
				}else { // 사과가 없는 지점이라면 first 추가 후 last 삭제
					deque.offerFirst(new Node(nr, sc));
					deque.pollLast();
				}
			}else { // 범위를 벗어나거나 몸에 부딛힌다면
				gameOver = true;
				break;
			}
		}
		if(nextDir =='L') {
			d = 2;
		}else { // dir == 'D'
			d = 0;
		}
	}
	
	private static void go2(int sr, int sc, int l, char nextDir) {
		for(int i=1; i<=l; i++) {
			playTime++;
			int nc = sc - i;
			if(isIn(nc) && !isBreak(sr, nc)) {
				if(checkApple(sr,nc)) { // 사과가 있는 지점이라면 first만 추가
					deque.offerFirst(new Node(sr, nc));
				}else { // 사과가 없는 지점이라면 first 추가 후 last 삭제
					deque.offerFirst(new Node(sr, nc));
					deque.pollLast();
				}
			}else { // 범위를 벗어나거나 몸에 부딛힌다면
				gameOver = true;
				break;
			}
		}
		if(nextDir =='L') {
			d = 3;
		}else { // dir == 'D'
			d = 1;
		}
	}
	
	private static void go3(int sr, int sc, int l, char nextDir) {
		for(int i=1; i<=l; i++) {
			playTime++;
			int nr = sr + i;
			if(isIn(nr) && !isBreak(nr, sc)) {
				if(checkApple(nr,sc)) { // 사과가 있는 지점이라면 first만 추가
					deque.offerFirst(new Node(nr, sc));
				}else { // 사과가 없는 지점이라면 first 추가 후 last 삭제
					deque.offerFirst(new Node(nr, sc));
					deque.pollLast();
				}
			}else { // 범위를 벗어나거나 몸에 부딛힌다면
				gameOver = true;
				break;
			}
		}
		if(nextDir =='L') {
			d = 0;
		}else { // dir == 'D'
			d = 2;
		}
	}
	
	
	
	private static boolean checkApple(int r, int c) {
		boolean flag = false;
		int size = list.size();
		int deleteIndex = 0;
		for(int i=0; i<size; i++) {
			if(list.get(i).r == r && list.get(i).c == c) {
				flag = true;
				deleteIndex = i;
				break; // 더 볼 필요가 없음
			}
		}
		
		if(flag) { // r,c에 사과가 있다면 true 리턴
			list.remove(deleteIndex); // 먹은 사과는 리스트에서 삭제
			return true;
		}
		return false;
	}
	
	static boolean isBreak(int r, int c) {
		boolean flag = false; //
		int size = deque.size();
		for(int i=0; i<size; i++) {
			Node front = deque.poll();
			if(r==front.r && c==front.c) {
				flag = true;
			}
			deque.offer(front); // 다시 원상 복구 해야함 
		}
		if(flag) { // 만약 겹치는 놈이 있다 -> 내몸에 부딛힌다 -> true리턴
			body = true;
			return true;
		}
		return false;
	}
	
	static boolean isIn(int n) {
		return (n>=0 && n<N);
	}

	static class Node {
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
	static class Move{
		int l;
		char d;
		public Move(int l, char d) {
			super();
			this.l = l;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Move [l=" + l + ", d=" + d + "]";
		}
	}
	static String src =
			"10\r\n" + 
			"5\r\n" + 
			"1 5\r\n" + 
			"1 3\r\n" + 
			"1 2\r\n" + 
			"1 6\r\n" + 
			"1 7\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
}