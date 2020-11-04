package com.BackJoon;

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

public class BJ_G5_2668_숫자고르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, num[], cnt;
	static boolean isVisited[];
	static List<Integer> graph[], ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(br.readLine());
		num = new int[N+1];
		isVisited = new boolean[N+1];
		graph = new List[N+1];
		ans = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=N; i++) {
//			num[i] = Integer.parseInt(br.readLine());
			graph[i].add(Integer.parseInt(br.readLine()));
//			System.out.println(i+" : " +graph[i]);
		}
		
		for(int i=1; i<=N; i++) {
			dfs(i);
			Arrays.fill(isVisited, false);
//			System.out.println();
		}
		System.out.println(cnt);
		
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		
	}
	private static void dfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			Integer front = queue.poll();
//			System.out.print(front+" ");
			List<Integer> childs = graph[front];
			for(int i=0; i<childs.size(); i++) {
				Integer child = childs.get(i);
				
				if(child == start) {
					cnt++;
					ans.add(start);
				}
				if(!isVisited[child]) {
					isVisited[child] = true;
					queue.offer(child);
				}
			}
		}
		
	}
	
	static String src = 
			"7\r\n" + 
			"3\r\n" + 
			"1\r\n" + 
			"1\r\n" + 
			"5\r\n" + 
			"5\r\n" + 
			"4\r\n" + 
			"6";
}
