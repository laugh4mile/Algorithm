package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_1719_택배 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static boolean isVisited[];
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new List[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int val = Integer.parseInt(tokens.nextToken());
			graph[from].add(new Node(to, val));
			graph[to].add(new Node(from, val));
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				bfs(i,j);
			}	
		}
	}
	
	private static void bfs(int start, int end) {
		int sum = 0, min = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int front = queue.poll();
			
			List<Node> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Node child = childs.get(i);
				
			}
		}
	}
	
	static class Node{
		int point;
		int value;
		public Node(int point, int value) {
			super();
			this.point = point;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [point=" + point + ", value=" + value + "]";
		}
	}

	static String src =
			"6 10\r\n" + 
			"1 2 2\r\n" + 
			"1 3 1\r\n" + 
			"2 4 5\r\n" + 
			"2 5 3\r\n" + 
			"2 6 7\r\n" + 
			"3 4 4\r\n" + 
			"3 5 6\r\n" + 
			"3 6 7\r\n" + 
			"4 6 4\r\n" + 
			"5 6 2";
}
