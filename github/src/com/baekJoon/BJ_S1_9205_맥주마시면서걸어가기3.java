package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주마시면서걸어가기3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,map[][];
	static boolean isVisited[][], happy, isSelected[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N+2][2];
			isSelected = new boolean[N+2];
			isVisited = new boolean[N+2][N];
			for(int i=0; i<N+2; i++) {
				tokens = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				map[i][0] = x;
				map[i][1] = y;
				
			}
//			for(int[] x : map) {
//				System.out.println(Arrays.toString(x));
//			}
//			for(int i=0; i< N+2; i++) {
//				bfs(i);
//			}
			bfs(0);
			if(happy) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			happy = false;
			
		}
		
	}
	private static void bfs(int x) {
		Arrays.fill(isSelected, false);
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(map[x][0], map[x][1]));
		isSelected[x] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(front.x == map[N+1][0] && front.y == map[N+1][1]) {
				happy = true;
				break;
			}
			
			List<Node> childs = new ArrayList<>();
			for(int i=0; i<N+2; i++) {
				if(!isSelected[i]&& Math.abs(front.x-map[i][0]) + Math.abs(front.y-map[i][1]) <= 1000) {
					childs.add(new Node(map[i][0], map[i][1]));
				}
			}
			for(int i=0; i<childs.size(); i++) {
				Node child = childs.get(i);
				int k = 0;
				for(int j=0; j<N+2; j++) {
					if(child.x == map[j][0] && child.y == map[j][1]) {
						k = j;
					}
				}
				if(!isSelected[k]) {
					isSelected[k] = true;
					queue.offer(child);
				}
			}
		}
		
	}
//	private static void bfs(int x, int y) {
//		Queue<Node> queue = new LinkedList<>();
//		queue.offer(new Node(x, y));
//		isVisited[x][y] = true;
//		
//		while(!queue.isEmpty()) {
//			Node front = queue.poll();
//			if(front.x == map[N+1][0] && front.y == map[N+1][1]) {
//				happy = true;
//				break;
//			}
//			List<Node> childs = new ArrayList<>();
//			for(int i=0; i<N+2; i++) {
//				if(Math.abs(front.x-map[i][0]) + Math.abs(front.y-map[i][1]) < 1000 && !isVisited[map[i][0]][map[i][1]]) {
//					childs.add(new Node(map[i][0], map[i][1]));
//				}
//			}
//			for(int i=0; i<childs.size(); i++) {
//				Node child = childs.get(i);
//				if(!isVisited[child.x][child.y]) {
//					isVisited[child.x][child.y] = true;
//					queue.offer(child);
//				}
//			}
//		}
//	}
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static String src = "2\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"1000 1000\r\n" + 
			"2000 1000\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"2000 1000\r\n" + 
			"2000 2000";
}
