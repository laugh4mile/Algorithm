package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1967_트리의지름 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,startNode, sumVal;
	static List<Node> graph[];
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		isVisited = new boolean[N+1];
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int n=1; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int val = Integer.parseInt(tokens.nextToken());
//			System.out.println(from+" "+to+" "+val+" ");
			
			graph[from].add(new Node(to, val));
			graph[to].add(new Node(from, val));
		}
		isVisited[1] = true;
		dfs(1,0);
		Arrays.fill(isVisited, false);
		sumVal = 0;
		isVisited[startNode] = true;
		dfs(startNode,0);
		System.out.println(sumVal);
	}

	private static void dfs(int n, int sum) {
		if(sumVal < sum) {
			sumVal = sum; 
			startNode = n;
			
		}
		List<Node> childs = graph[n];
		for(int i=0; i<childs.size(); i++) {
			Node child = childs.get(i);
			if(!isVisited[child.n]) {
				isVisited[child.n] = true;
				dfs(child.n,sum+child.v);
				isVisited[child.n] = false;
			}
		}
	}

	static class Node{
		int n;
		int v;
		public Node(int n, int v) {
			super();
			this.n = n;
			this.v = v;
		}
		@Override
		public String toString() {
			return "Node [n=" + n + ", v=" + v + "]";
		}
		
	}
	
	static String src =
			"12\r\n" + 
			"1 2 3\r\n" + 
			"1 3 2\r\n" + 
			"2 4 5\r\n" + 
			"3 5 11\r\n" + 
			"3 6 9\r\n" + 
			"4 7 1\r\n" + 
			"4 8 7\r\n" + 
			"5 9 15\r\n" + 
			"5 10 4\r\n" + 
			"6 11 6\r\n" + 
			"6 12 10";
}
