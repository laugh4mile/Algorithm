package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2021. 6. 30
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 역주행이 안됨
 * [입력사항]
 * [출력사항]
 */
public class BJ_S1_1446_지름길 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, D, distance[], INF = Integer.MAX_VALUE;
	static boolean isVisited[];
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		distance = new int[10001];
		isVisited = new boolean[10001];
		graph = new List[10001];
		for(int i=0; i<graph.length; i++) {
			distance[i] = i;
			graph[i] = new ArrayList<>();
		}
		
		
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			graph[start].add(new Node(end, d));
		}
		dijkstra(0);
	}
	private static void dijkstra(int start) {
		isVisited[start] = true;
		distance[start] = 0;
		
	}
	static class Node implements Comparator<Node>{
		int endPoint;
		int value;
		public Node(int endPoint, int value) {
			super();
			this.endPoint = endPoint;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [endPoint=" + endPoint + ", value=" + value + "]";
		}
		@Override
		public int compare(Node o1, Node o2) {
			return Integer.compare(o1.endPoint, o2.endPoint);
		}
		
	} 
	static String src =

			"5 150\r\n" + 
			"0 50 10\r\n" + 
			"0 50 20\r\n" + 
			"50 100 10\r\n" + 
			"100 151 10\r\n" + 
			"110 140 90";
}
