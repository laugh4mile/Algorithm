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

public class BJ_G4_1504_특정한최단경로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,E,distance[],v1,v2, answer;
	static boolean isVisited[];
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		distance = new int[N+1];
		graph = new List[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int e=0; e<E; e++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int val = Integer.parseInt(tokens.nextToken());
			graph[from].add(new Node(to, val));
			graph[to].add(new Node(from, val));
		}
		
		tokens = new StringTokenizer(input.readLine());
		v1 = Integer.parseInt(tokens.nextToken());
		v2 = Integer.parseInt(tokens.nextToken());
		
		int start = 0, mid = 0, end = 0, start2 = 0, end2 = 0;
		dijkstra(v1);
		mid = distance[v2];
		start = distance[1];
		end = distance[N];
		dijkstra(v2);
		start2 = distance[1];
		end2 = distance[N];
		
		int answer = 0;
		if(start + end2 > start2 + end) {
			answer = mid+start2+end;
		}else {
			answer = mid+start+end2;
		}
		
		if(answer > 800000) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
	}
	private static void dijkstra(int start) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		isVisited = new boolean[N+1];
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
					if(!isVisited[child.point] && distance[child.point] > distance[front.point] + child.value) {
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
		public String toString() {
			return "Node [point=" + point + ", value=" + value + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}


	}
	static String src =
			"4 6\r\n" + 
			"1 2 3\r\n" + 
			"2 3 3\r\n" + 
			"3 4 1\r\n" + 
			"1 3 5\r\n" + 
			"2 4 5\r\n" + 
			"1 4 4\r\n" + 
			"2 3";
}
