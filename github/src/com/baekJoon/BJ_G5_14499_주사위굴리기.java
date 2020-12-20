package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_14499_주사위굴리기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,x,y,K,map[][];
	static Queue<Integer> queue = new LinkedList<>();
	static Dice dice;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		x = Integer.parseInt(tokens.nextToken());
		y = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		// r, c, front, tail, up, down, left, right
		dice = new Dice(x, y, 0, 0, 0, 0, 0, 0);
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		tokens = new StringTokenizer(input.readLine());
		for(int k=0; k<K; k++) {
			queue.offer(Integer.parseInt(tokens.nextToken()));
		}// 입력 끝
		
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println(queue);
		
		run();
	}

	private static void run() {
		while(!queue.isEmpty()) {
			int dir = queue.poll()-1;
			
			int nr = dice.r + dr[dir];
			int nc = dice.c + dc[dir];
			if(isIn(nr, nc)) {
				dice.r = nr;
				dice.c = nc;
				switch (dir) {
				case 0: // 동
					rightDice();
					change(nr, nc);
					break;
				case 1: // 서
					leftDice();
					change(nr, nc);
					break;
				case 2: // 북
					upDice();
					change(nr, nc);
					break;
				case 3: // 남
					downDice();
					change(nr, nc);
					break;
				}
				System.out.println(dice.front);
			}
			
		}
	}
	private static void change(int nr, int nc) {
		if(map[nr][nc] == 0) {
			map[nr][nc] = dice.tail;
		}else {
			dice.tail = map[nr][nc];
			map[nr][nc] = 0;
		}		
	}

	private static void rightDice() {
		int temp = dice.left;
		dice.left = dice.tail;
		dice.tail = dice.right;
		dice.right = dice.front;
		dice.front = temp;
		
	}

	private static void leftDice() {
		int temp = dice.front;
		dice.front = dice.right;
		dice.right = dice.tail;
		dice.tail = dice.left;
		dice.left = temp;
	}

	private static void upDice() {
		int temp = dice.front;
		dice.front = dice.down;
		dice.down = dice.tail;
		dice.tail = dice.up;
		dice.up = temp;
	}

	private static void downDice() {
		int temp = dice.up;
		dice.up = dice.tail;
		dice.tail = dice.down;
		dice.down = dice.front;
		dice.front = temp;
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {1,-1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static class Dice {
		int r, c, front, tail, up, down, left, right;
		public Dice(int r, int c, int front, int tail, int up, int down, int left, int right) {
			super();
			this.r = r;
			this.c = c;
			this.front = front;
			this.tail = tail;
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Dice [r=" + r + ", c=" + c + ", front=" + front + ", tail=" + tail + ", up=" + up + ", down=" + down
					+ ", left=" + left + ", right=" + right + "]";
		}

	}
	
	static String src =
			"3 3 1 1 9\r\n" + 
			"1 2 3\r\n" + 
			"4 0 5\r\n" + 
			"6 7 8\r\n" + 
			"1 3 2 2 4 4 1 1 3";
}
