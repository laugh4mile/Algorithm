package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_KruskalTest {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		public Edge (int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) { // implements Comparable를 쓰면 compareTo를 재정의 해야함!
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int V,E; //정점개수와 간선개수
	static Edge[] edgeList;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(in.readLine()," ");
		V = Integer.parseInt(tokens.nextToken());
		E = Integer.parseInt(tokens.nextToken());
		edgeList = new Edge[E];
		parents = new int[V];
		
		int from, to, weight;
		for(int i=0; i<E; i++) {
			tokens = new StringTokenizer(in.readLine()," ");
			from = Integer.parseInt(tokens.nextToken());
			to = Integer.parseInt(tokens.nextToken());
			weight = Integer.parseInt(tokens.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edgeList);
		// 여기까지가 크러스컬알고리즘을 짤 입력 준비가 완료됨
		
		make();
		int cnt=0, result=0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) { // true면 사이클이 형성되지 않은것!. 합쳐진것!
//				++cnt;
				result += edge.weight;
				if(++cnt == V-1) { //전부 탐색이 완료되었다면?
					break;
				}
			}
		}
		System.out.println(result);
	}
	
	private static void make() {
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) { //자기가 자기그롭의 짱이라면
			return a; // 자기자신을 리턴
		}
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
}
/* 입력값
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
*/