package com.baekJoon;

import java.util.*;

public class Main {

	static List<Integer>[] conn;
	static int answer, key;
	static int[] parents;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		conn = new ArrayList[n+1];
		for(int i=0; i<conn.length; i++) {
			conn[i] = new ArrayList<Integer>();
		}
		
		int a = sc.nextInt();
		int b= sc.nextInt();
		int m = sc.nextInt();
		parents = new int[n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			conn[x].add(y);
			parents[y] = x;
		}
		
		answer = 0;
		key = b;
		dfs(a, 0);
		
		answer = answer==0 ? -1 : answer;
		System.out.println(answer);
	}

	static void dfs(int cur, int cnt) {
		visited[cur] = true;
		if(cur == key) {
			answer = cnt;
			return;
		}
		
		for(int i=0; i<conn[cur].size(); i++) { // 자식 찾기(아래로)
			dfs(conn[cur].get(i), cnt+1);
		}
		int parent = parents[cur];
		if(!visited[parent]) { // 위로이동
			dfs(parent, cnt+1);
		}
	}
}