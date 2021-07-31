package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,D,map[][], maxKill, totalEnemy;
	static boolean isVisited[][];
	static Set<Enemy> set = new HashSet<>();
	static List<Integer> archers = new LinkedList<>();
	static List<Enemy> enemies = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) {
					enemies.add(new Enemy(r, c, 0));
					totalEnemy++;
				}
			}	
		}
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		allocateArcher(0,0);
	}
	
	private static void allocateArcher(int start, int cnt) { // 궁수 배치
		if(cnt == 3) {
			System.out.println(archers);
			defence(enemies, map);
			return;
		}
		for(int i=start; i<M; i++) {
			archers.add(i);
			allocateArcher(i+1, cnt+1);
			archers.remove(archers.size()-1);
		}
	}
	
	private static void defence(List<Enemy> enemies, int[][] map) {
		// 0. miss = 0, kill = 0
		// 1. 모든 궁수가 죽일 적을 찾는다.
		// 2. 적을 죽인다. // kill++ 최대값이 곧 정답이다.
		// 3. 적들이 1칸 전진한다. // 범위를 넘은 적은 놓친 적이다. miss++
		// 4. 1~3을 적들이 존재하지 않으면 탈출. 혹은 total - kill < miss 이면 탈출.
		int remain = totalEnemy;
		int miss = 0, kill = 0;
		while(true) {
			if(remain <= 0 || totalEnemy < miss + kill) {
				break;
			}
			for(int i=0; i<3; i++) {
				int archer = archers.get(i);
				map = aim(archer, enemies, map); 
			}
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					
				}	
			}
			
			break;
		}
		
	}
	
	private static int[][] aim(Integer cur, List<Enemy> enemies, int map[][]) {
		PriorityQueue<Enemy> temp = new PriorityQueue<>();
		for(int i=0; i<enemies.size(); i++) {
			Enemy front = enemies.get(i);
			temp.add(new Enemy(front.r, front.c, Math.abs(front.r - N) + Math.abs(front.c - cur)));
		}
		map[temp.peek().r][temp.peek().c] = 3;
		return map;
	}
	
	static class Enemy implements Comparable<Enemy>{
		int r;
		int c;
		int d;

		public Enemy(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
		@Override
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Enemy o) {
			if(this.d == o.d) {
				return Integer.compare(this.r, o.c);
			}
			return Integer.compare(this.d, o.d);
		}
	}
	
	static int dr[] = {0,-1,0}; // 왼, 위, 오
	static int dc[] = {-1,0,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static String src =
			"5 5 1\r\n"
			+ "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n"
			+ "1 1 1 1 1";
}
