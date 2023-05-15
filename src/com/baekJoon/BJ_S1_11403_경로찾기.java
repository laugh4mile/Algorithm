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


public class BJ_S1_11403_경로찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][];
	
	static boolean isVisited[];
	static int result[][];
	static List<Integer> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		isVisited = new boolean[N];
		result = new int[N][N];
		graph = new List[N];
		
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if (map[r][c]==1) {
					graph[r].add(c);
				}
			}
		}
		
//		for(int r[] : map) {
//				System.out.println(Arrays.toString(r));
//		}
		for(int i=0; i<N; i++) {
				bfs(i);
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.printf("%d ", result[r][c]);
			}
			System.out.println();
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
				result[start][child] = 1;
				if(!isVisited[child]) {
					queue.offer(child);
					isVisited[child] = true;
				}
			}
		}
	}
	static String src ="7\r\n" + 
			"0 0 0 1 0 0 0\r\n" + 
			"0 0 0 0 0 0 1\r\n" + 
			"0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 1 1 0\r\n" + 
			"1 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 1\r\n" + 
			"0 0 1 0 0 0 0";

}
