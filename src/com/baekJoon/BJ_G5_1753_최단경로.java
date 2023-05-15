package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_1753_최단경로 {
	InputStream in;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int V,E; // (1≤V≤20,000, 1≤E≤300,000) -> 인접행렬로 하기엔 너무 버겁다. 리스트 ㄱㄱ
	static int K; // 시작점
	
	static LinkNode [] graph;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		V = Integer.parseInt(tokens.nextToken()) +1; // 정점들의 시작 1부터..
		E = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(input.readLine());
		
		//그래프 생성 - 정점의 개수가 많기 때문에 인접 리스트 형태로 가자!!!!
		graph = new LinkNode[V];
		// 단방향 그래프 생성
		for(int e=0; e<E; e++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			graph[a] = new LinkNode(b, w, graph[a]);
			
			// 만약 양방향 그래프다?
			// graph[b] = new LinkNode(a, w, graph[b]);
		}
		
//		dijkstra(K);
		dijkstraPQ(K);
		
	}
	
	static void dijkstraPQ(int start) {
		// 준비물
		boolean [] visited = new boolean[V];
		int [] dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		
		// 출발지 설정
		dist[start] = 0;
		pq.offer(new LinkNode(start, 0, 0)); // 최소 누적 비용을 이제 내가 탐색할 필요는 없다..
		
		while(!pq.isEmpty()) {
			// 최소비용 노드
			LinkNode minVer = pq.poll(); // 최소 비용을 가지고 있는 정점이 minVer에 저장
			// 방문처리. 넌이제 우리 그룹이다..
			visited[minVer.no] = true;
			
			// 다음 노드 찾아가보기
			LinkNode next = graph[minVer.no];
			while(next!=null) {
				if(!visited[next.no] && dist[next.no] > minVer.dist + next.cost) {
					// 최소 비용으로 업데이트 해주기
					dist[next.no] = minVer.dist + next.cost;
					// 여기서 방문처리하지 마라
					pq.offer(new LinkNode(next.no, next.cost, dist[next.no]));
				}
				next = next.link;
			}
		}// 탐색종료
		for(int i=1; i<V; i++) {
			if(dist[i] == INF) {
				output.append("INF");
			}else {
				output.append(dist[i]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	
	
	static void dijkstra(int start) {
		// 상황판이 2개가 나옴
		boolean [] visited = new boolean[V]; // 방문을 했나 -> 우리 그룹에 속해있나
		int [] dist = new int[V]; // 모든 정점까지의 거리를 관리할 녀석 --> 계속 줄여가는게 목적임
		// 출방점을 제외하고는 모두 탐색할 계획
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		// 모든 정점들에 대해서 처리 ㄱㄱ
		for(int v=0; v<V; v++) {
			// 아직 미방문인 지점 대상으로 최소 비용의 정점 찾기
			int minVer = 0, minCost = INF;
			for(int i=1; i<V; i++) {
				if(!visited[i] && dist[i] < minCost) {
					minCost = dist[i];
					minVer = i;
				}
			}
			// 이제 최소 정점은 우리의 그룹이 됨 --> 방문처리
			visited[minVer] = true;
			
			// 최소 정점에서 연결 가능한 지점들 찾아가면서 업데이트하자
			LinkNode next = graph[minVer];
			while(next != null) {
				// 아직 미방문이고 현재 dist에 등록된 거리가 minVer를 거쳐서 온 거리보다 길다면 업데이트
				if(!visited[next.no] && dist[next.no] > dist[minVer] + next.cost) {
					dist[next.no] = dist[minVer] + next.cost;
					// 여기서 방문체크하는 실수를 하지 마라.
				}
				// 이제 다음 노드 점검하기
				next = next.link;
			}
		}
//		System.out.println(Arrays.toString(dist));
		for(int i=1; i<V; i++) {
			if(dist[i] == INF) {
				output.append("INF");
			}else {
				output.append(dist[i]);
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	// PQ에서 관리해 보자!! -> Comparator
	static class LinkNode implements Comparable<LinkNode>{
		int no, cost;
		int dist; // 현재 정점까지의 누적 비용
		LinkNode link; // 다음 노드에 대한 참조 저장
		
		// 이 생성자의 용도는 열결리스트 형태의 그래프를 만드는 용도
		public LinkNode(int no, int cost, LinkNode link) {
			super();
			this.no = no;
			this.cost = cost;
			this.link = link;
		}
		
		// 이 생성자는 PQ 돌리기 위한 용도
		public LinkNode(int no, int cost, int dist) {
			super();
			this.no = no;
			this.cost = cost;
			this.dist = dist;
		}

		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.dist, o.dist);
		}

		@Override
		public String toString() {
			return "[n=" + no + ", c=" + cost + ", d=" + dist + "]";
		}
		
		
	}
	
	static String src = "5 6\r\n" + 
			"1\r\n" + 
			"5 1 1\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"2 3 4\r\n" + 
			"2 4 5\r\n" + 
			"3 4 6";
}
