package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_2606_바이러스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N,M, cnt;
	static List<Integer> graph[];
	static StringTokenizer tokens;
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new List[N+1];
		isVisited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
//		for(int i=1; i<graph.length; i++) {
//			System.out.println(graph[i]);
//		}
		bfs(1);
		System.out.println(cnt-1);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			cnt++;
			
			List<Integer> childs = graph[front];
			
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(!isVisited[child]) {
					isVisited[child] = true;
					queue.offer(child);
				}
			}
		}
		
	}
	static String src = 
			"7\r\n" + 
			"6\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"1 5\r\n" + 
			"5 2\r\n" + 
			"5 6\r\n" + 
			"4 7";
}
