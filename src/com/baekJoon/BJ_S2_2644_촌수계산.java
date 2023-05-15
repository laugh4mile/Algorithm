package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_2644_촌수계산 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,A,B,M,cnt[];
	static List<Integer> graph[];
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		A = Integer.parseInt(tokens.nextToken());
		B = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(input.readLine());
		graph = new List[N+1];
		cnt = new int[101];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		isVisited = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
//		System.out.println(Arrays.toString(graph));
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		bfs(A);
		if(cnt[B] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(cnt[B]);
		}
		
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			if(front == B) {
				break;
			}
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
					cnt[child] = cnt[front]+1;
				}
			}
		}
	}

	static String src = "9\r\n" + 
			"7 3\r\n" + 
			"7\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 7\r\n" + 
			"2 8\r\n" + 
			"2 9\r\n" + 
			"4 5\r\n" + 
			"4 6";
}
