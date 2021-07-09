package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_17396_백도어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static long distance[];
	static boolean isVisited[];
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		distance = new long[N];
		isVisited = new boolean[N];
		graph = new List[N+1];
		for(int n=0; n<N; n++) {
			int sight = Integer.parseInt(tokens.nextToken());
			distance[n] = Long.MAX_VALUE;
			graph[n] = new ArrayList<>();
			if(sight == 1 && n != N-1) {
				isVisited[n] = true;
			}
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int t = Integer.parseInt(tokens.nextToken());
			graph[a].add(new Node(b, t));
			graph[b].add(new Node(a, t));
		}
		
		dijkstra(0);
		if(distance[N-1] == Long.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(distance[N-1]);
		}
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
		long value;
		
		public Node(int point, long value) {
			super();
			this.point = point;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.value, o.value);
		}
	}
	static String src =
			"5 7\r\n"
			+ "0 0 0 1 1\r\n"
			+ "0 1 7\r\n"
			+ "0 2 2\r\n"
			+ "1 2 4\r\n"
			+ "1 3 3\r\n"
			+ "1 4 6\r\n"
			+ "2 3 2\r\n"
			+ "3 4 1";
}
