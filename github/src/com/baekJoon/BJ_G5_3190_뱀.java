package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_3190_뱀 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, K, map[][], L, dir=4, cnt; // dir 1:상 2:하 3:좌 4:우
	static boolean gameOver;
	static List<move> list = new ArrayList<>();
	static node head = new node(0, 0);
	static node tail = new node(0, 0);
	static Queue<node> queue = new LinkedList<>(); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader (new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		K = Integer.parseInt(input.readLine());
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int ax = Integer.parseInt(tokens.nextToken())-1;
			int ay = Integer.parseInt(tokens.nextToken())-1;
			map[ax][ay] = 2;
		}
		
		L = Integer.parseInt(input.readLine());
		for(int l=0; l<L; l++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			char d = tokens.nextToken().charAt(0);
			list.add(new move(s, d));
		}
		for(int x[]: map) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(list);
		
		
		queue.offer(new node(0, 0));
		
		for(int i=0; i<L; i++) {
			move(list.get(i).s);
			System.out.println("==================================");
			for(int x[]: map) {
				System.out.println(Arrays.toString(x));
			}
			System.out.println("==================================");
			if(gameOver) {
				break;
			}
			changeDir(i);
		}
		if(gameOver) {
			cnt++;
		}
		for(int x[]: map) {
			System.out.println(Arrays.toString(x));
		}
		System.out.println(cnt);
	}
	
	
	
	private static void move(int sec) {
		if(dir == 1) { // 방향 : ^
			
			int start	= (head.r-1);
			int end		= (head.r-sec);
			for(int i=start; i>=end; i--) {
				if(!isIn(i) || map[i][head.c] == 1) {
					gameOver = true;
					break;
				}else {
					cnt++;
					if(map[i][head.c] == 0) {
						map[i][head.c] = 1;
						head.r = i;
						map[tail.r][tail.c] = 0;
						tail.r--;
					}else { // 2
						map[i][head.c] = 1;
						head.r = i;
					}
					System.out.println("위쪽 ㄱㄱ : "+head);
				}
			}
		}else if(dir == 2) { // 방향 : v 
			int start	= (head.r+1);
			int end		= (head.r+sec);
			for(int i=start; i<=end; i++) {
				if(!isIn(i) || map[i][head.c] == 1) {
					gameOver = true;
					break;
				}else {
					cnt++;
					if(map[i][head.c] == 0) {
						map[i][head.c] = 1;
						head.r = i;
						map[tail.r][tail.c] = 0;
						tail.r++;
					}else { // 2
						map[i][head.c] = 1;
						head.r = i;
					}
					System.out.println("아래쪽 ㄱㄱ : "+head);
				}
			}
		}else if(dir == 3) { // 방향 : < 
			int start	= (head.c-1);
			int end		= (head.c-sec);
			for(int i=start; i>=end; i++) {
				if(!isIn(i) || map[head.r][i] == 1) {
					gameOver = true;
					break;
				}else {
					cnt++;
					if(map[head.r][i] == 0) {
						map[head.r][i] = 1;
						head.c = i;
						map[tail.r][tail.c] = 0;
						tail.c--;
					}else { // 2
						map[head.r][i] = 1;
						head.c = i;
					}
					System.out.println("왼쪽 ㄱㄱ : "+head);
				}
			}
		}else if(dir == 4) { // 방향 : >
			int start	= (head.c+1);
			int end		= (head.c+sec);
			for(int i=start; i<=end; i++) {
				if(!isIn(i) || map[head.r][i] == 1) {
					gameOver = true;
					break;
				}else {
					cnt++;
					if(map[head.r][i] == 0) {
						System.out.println(head.r + " " + i);
						map[head.r][i] = 1;
						head.c = i;
						System.out.println("tail : "+ tail);
						map[tail.r][tail.c] = 0;
						tail.c = (tail.c + 1);
					}else { // 2
						map[head.r][i] = 1;
						head.c = i;
					}
					System.out.println("오른쪽 ㄱㄱ : "+head);
				}
			}
		}
	}

	static boolean isIn (int x) {
		return (x>=0 && x<N);
	}

	private static void changeDir(int i) {
		char direction = list.get(i).d;
		if(direction == 'L'){ // 왼쪽으로 턴
			if(dir == 1) { // 이전방향 : ^
				dir = 3;
			}else if(dir == 2) { // 이전방향 : v 
				dir = 4;
			}else if(dir == 3) { // 이전방향 : < 
				dir = 2;
			}else if(dir == 4) { // 이전방향 : >
				dir = 1;
			}
		}else { // 오른쪽으로 턴
			if(dir == 1) { // 이전방향 : ^
				dir = 4;
			}else if(dir == 2) { // 이전방향 : v 
				dir = 3;
			}else if(dir == 3) { // 이전방향 : < 
				dir = 1;
			}else if(dir == 4) { // 이전방향 : >
				dir = 2;
			}
		}
	}
	static class node{
		int r;
		int c;
		public node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "node [r=" + r + ", c=" + c + "]";
		}
		
	}

	static class move{
		int s;
		char d;
		
		public move(int s, char d) {
			super();
			this.s = s;
			this.d = d;
		}

		@Override
		public String toString() {
			return "dir [s=" + s + ", d=" + d + "]";
		}
	}
	
	static String src =
			"10\r\n" + 
			"4\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"1 5\r\n" + 
			"4\r\n" + 
			"8 D\r\n" + 
			"10 D\r\n" + 
			"11 D\r\n" + 
			"13 L";
}