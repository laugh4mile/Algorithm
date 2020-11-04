package com.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		int start = 0;
		int end = V-1;
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V][V];
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		for(int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<V; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Arrays.fill(distance, INFINITY);
		distance[start] = 0;
		
		int min=0, current=0;
		
		for(int i=0; i<V; i++) {
			min = INFINITY;
			// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			for(int j=0; j<V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if (current == end) break;
			
			// 2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
			for(int j=0; j<V; j++) {
				// min ==> distance[current]
				if(!visited[j] && matrix[current][j] !=0 && distance[j] > min + matrix[current][j]) { // 방문하지 않은지점 + 인접된지점 + 거리
					distance[j] = min + matrix[current][j];
				}
			}
		}
		System.out.println(distance[end]);
	}
}
