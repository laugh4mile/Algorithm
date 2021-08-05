package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_17140_이차원배열과연산 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int r,c,k,N,M, map[][],temp[][];
	static List<Num> rows[], cols[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		r = Integer.parseInt(tokens.nextToken())-1;
		c = Integer.parseInt(tokens.nextToken())-1;
		k = Integer.parseInt(tokens.nextToken());
		N = 3;
		M = 3;
		map = new int[N][M];
		
		for(int i=0; i<3; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println();
		int t = 0;
		while(t<100) {
			if(r<N && c<M && map[r][c] == k) {
				break;
			}
			if(map.length >= map[0].length) {
				sortByRow();
//				for(int x[] : map) {
//					System.out.println(Arrays.toString(x));
//				}
//				System.out.println();
			}else {
				sortByCol();
//				for(int x[] : map) {
//					System.out.println(Arrays.toString(x));
//				}
//				System.out.println();
			}
			t++;
		}
		if(t != 100) {
			System.out.println(t);
		}else {
			System.out.println(-1);
		}
	}
	private static void sortByRow() {
		int max = 0;
		rows = new List[N];
		for(int i=0; i<N; i++) {
			rows[i] = new ArrayList<>();
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 0) continue; // 0은 취급안함
				boolean flag = false;
				for(int i=0; i<rows[r].size(); i++) {
					if(rows[r].get(i).num == map[r][c]){
						rows[r].get(i).cnt++;
						flag = true;
						break;
					}
				}
				if(!flag) {
					rows[r].add(new Num(map[r][c], 1));
				}
			}
			Collections.sort(rows[r]);
			if(rows[r].size() > max) {
				max = rows[r].size();
			}
		}
		M = max*2;
		if(M > 100) {
			M = 100;
		}
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			int cnt = 0;
			for(int c=0; c<rows[r].size(); c++) {
				map[r][cnt++] = rows[r].get(c).num;
				map[r][cnt++] = rows[r].get(c).cnt;
				if(c==49) break; // 49 맞나? 
			}
		}
	}
	private static void sortByCol() {
		int max = 0;
		cols = new List[M];
		for(int i=0; i<M; i++) {
			cols[i] = new ArrayList<>();
		}
		for(int c=0; c<M; c++) {
			for(int r=0; r<N; r++) {
				if(map[r][c] == 0) continue; // 0은 취급안함
				boolean flag = false;
				for(int i=0; i<cols[c].size(); i++) {
					if(cols[c].get(i).num == map[r][c]){
						cols[c].get(i).cnt++;
						flag = true;
						break;
					}
				}
				if(!flag) {
					cols[c].add(new Num(map[r][c], 1));
				}
			}
			Collections.sort(cols[c]);
			if(cols[c].size() > max) {
				max = cols[c].size();
			}
		}
		N = max*2;
		if(N > 100) {
			N = 100;
		}
		map = new int[N][M];
		for(int c=0; c<M; c++) {
			int cnt = 0;
			for(int r=0; r<cols[c].size(); r++) {
//				if(cols[c].get(r).num == 0) { // 0의 개수를 쓸 필요는 없음
//					break;
//				}
				map[cnt++][c] = cols[c].get(r).num;
				map[cnt++][c] = cols[c].get(r).cnt;
				if(r==49) break; // 49 맞나? 
			}
		}
	}
	static class Num implements Comparable<Num>{
		int num;
		int cnt;
		public Num(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Num [num=" + num + ", cnt=" + cnt + "]";
		}
		@Override
		public int compareTo(Num o) {
			if(this.cnt == o.cnt) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.cnt, o.cnt);
		}
	}
	static String src =
			"3 3 3\r\n"
			+ "1 1 1\r\n"
			+ "1 1 1\r\n"
			+ "1 1 1";
}
