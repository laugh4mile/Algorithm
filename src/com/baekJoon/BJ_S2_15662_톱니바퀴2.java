package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_15662_톱니바퀴2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,K, wheel[][];
	static boolean canSpin[];
	static Deque<Integer> dq[];
	static Queue<Oper> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		dq = new Deque[T];
		for (int i=0; i<T; i++) {
			dq[i] = new ArrayDeque<>();
		}
		wheel = new int[T][8];
		for(int i=0; i<T; i++) {
			String line = input.readLine();
			for(int j=0; j<8; j++) {
				dq[i].offer(line.charAt(j)-'0');
				wheel[i][j] = line.charAt(j)-'0';
			}
		}
		K = Integer.parseInt(input.readLine());
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int no = Integer.parseInt(tokens.nextToken())-1;
			int dir = Integer.parseInt(tokens.nextToken());
			queue.offer(new Oper(no, dir));
		}
		run();
		int result = 0;
		for(int i=0; i<dq.length; i++) {
			if(dq[i].peek() == 1) {
				result++;
			}
		}
		System.out.println(result);
	}
	private static void run() {
		while(!queue.isEmpty()) {
			canSpin = new boolean[T];
			Oper front = queue.poll();
			int dir = front.dir;
			int no = front.no;
			canSpin[no] = true;
			for(int i=no; i>0; i--) {
				if(wheel[i][6] != wheel[i-1][2]) {
					canSpin[i-1] = true;
				}else {
					break;
				}
			}
			for(int i=no; i<T-1; i++) {
				if(wheel[i][2] != wheel[i+1][6]) {
					canSpin[i+1] = true;
				}else {
					break;
				}
			}
			spin(no,dir);
		}
	}
	
	private static void spin(int no, int dir) {
		for(int i=0; i<T; i++) {
			if(canSpin[i]) {
				if(Math.abs(no - i)%2 == 0) { // dir과 같은방향
					if(dir == 1) { 
						Integer temp = dq[i].pollLast();
						dq[i].offerFirst(temp);
					}else { // 반시계방향
						Integer temp = dq[i].pollFirst();
						dq[i].offerLast(temp);
					}
				}else { // dir과 반대방향
					if(dir == 1) { 
						Integer temp = dq[i].pollFirst();
						dq[i].offerLast(temp);
					}else { // 반시계방향
						Integer temp = dq[i].pollLast();
						dq[i].offerFirst(temp);
					}
				}
			}
		}
		
		for(int i=0; i<T; i++) { // 톱니바퀴 돌리기 
			for(int j=0; j<8; j++) {
				int temp = dq[i].pollFirst();
				wheel[i][j] = temp;
				dq[i].offerLast(temp);
			}
		}
	}

	static class Oper{
		int no;
		int dir;
		public Oper(int no, int dir) {
			super();
			this.no = no;
			this.dir = dir;
		}
	}
	static String src =
			"5\r\n" + 
			"10010011\r\n" + 
			"01010011\r\n" + 
			"11100011\r\n" + 
			"01010101\r\n" + 
			"01010011\r\n" + 
			"10\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"3 1\r\n" + 
			"4 1\r\n" + 
			"1 -1\r\n" + 
			"2 -1\r\n" + 
			"3 -1\r\n" + 
			"4 -1\r\n" + 
			"5 1\r\n" + 
			"5 -1";
}
