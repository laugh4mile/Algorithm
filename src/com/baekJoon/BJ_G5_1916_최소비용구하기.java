package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1916_최소비용구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,distance[],start,end;
	static boolean isVisited[];
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		distance = new int[N+1];
		isVisited = new boolean[N+1];
		graph = new List[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			graph[from].add(new Node(to, v));
		}
		tokens = new StringTokenizer(input.readLine());
		start = Integer.parseInt(tokens.nextToken());
		end = Integer.parseInt(tokens.nextToken());
		
		dijkstra(start);
		System.out.println(distance[end]);
	}
	private static void dijkstra(int start) {
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			if(!isVisited[front.point]) {
				isVisited[front.point] = true;
				List<Node> childs = graph[front.point];
				for(int i=0; i<childs.size(); i++) {
					Node child = childs.get(i);
					if(distance[child.point] > distance[front.point] + child.value) {
						distance[child.point] = distance[front.point] + child.value;
						pq.offer(new Node(child.point, distance[child.point]));
					}
				}
			}
		}
	}
	static class Node implements Comparable<Node>{
		int point;
		int value;
		public Node(int point, int value) {
			super();
			this.point = point;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
	}
	static String src =
			"5\r\n"
			+ "8\r\n"
			+ "1 2 2\r\n"
			+ "1 3 3\r\n"
			+ "1 4 1\r\n"
			+ "1 5 10\r\n"
			+ "2 4 2\r\n"
			+ "3 4 1\r\n"
			+ "3 5 1\r\n"
			+ "4 5 3\r\n"
			+ "1 5";
}
