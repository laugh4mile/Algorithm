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

public class BJ_S1_14221_편의점 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,A,B,C,P,Q,distance[],home[],CU[];
	static List<Node> graph[];
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		isVisited = new boolean[N+1];
		graph = new List[N+1];
		distance = new int[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
			distance[i] = Integer.MAX_VALUE;
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			graph[A].add(new Node(B, C));
			graph[B].add(new Node(A, C));
		}
		tokens = new StringTokenizer(input.readLine());
		P = Integer.parseInt(tokens.nextToken());
		Q = Integer.parseInt(tokens.nextToken());
		home = new int[P];
		CU = new int[Q];
		tokens = new StringTokenizer(input.readLine());
		for(int p=0; p<P; p++) {
			home[p] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for(int q=0; q<Q; q++) {
			CU[q] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=1; i<N+1; i++) {
			System.out.println(graph[i]);
		}
//		for(int i=0; i<Q; i++) {
//			dijkstra(i);
//		}
		dijkstra(1);
		for(int i=1; i<N+1; i++) {
			System.out.print(distance[i]+", ");
		}
	}
	private static void dijkstra(int start) {
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		isVisited[start] = true;
		while(!pq.isEmpty()) {
			Node front = pq.poll();
//			isVisited[front.point] = true;
			List<Node> childs = graph[start];
			for(int i=0; i<childs.size(); i++) {
				Node child = childs.get(i);
				
				if(distance[child.point] > front.value + child.value) {
					distance[child.point] = front.value + child.value;
					pq.offer(new Node(child.point, distance[child.point]));
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
			"6 9\r\n" + 
			"1 4 1\r\n" + 
			"1 5 2\r\n" + 
			"1 6 3\r\n" + 
			"2 4 2\r\n" + 
			"2 5 3\r\n" + 
			"2 6 1\r\n" + 
			"3 4 3\r\n" + 
			"3 5 1\r\n" + 
			"3 6 2\r\n" + 
			"3 3\r\n" + 
			"1 2 3\r\n" + 
			"4 5 6";
}
