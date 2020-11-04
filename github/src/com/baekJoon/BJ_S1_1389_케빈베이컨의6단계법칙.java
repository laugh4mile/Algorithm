package com.baekJoon;

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

public class BJ_S1_1389_케빈베이컨의6단계법칙 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,cnt,arr[][], result[];
	static boolean isVisited[];
	static List<Integer> graph[];
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new List[N+1];
		result = new int[N+1];
		isVisited = new boolean[N+1];
		
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(graph[i]);
		}
//		System.out.println(Arrays.toString(graph));
		arr = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			bfs(i);	
		}
//		for(int x[] : arr) {
//			System.out.println(Arrays.toString(x));
//		}
		for(int i=1; i<N+1 ; i++) {
			for(int j=1; j<N+1; j++) {
				result[i] += arr[i][j];
			}	
		}
		int min = Integer.MAX_VALUE;
		for(int i=1; i<result.length; i++) {
			if(result[i] < min) {
				min = result[i];
			}
		}
		for(int i=1; i<result.length; i++) {
			if(result[i] == min) {
				System.out.println(i);
				break;
			}
		}
		
	}
	private static void bfs(int start) {
		Arrays.fill(isVisited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
					arr[start][child] = arr[start][front]+1;
				}
			}
		}
	}
	static String src = "5 5\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"4 5\r\n" + 
			"4 3\r\n" + 
			"3 2";
}
