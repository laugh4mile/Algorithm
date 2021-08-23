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
	static int channel[] = new int[1000001], N;
	static boolean keys[], isVisited[][] = new boolean[1000001][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		keys = new boolean[10]; // 0,1,2,3,4,5,6,7,8,9
		int b = Integer.parseInt(input.readLine());
		Arrays.fill(keys, true);
		Arrays.fill(channel,Integer.MAX_VALUE);
		
		if(b != 0) {
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<b; i++) {
				keys[Integer.parseInt(tokens.nextToken())] = false;
			}
		}
		
		bfs();
		System.out.println(channel[N]);
	}
	private static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(100, 0, true));
		isVisited[100][1] = true;
		for(int i=0; i<10; i++) {
			if(keys[i]) {
				queue.offer(new Node(i, 1, false));
				isVisited[i][0] = true;
			}
		}
		
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(front.num == N) {
				channel[front.num] = front.cnt;
				break;
			}
			if(channel[front.num] > front.cnt) {
				channel[front.num] = front.cnt;
			}
			if(!front.flag) {
				for(int i=0; i<10; i++) {
					if(keys[i]) {
						String str = Integer.toString(front.num) + i; 
						int next = Integer.parseInt(str);
						if(isIn(next) && !isVisited[next][0]) {
							isVisited[next][0] = true;
							queue.offer(new Node(next, front.cnt+1, false));
						}
					}
				}
			}
			if(isIn(front.num+1) && !isVisited[front.num+1][1]) {
				isVisited[front.num+1][1] = true;
				queue.offer(new Node(front.num+1, front.cnt+1, true));
			}
			if(front.num != 0 && !isVisited[front.num-1][1]) {
				isVisited[front.num-1][1] = true;
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
		return (num>=0 && num<1000001);
	}
	static String src =
			"101\r\n"
			+ "0\r\n"
			+ "1";
			
}