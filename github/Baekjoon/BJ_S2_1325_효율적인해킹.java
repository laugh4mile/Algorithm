package com.BackJoon;

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

public class BJ_S2_1325_효율적인해킹 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,result[], cnt[];
	static List<Integer> graph[];
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new List[N+1];
		result = new int[N+1];
		cnt = new int[N+1];
		isVisited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int to = Integer.parseInt(tokens.nextToken());
			int from = Integer.parseInt(tokens.nextToken());
			graph[from].add(to);
		}
		for(int i=1; i<N+1; i++) {
			result[i] = bfs(i);
		}
//		System.out.println(Arrays.toString(result));
		int max =0;
		for(int i=1; i<result.length; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		
		for(int i=1; i<result.length; i++) {
			if(result[i] == max) {
				System.out.print(i +" ");
			}
		}
	}
	private static int bfs(int start) {
		Arrays.fill(isVisited, false);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start] = true;
		cnt[start] = 0;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
			
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
					cnt[child] = cnt[front] +1;
				}
			}
		}
		int max =0;
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
			}
		}
		return max;
		
		
		
	}
	static String src = "5 4\r\n" + 
			"3 1\r\n" + 
			"3 2\r\n" + 
			"4 3\r\n" + 
			"5 3";

}
