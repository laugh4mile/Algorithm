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

public class BJ_G4_1976_여행가자 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],path[];
	static List<Integer> graph[];
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		map = new int[N][N];
		graph = new List[N+1];
		isVisited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				if(map[i][j] == 1) {
					graph[i+1].add(j+1);
					graph[j+1].add(i+1);
				}
			}
		}
		tokens = new StringTokenizer(input.readLine());
//		System.out.println(tokens.countTokens());
		int n = tokens.countTokens();
		path = new int[n];
		for(int i=0; i<n; i++) {
			path[i] = Integer.parseInt(tokens.nextToken());
		}
		
//		for(int []x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		List<Integer> result = new ArrayList<Integer>();
		result = bfs(path[0]);
		boolean isYes = true;
		
		for(int i=1; i<path.length; i++) {
			if(!result.contains(path[i])) {
				isYes = false;
				break;
			}
		}
		if(isYes) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
		
	}
	private static List<Integer> bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start] = true;
		List<Integer> list = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			list.add(front);
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
				}
			}
		}
		
		return list;
	}
	static String src = "3\r\n" + 
			"3\r\n" + 
			"0 1 0\r\n" + 
			"1 0 1\r\n" + 
			"0 1 0\r\n" + 
			"1 2 3"; 

}
