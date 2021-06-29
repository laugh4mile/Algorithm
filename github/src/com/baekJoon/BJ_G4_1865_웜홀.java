package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_1865_웜홀 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int testCase,N,M,W, S,E,T;
	static List<Node> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		testCase = Integer.parseInt(input.readLine());
		for(int t=0; t<testCase; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			W = Integer.parseInt(tokens.nextToken());
			graph = new List[N+1];
			for(int i=0; i<N+1; i++) {
				graph[i] = new ArrayList<>();
			}
			for(int m=0; m<M; m++) {
				tokens = new StringTokenizer(input.readLine());
				S = Integer.parseInt(tokens.nextToken());
				E = Integer.parseInt(tokens.nextToken());
				T = Integer.parseInt(tokens.nextToken());
//				if(!graph[S].contains(E)) {
//					graph[S].add(new Node(E, T));
//				}else {
//					if(graph[S].get(E).time > T) {
//						
//					}
//				}
//				if(!graph[E].contains(S)) {
//					graph[E].add(new Node(S, T));
//				}
				graph[S].add(new Node(E, T));
				graph[E].add(new Node(S, T));
			}
			for(int w=0; w<W; w++) { 
				tokens = new StringTokenizer(input.readLine());
				S = Integer.parseInt(tokens.nextToken());
				E = Integer.parseInt(tokens.nextToken());
				T = Integer.parseInt(tokens.nextToken()); 
				graph[S].add(new Node(E, -T));
			}
			for(int i=1; i<N+1; i++) {
				System.out.println(i+": "+graph[i]);
			}
			System.out.println();
			
		}
	}
	
	static class Node {
		int point;
		int time;
		public Node(int point, int time) {
			super();
			this.point = point;
			this.time = time;
		}
		@Override
		public String toString() {
			return "Node [point=" + point + ", time=" + time + "]";
		}
	}

	static String src =

			"2\r\n" + 
			"3 3 1\r\n" +  
			"1 2 2\r\n" + 
			"1 3 4\r\n" + 
			"2 3 1\r\n" + 
			"3 1 3\r\n" + 
			"3 2 1\r\n" + 
			"1 2 3\r\n" + 
			"2 3 4\r\n" + 
			"3 1 8";  
}
