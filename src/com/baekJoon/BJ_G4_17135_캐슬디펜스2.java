package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_17135_캐슬디펜스2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,D, maxKill, totalEnemy;
	static List<Integer> archers = new LinkedList<>();
	static List<Enemy> enemies = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				if(Integer.parseInt(tokens.nextToken()) == 1) {
					enemies.add(new Enemy(r, c, 0,false));
					totalEnemy++;
				}
			}	
		}
		allocateArcher(0,0);
		System.out.println(maxKill);
	}
	
	private static void allocateArcher(int start, int cnt) { // 궁수 배치
		if(cnt == 3) {
			defence(enemies);
			return;
		}
		for(int i=start; i<M; i++) {
			archers.add(i);
			allocateArcher(i+1, cnt+1);
			archers.remove(archers.size()-1);
		}
	}
	
	private static void defence(List<Enemy> enemies) {
		// 0. kill = 0
		// 1. 모든 궁수가 죽일 적을 찾는다.
		// 2. 적을 죽인다. // kill++ 최대값이 곧 정답이다.
		// 3. 적들이 1칸 전진한다. // 범위를 넘은 적은 놓친 적이다. 
		// 4. 1~3을 반복, 적들이 존재하지 않으면 탈출. 
		List<Enemy> tempList = new ArrayList<>();
		for(int i=0; i<enemies.size(); i++) {
			tempList.add(new Enemy(enemies.get(i).r, enemies.get(i).c, 0, false));
		}
		int miss = 0, kill = 0;
		while(true) {
			if(kill > maxKill) {
				maxKill = kill;
			}
			if(tempList.isEmpty()) {
				break;
			}
			for(int i=0; i<archers.size(); i++) { // 조준
				for(int j=0; j<tempList.size(); j++) {
					Enemy front = tempList.get(j);
					tempList.get(j).d = Math.abs(front.r-N) + Math.abs(front.c - archers.get(i));
				}
				Collections.sort(tempList);
				if(tempList.get(0).d <= D) {
					tempList.get(0).isAimed = true;
				}
			}
			
			for(int i=0; i<tempList.size(); i++) {
				if(tempList.get(i).isAimed) {
					tempList.remove(i--);
					kill++;
				}
			}
			for(int i=0; i<tempList.size(); i++) {
				int nr = tempList.get(i).r+1;
				int nc = tempList.get(i).c;
				if(isIn(nr, nc)) {
					tempList.get(i).r++;
				}else {
					tempList.remove(i--);
				}
			}
		}
	}
	
	static class Enemy implements Comparable<Enemy>{
		int r;
		int c;
		int d;
		boolean isAimed;
		
		public Enemy(int r, int c, int d, boolean isAimed) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.isAimed = isAimed;
		}

		@Override
		public String toString() {
			return "Enemy [r=" + r + ", c=" + c + ", d=" + d + ", isAimed=" + isAimed + "]";
		}

		@Override
		public int compareTo(Enemy o) {
			if(this.d == o.d) {
				return Integer.compare(this.c, o.c);
			}
			return Integer.compare(this.d, o.d);
		}
	}
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}

	static String src =
			"5 5 5\r\n"
			+ "1 1 1 1 1\r\n"
			+ "1 1 1 1 1\r\n"
			+ "1 1 1 1 1\r\n"
			+ "1 1 1 1 1\r\n"
			+ "1 1 1 1 1";
}
