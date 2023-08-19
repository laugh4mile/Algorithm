package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_14496_그대그머가되어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int A,B,N,M,distance[], INF = Integer.MAX_VALUE;
	static boolean isVisited[];
	static List<Integer> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		distance = new int[N+1];
		isVisited = new boolean[N+1];
		graph = new List[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		Arrays.fill(distance, INF);
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		dijkstra(A);
//		for(int i=1; i<N+1; i++) {
//			System.out.println(distance[i]);
//		}
		if(distance[B] == INF) {
			System.out.println(-1);
		}else {
			System.out.println(distance[B]);
		}
	}

	private static void dijkstra(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			int front = queue.poll();
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				int child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
					distance[child] = distance[front] + 1;
				}
			}
		}
	}

	static String src = 
			"1 2\r\n"
			+ "4 4\r\n"
			+ "1 3\r\n"
			+ "1 4\r\n"
			+ "3 2\r\n"
			+ "4 2";
}
