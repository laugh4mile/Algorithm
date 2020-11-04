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

public class BJ_G2_17472_다리만들기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],islandIdx,totalCost,repres[];
	
	static int [][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	//간선 목록
	static List<Edge> edges;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		//입력완료
		// 1. 섬을 구분할거임 <- bfs로
		islandIdx = 2;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1) {
					bfs(r,c);
					islandIdx++;
				}
			}	
		}
		
		// 섬 구별 완료
//		for(int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		// 각 섬별로 거리를 구할거임
		edges = new ArrayList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] > 1) {
					// 그 지점에서 연결가능한 간선을 찾아볼거임
					makeEdgeList(r,c);
				}
			}
		}
		// 간선 리스트 확인
//		for(Edge edge: edges) {
//			System.out.println(edge);
//		}
		totalCost = 0;
		kruskal();
		System.out.println(totalCost);
	}
	private static void kruskal() {
		// makeSet
		
		// 최소가 먼저 튀어나오도록 간선을 정렬해주고
		
		// union 처리 == 연결된 정점들이 다 연결 되었겠지?
		
		// 그럼 모든 섬들이 다 연결되었는지 확인해보자
	}
	
	//모든 원소를을 독자적인 집합으로 만들어주자
	static void makeSet() {
		// 섬들이 정점
		repres = new int[islandIdx];
		for(int i=2; i<repres.length; i++) {
			
		}
	}
	
	static void makeEdgeList(int r, int c) {
		int base = map[r][c];
		for(int d=0; d<4; d++) {
			// 증가시켜서 갈 거리
			for(int l=1;; l++) {
				int nr = r + deltas[d][0]*l;
				int nc = c + deltas[d][1]*l;
				
				if(isIn(nr, nc)) {
					// 바다면? -> 쭉~ 진행
					if(map[nr][nc] == 0) {
						continue;
					}
					// 육지지만 내땅이면?
					else if(map[nr][nc] == base) {
						break;
					}
					// 육지면서 남의땅일때?
					else {
						if(l>2) {
							// 섬 앞까지가 다리이므로 l이 아니라 l-1로 해야함
							edges.add(new Edge(base, map[nr][nc], l-1)); 
						}
						break;
					}
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int a, b, cost;

		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}
		
		
	}
	
	static void bfs(int r, int c) {
		Queue<int []> q = new LinkedList<int[]>();
		q.offer(new int[] {r,c});
		
		// visited 대신 map에다가 isLandIdx를 써주자!
		map[r][c] = islandIdx;
		
		while(!q.isEmpty()) {
			int[] front = q.poll();
			for(int d=0; d<deltas.length; d++) {
				int nr = front[0] + deltas[d][0];
				int nc = front[1] + deltas[d][1];
				
				if(isIn(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = islandIdx;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		
	}
	
	static boolean isIn(int r,int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	
	static String src = 
			"7 8\r\n" + 
			"0 0 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 1 1\r\n" + 
			"1 1 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 1 1 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"1 1 1 1 1 1 1 1";

}
