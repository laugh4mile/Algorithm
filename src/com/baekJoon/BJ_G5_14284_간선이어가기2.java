package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_14284_간선이어가기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int n, m, s, t, distance[];
	static List<Node> graph[];
	static boolean isVisited[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		
		isVisited = new boolean[n+1];
		distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		graph = new List[n+1];
		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		tokens = new StringTokenizer(input.readLine());
		s = Integer.parseInt(tokens.nextToken());
		t = Integer.parseInt(tokens.nextToken());
		
		dijkstra(s);
		
//		System.out.println(Arrays.toString(distance));
		System.out.println(distance[t]);
	}
	
	private static void dijkstra(int start) {
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			if(!isVisited[front.node]) {
				isVisited[front.node] = true;
				List<Node> childs = graph[front.node];
				for(int i=0; i<childs.size(); i++) {
					Node child = childs.get(i);
					if(distance[child.node] > distance[front.node]+child.val) {
						distance[child.node] = distance[front.node]+child.val;
						pq.offer(new Node(child.node, distance[child.node]));
					}
				}
			}
			
		}
	}
	
	static class Node implements Comparable<Node>{
		int node;
		int val;
		
		public Node(int node, int val) {
			super();
			this.node = node;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Node [node=" + node + ", val=" + val + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.val, o.val);
		}
	}
	static String src =
			"8 9\r\n" + 
			"1 2 3\r\n" + 
			"1 3 2\r\n" + 
			"1 4 4\r\n" + 
			"2 5 2\r\n" + 
			"3 6 1\r\n" + 
			"4 7 3\r\n" + 
			"5 8 6\r\n" + 
			"6 8 2\r\n" + 
			"7 8 7\r\n" + 
			"1 8";
}
