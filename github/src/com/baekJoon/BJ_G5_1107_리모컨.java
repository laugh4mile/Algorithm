package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_1107_리모컨 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int channel[] = new int[1000000], N;
	static boolean keys[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		keys = new boolean[10]; // 0,1,2,3,4,5,6,7,8,9
		int b = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		Arrays.fill(keys, true);
		Arrays.fill(channel,Integer.MAX_VALUE);
		for(int i=0; i<b; i++) {
			keys[Integer.parseInt(tokens.nextToken())] = false;
		}
		if(N == 0) {
			System.out.println(1);
		}else if(N == 100) {
			System.out.println(0);
		}else {
//			bfs();
			System.out.println(channel[N]);
		}
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 1, false));
		queue.offer(new Node(100, 0, true));
		channel[100] = 0;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(front.num == N) {
				channel[front.num] = front.cnt;
				break;
			}
			if(channel[front.num] >= front.cnt) {
				channel[front.num] = front.cnt;
			}else {
				continue;
			}
			if(!front.flag) {
				for(int i=0; i<10; i++) {
					if(keys[i]) {
						String str = Integer.toString(front.num) + i; 
						int next = Integer.parseInt(str);
//						System.out.println(next);
						if(isIn(next)) {
							queue.offer(new Node(next, front.cnt+1, false));
						}
					}
				}
			}
			if(isIn(front.num+1)) {
				queue.offer(new Node(front.num+1, front.cnt+1, true));
			}
			if(front.num != 0) {
				queue.offer(new Node(front.num-1, front.cnt+1, true));
			}
		}
	}
	static class Node{
		int num;
		int cnt;
		boolean flag;
		public Node(int num, int cnt, boolean flag) {
			super();
			this.num = num;
			this.cnt = cnt;
			this.flag = flag;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", cnt=" + cnt + ", flag=" + flag + "]";
		}
	}
	static boolean isIn(int num) {
		return (num>=0 && num<1000000);
	}
	static String src =
			"11\r\n"
			+ "8\r\n"
			+ "0 2 3 4 6 7 8 9";
}
