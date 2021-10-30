package com.codingtest.nhn.commerce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q4 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N, M, G;
	static List<Node> list[], list2[];
	static boolean[] isVisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		G = Integer.parseInt(tokens.nextToken());
		
		list = new List[N+1];
		list2 = new List[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			list[from].add(new Node(to, 0));
			list2[to].add(new Node(from, 0));
		}
		tokens = new StringTokenizer(input.readLine());
		int mid = Integer.parseInt(tokens.nextToken()); 
		int start = Integer.parseInt(tokens.nextToken());
		int end = Integer.parseInt(tokens.nextToken());
		
		bfs(mid, -1);
		bfs(mid, 1);
		for(int i=0; i<list.length; i++) {
			System.out.println(i+" "+list[i]);
		}
	}
	private static void bfs(int cur, int state) {
		isVisited = new boolean[N+1];
		Queue<Node> queue = new LinkedList<>();
		int v = state == 1 ? 0 : G;
		queue.offer(new Node(cur, v));
		isVisited[cur] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
//			List<Node> childs = state == 1 ? list[front.node]: list2[front.node];
			if(state == 1) {
				for(int i=0; i<list2[front.node].size(); i++) {
					Node child = list2[front.node].get(i);
					if(!isVisited[child.node]) {
						isVisited[child.node] = true;
						queue.offer(new Node(child.node, front.val+state));
						list2[front.node].get(i).val = front.val+state;
					}
				}
			}else {
				for(int i=0; i<list[front.node].size(); i++) {
					Node child = list[front.node].get(i);
					if(!isVisited[child.node]) {
						isVisited[child.node] = true;
						queue.offer(new Node(child.node, front.val+state));
						list[front.node].get(i).val = front.val+state;
					}
				}
			}
		}
	}
	private static void dfs(int cur, int val) {
//		isVisited[cur] = true;
//		System.out.println(val);
		List<Node> childs = list[cur];
		for(int i=0; i<childs.size(); i++) {
			Node child = childs.get(i);
			if(!isVisited[child.node]) {
				child.val = val;
				dfs(child.node, val-1);
			}
		}
	}
	
	private static void dfs2(int cur, int val) {
		isVisited[cur] = true;
		List<Node> childs = list2[cur];
		for(int i=0; i<childs.size(); i++) {
			Node child = childs.get(i);
			if(!isVisited[child.node]) {
				child.val = val;
				System.out.println(cur+" "+val);
				val++;
				dfs2(child.node, val);
				val--;
			}
		}
	}
	
	static class Node{
		int node;
		int val;
		public Node(int node, int val) {
			super();
			this.node = node;
			this.val = val;
		}
		@Override
		public String toString() {
			return "Node [node=" + node + ", val=" + val + "]";
		}
	}
	static String src =
			"7 12 2\r\n" + 
					"7 2\r\n" + 
					"5 4\r\n" + 
					"6 4\r\n" + 
					"4 3\r\n" + 
					"3 7\r\n" + 
					"1 6\r\n" + 
					"6 7\r\n" + 
					"5 3\r\n" + 
					"6 5\r\n" + 
					"5 7\r\n" + 
					"4 2\r\n" + 
					"4 7\r\n" + 
					"7 6 3";
//			"13 11 8\r\n" + 
//			"6 9\r\n" + 
//			"10 12\r\n" + 
//			"9 8\r\n" + 
//			"11 1\r\n" + 
//			"3 11\r\n" + 
//			"8 7\r\n" + 
//			"7 5\r\n" + 
//			"1 2\r\n" + 
//			"2 6\r\n" + 
//			"5 4\r\n" + 
//			"4 13\r\n" + 
//			"8 12 3";
}
