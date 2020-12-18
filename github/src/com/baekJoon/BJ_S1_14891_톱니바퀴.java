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

public class BJ_S1_14891_톱니바퀴 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int K, wheel[][];
	static Deque<Integer> dq[] = new Deque[4];
	static Queue<Oper> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		for (int i=0; i<4; i++) {
			dq[i] = new ArrayDeque<>();
		}
		wheel = new int[4][8];
		for(int i=0; i<4; i++) {
			String line = input.readLine();
			for(int j=0; j<8; j++) {
				dq[i].offer(line.charAt(j)-'0');
				wheel[i][j] = line.charAt(j)-'0';
			}
		}
		K = Integer.parseInt(input.readLine());
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int no = Integer.parseInt(tokens.nextToken());
			int dir = Integer.parseInt(tokens.nextToken());
			queue.offer(new Oper(no, dir));
		}
		run();
		System.out.println(dq[0].poll()+dq[1].poll()*2+dq[2].poll()*4+dq[3].poll()*8);
	}
	private static void run() {
		while(!queue.isEmpty()) {
			Oper front = queue.poll();
			int dir = front.dir;
			switch (front.no) { // 몇번 톱니바퀴가 선택되었는가?
			case 1: // 첫번째 톱니바퀴를 돌릴경우
				if(dir == 1) { 
					Integer temp = dq[0].pollLast();
					dq[0].offerFirst(temp);
				}else { // 반시계방향
					Integer temp = dq[0].pollFirst();
					dq[0].offerLast(temp);
				}
				if(wheel[0][2] != wheel[1][6]) { // ㄱ 
					if(dir == 1) {
						Integer temp = dq[1].pollFirst(); //반시계방향
						dq[1].offerLast(temp);
					}else { 
						Integer temp = dq[1].pollLast(); //시계방향
						dq[1].offerFirst(temp);
					}
					if(wheel[1][2] != wheel[2][6]) { // ㄴ
						if(dir == 1) { // 시계방향
							Integer temp = dq[2].pollLast();
							dq[2].offerFirst(temp);
						}else { // 반시계방향
							Integer temp = dq[2].pollFirst();
							dq[2].offerLast(temp);
						}
						if(wheel[2][2] != wheel[3][6]) { // ㄷ
							if(dir == 1) { // 시계방향 이면 반시계방향
								Integer temp = dq[3].pollFirst();
								dq[3].offerLast(temp);
							}else { // 반시계방향 이면 시계방향
								Integer temp = dq[3].pollLast();
								dq[3].offerFirst(temp);
							}
						}
					}	
				}
				break;
			case 2:
				if(dir == 1) { // 시계방향
					Integer temp = dq[1].pollLast(); //시계방향
					dq[1].offerFirst(temp);
				}else { // 반시계방향
					Integer temp = dq[1].pollFirst(); //반시계방향
					dq[1].offerLast(temp);
				}
				if(wheel[0][2] != wheel[1][6]) { // ㄱ
					if(dir == 1) { // 시계방향
						Integer temp = dq[0].pollFirst(); //반시계방향
						dq[0].offerLast(temp);
					}else { // 반시계방향
						Integer temp = dq[0].pollLast(); //시계방향
						dq[0].offerFirst(temp);
					}
				}
				if(wheel[1][2] != wheel[2][6]) { // ㄴ
					if(dir == 1) { // 시계방향
						Integer temp = dq[2].pollFirst(); //반시계방향
						dq[2].offerLast(temp);
					}else { // 반시계방향
						Integer temp = dq[2].pollLast(); //시계방향
						dq[2].offerFirst(temp);
					}
					if(wheel[2][2] != wheel[3][6]) { // ㄷ
						if(dir == 1) { 
							Integer temp = dq[3].pollLast(); //시계방향
							dq[3].offerFirst(temp);
						}else {
							Integer temp = dq[3].pollFirst();  //반시계방향
							dq[3].offerLast(temp);
						}
					}
				}
				
				break;
			case 3:
				if(dir == 1) { // 시계방향
					Integer temp = dq[2].pollLast(); //시계방향
					dq[2].offerFirst(temp);
				}else { // 반시계방향
					Integer temp = dq[2].pollFirst(); //반시계방향
					dq[2].offerLast(temp);
				}
				if(wheel[2][2] != wheel[3][6]) { // ㄷ
					if(dir == 1) { 
						Integer temp = dq[3].pollFirst();  //반시계방향
						dq[3].offerLast(temp);
					}else {
						Integer temp = dq[3].pollLast(); //시계방향
						dq[3].offerFirst(temp);
					}
				}
				if(wheel[1][2] != wheel[2][6]) { // ㄴ
					if(dir == 1) { 
						Integer temp = dq[1].pollFirst();  //반시계방향
						dq[1].offerLast(temp);
					}else {
						Integer temp = dq[1].pollLast(); //시계방향
						dq[1].offerFirst(temp);
					}
					if(wheel[0][2] != wheel[1][6]) { // ㄱ
						if(dir == 1) { 
							Integer temp = dq[0].pollLast(); //시계방향
							dq[0].offerFirst(temp);
						}else {
							Integer temp = dq[0].pollFirst();  //반시계방향
							dq[0].offerLast(temp);
						}
					}
				}
				
				break;
			case 4:
				if(dir == 1) { // 시계방향
					Integer temp = dq[3].pollLast(); //시계방향
					dq[3].offerFirst(temp);
				}else { // 반시계방향
					Integer temp = dq[3].pollFirst(); //반시계방향
					dq[3].offerLast(temp);
				}
				if(wheel[2][2] != wheel[3][6]) { // ㄷ
					if(dir == 1) { 
						Integer temp = dq[2].pollFirst();  //반시계방향
						dq[2].offerLast(temp);
					}else {
						Integer temp = dq[2].pollLast(); //시계방향
						dq[2].offerFirst(temp);
					}
					if(wheel[1][2] != wheel[2][6]) { // ㄴ
						if(dir == 1) { 
							Integer temp = dq[1].pollLast(); //시계방향
							dq[1].offerFirst(temp);
						}else {
							Integer temp = dq[1].pollFirst();  //반시계방향
							dq[1].offerLast(temp);
						}
						if(wheel[0][2] != wheel[1][6]) { // ㄱ
							if(dir == 1) { 
								Integer temp = dq[0].pollFirst();  //반시계방향
								dq[0].offerLast(temp);
							}else {
								Integer temp = dq[0].pollLast(); //시계방향
								dq[0].offerFirst(temp);
							}
						}
					}
				}
				break;
			}
			for(int i=0; i<4; i++) { // 톱니바퀴 돌리기 
				for(int j=0; j<8; j++) {
					int temp = dq[i].pollFirst();
					wheel[i][j] = temp;
					dq[i].offerLast(temp);
				}
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
			"10001011\r\n" + 
			"10000011\r\n" + 
			"01011011\r\n" + 
			"00111101\r\n" + 
			"5\r\n" + 
			"1 1\r\n" + 
			"2 1\r\n" + 
			"3 1\r\n" + 
			"4 1\r\n" + 
			"1 -1";
}
