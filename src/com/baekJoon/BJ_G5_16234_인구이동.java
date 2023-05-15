package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_16234_인구이동 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,L,R,map[][],map2[][],team,t;
	static boolean isVisited[][];
	static Map<Integer, Integer> population;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][N];
		map2 = new int[N][N];
		int map3[][] = new int[N][N];
		isVisited = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		
		boolean flag = false;
		for(t=0; t<=2000; t++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map3[r][c] = map[r][c];
				}	
			}
			population = new HashMap<>();
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(!isVisited[r][c]) {
						team++;
						bfs(r,c);
					}
				}	
			}
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = population.get(map2[r][c]);
					isVisited[r][c] = false;
					if(map[r][c] != map3[r][c]) {
						flag = true;
					}
				}	
			}
			if(!flag) {
				break;
			}
			flag = false;
			population.clear();
			team = 0;
		}
		System.out.println(t);
	}
	
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		int count = 0;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			count++;
			map2[front.r][front.c] = team;
			if(population.get(team) == null) {
				population.put(team, map[front.r][front.c]);
			}else {
				population.replace(team, population.get(team) + map[front.r][front.c]);
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && 
						L <= Math.abs(map[front.r][front.c] - map[nr][nc]) && 
						Math.abs(map[front.r][front.c] - map[nr][nc]) <= R) {
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
		}
		population.replace(team, population.get(team)/count);
	}

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static String src =
			"2 40 50\r\n" + 
			"50 30\r\n" + 
			"20 40";
}
