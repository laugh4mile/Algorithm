package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 좋은저녁 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,V;
	static List<Integer> list[];
	static boolean isVisited[];
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken()); 
		V = Integer.parseInt(tokens.nextToken());
		
		list = new List[N+1];
		for(int i=1; i<list.length; i++) {
			list[i] = new ArrayList<>();
		}
		isVisited = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		for(int i=1; i<list.length; i++) {
			Collections.sort(list[i]);
		}
		
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
	
	private static void bfs(int start) {
		Arrays.fill(isVisited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			System.out.print(front+" ");
			List<Integer> childs = list[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
				}
			}
		}
	}

	private static void dfs(int node) {
		System.out.print(node+" ");
		isVisited[node] = true;
		
		List<Integer> childs = list[node];
		for(int i=0; i<childs.size(); i++) {
			Integer child = childs.get(i);
			if(!isVisited[child]) {
				dfs(child);
			}
		}
	}

	static String src = "5 5 3\r\n" + 
			"5 4\r\n" + 
			"5 2\r\n" + 
			"1 2\r\n" + 
			"3 4\r\n" + 
			"3 1";
}
