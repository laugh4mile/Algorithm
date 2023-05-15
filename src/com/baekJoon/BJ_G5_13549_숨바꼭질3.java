package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_13549_숨바꼭질3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		isVisited = new boolean[200001];
		
		bfs(N);
	}

	private static void bfs(int n) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(n, 0));
		isVisited[n] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			
			if(front.num == K) {
				System.out.println(front.cnt);
				return;
			}
			if(isIn(front.num*2) && !isVisited[front.num * 2]) {
				queue.offer(new Node(front.num * 2, front.cnt));
				isVisited[front.num * 2] = true;
			}
			if(isIn(front.num-1) && !isVisited[front.num-1]) {
				queue.offer(new Node(front.num-1, front.cnt+1));
				isVisited[front.num-1] = true;
			}
			if(isIn(front.num+1) && !isVisited[front.num+1]) {
				queue.offer(new Node(front.num+1, front.cnt+1));
				isVisited[front.num+1] = true;
			}
		}
	}

	static boolean isIn(int n) {
		return (n>=0 && n<100001);
	}
	
	static class Node{
		int num;
		int cnt;
		public Node(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}
	
	static String src =
			"0 2";
}