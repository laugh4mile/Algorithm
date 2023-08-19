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

public class BJ_G4_1939_중량제한 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,limit[];
	static boolean isVisited[];
	static List<Node> graph[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		limit = new int[N+1];
		isVisited = new boolean[N+1];
		graph = new List[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		Arrays.fill(limit, Integer.MIN_VALUE);
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		tokens = new StringTokenizer(input.readLine());
		int start = Integer.parseInt(tokens.nextToken());
		int end = Integer.parseInt(tokens.nextToken());
		if(start == end) {
			System.out.println(0);
		}else {
			System.out.println(dijkstra(start,end));
		}
	}
	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		limit[start] = Integer.MAX_VALUE;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			if(!isVisited[front.point]) {
				isVisited[front.point] = true;
				List<Node> childs = graph[front.point];
				for(int i=0; i<childs.size(); i++) {
					Node child = childs.get(i);
					if(!isVisited[child.point] && limit[child.point] < child.weight) {
						limit[child.point] = child.weight;
						if(limit[child.point] > limit[front.point]) {
							limit[child.point] = limit[front.point];
						}
						pq.offer(new Node(child.point, limit[child.point]));
					}
				}
			}
		}
		return limit[end];
	}
	static class Node implements Comparable<Node>{
		int point;
		int weight;
		public Node(int point, int weight) {
			super();
			this.point = point;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Node [point=" + point + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.weight, this.weight);
		}
	}
	static String src =
			"4 4\r\n" + 
			"1 2 8\r\n" + 
			"1 3 6\r\n" + 
			"2 3 7\r\n" + 
			"2 4 9\r\n" + 
			"1 4";
}
