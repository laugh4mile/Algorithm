package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MST_Prim {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, graph[][];
	//최소비용을 관리해 줄 배열이 필요하다
	static int [] minEdge;
	//방문관리
	static boolean [] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		//그래프 만들기 - 애초에 인접 행렬 형태로 주어짐
		graph = new int[N][N];
		minEdge = new int[N]; // <- 신장 트리에 포함된 정점들과 자신을 연결할때 최소 간선비용
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(tokens.nextToken());
			}
			// 처음에는 무한대의 비용으로 초기화
			minEdge[i] = Integer.MAX_VALUE;
		}
		visited = new boolean[N];
//		primNonePQ();
		primPQ();
	}
	
	static void primNonePQ() {
		// 최소 정점을 찾아보자!!
		int minVertex=0, minCost=0, result=0; // 최소비용의 정점 , 그때의 비용, 전체 비용
		// 임의의 한 점에서 MST가 시작한다
		minEdge[0] = 0;
		
		// 모든 정점을 대상으로 탐색
		for(int v = 0; v<N; v++) {
			// 최소 비용의 정점을 찾아보자
			minCost = Integer.MAX_VALUE;
			minVertex = 0;
			// 전체 노드에서 찾아보자
			for(int i=0; i<N; i++) {
				// 어떤 정점이 아직 미방문이고 비용이 최소 비용보다 작다면..  --> 여기를 MST로 포함시키자.
				if(!visited[i] && minEdge[i] < minCost) {
					minCost = minEdge[i];
					minVertex = i;
				}
			}
			// 한정점이 연결 완료되면 result에 모으자
			result += minCost;
			visited[minVertex] = true;
			
			// 이제 mst를 구성하고 있는 요소들에서 다음 점들을 찾아가 보자.
			for(int i=0; i<N; i++) {
				// 연결 가능한 지점들의 비용을 최소가 되도록 수정해보자
				if(!visited[i] && graph[minVertex][i] !=0 && graph[minVertex][i] < minEdge[i]) {
					// 더 낮은 비용이 이쓰으므로 그것으로 업데이트
					minEdge[i] = graph[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}
	
	static void primPQ() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int result = 0;
		// 임의의 한 점에서 출발한다.
		minEdge[0] = 0;
		pq.offer(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			// 최소 비용의 녀석이 자동으로 빠져나오게됨. pq의 특징
			Node minVertex = pq.poll(); 
			
			if(visited[minVertex.no]) {
				continue;
			}
			result +=minVertex.cost;
			visited[minVertex.no] = true;
			
			// 자식 탐색
			for(int i=0; i<N; i++) {
				if(!visited[i] && graph[minVertex.no][i] != 0 && graph[minVertex.no][i] < minEdge[i]) {
					minEdge[i] = graph[minVertex.no][i];
					// 새로운 노드가 들어가면서 역시 cost 순서롤 자동정렬
					pq.offer(new Node(i, graph[minVertex.no][i]));
				}
			}
		}
		System.out.println(result);
	}
	static class Node implements Comparable<Node>{
		int no;
		int cost;
		public Node(int no, int cost) {
			super();
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		@Override
		public String toString() {
			return "[no=" + no + ", cost=" + cost + "]";
		}
	}

	static String src = "5\r\n" + 
			"0 14 4 10 20 \r\n" + 
			"14 0 7 8 7 \r\n" + 
			"4 5 0 7 16 \r\n" + 
			"11 7 9 0 2 \r\n" + 
			"18 7 17 4 0";

}
