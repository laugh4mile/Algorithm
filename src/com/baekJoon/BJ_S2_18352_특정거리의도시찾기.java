package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_18352_특정거리의도시찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,X,A,B, distance[], INF = Integer.MAX_VALUE;
	static boolean isVisited[];
	static List<Integer> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		distance = new int[N+1];
		for(int i=0; i<N+1; i++) {
			distance[i] = INF;
		}
		isVisited = new boolean[N+1];
		graph = new List[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			A = Integer.parseInt(tokens.nextToken());
			B = Integer.parseInt(tokens.nextToken());
			graph[A].add(B);
		}
		
		dijkstra(X);
		boolean flag = false;
		for(int i=1; i<N+1; i++) {
			if(distance[i] == K) {
				System.out.println(i);
				if(!flag) {
					flag = true;
				}
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
	}

	private static void dijkstra(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		distance[start] = 0;
		isVisited[start] = true;
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				int child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					distance[child] = distance[front] + 1;
					isVisited[child] = true;
				}
			}
		}
	}

	static String src = 
			"4 4 1 1\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2 3\r\n"
			+ "2 4";
}
