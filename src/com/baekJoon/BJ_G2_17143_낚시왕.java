package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G2_17143_낚시왕 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,M,map[][], answer;
	static List<Shark> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[R][C];
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			if(d == 1 || d==2) {
				s = s% (R*2-2);
			}
			if(d == 3 || d==4) {
				s = s% (C*2-2);
			}
			int z = Integer.parseInt(tokens.nextToken());
			
			list.add(new Shark(r, c, s, d, z));
		}
		
		for(int i=0; i<list.size(); i++) {
			map[list.get(i).r][list.get(i).c] = list.get(i).z;
		}
		
		for(int x[] : map) {
			System.out.println(Arrays.toString(x));
		}
		
		int fishman = 0;
//		System.out.println(list);
		
//		for(int i=0; i<C; i++) {
//			getNext(list, fishman+i);
//		}
//		list.remove(list.size()-1);
//		list.remove(list.size()-1);
//		list.remove(list.size()-1);
//		list.remove(list.size()-1);
//		list.remove(list.size()-1);
//		list.remove(0);
//		list.remove(0);
//		list.remove(0);
//		list.remove(0);
//		list.remove(0);
//		list.remove(0);
//		list.remove(list.size()-1);
		
		System.out.println(list);
		System.out.println();
		getNext(list, fishman);
		System.out.println();
		
		System.out.println(list);
		System.out.println(answer);
	}
	private static void getNext(List<Shark> list, int fishman) {
		for(int r=0; r<R; r++) {
			if(map[r][fishman] != 0) { 
				answer += map[r][fishman];
				map[r][fishman] = 0;
				list.remove(fishman);
				break;
			}
		}
		
		// 리스트 갱신
		for(int i=0; i<list.size(); i++) {
			
			if(list.get(i).d == 1) { // 방향 : 위
				if(list.get(i).s > list.get(i).r - 1) {
					list.get(i).s = list.get(i).s - list.get(i).r + 1;
					list.get(i).r = R;
					list.get(i).d = 1;
				} else {
					list.get(i).r = list.get(i).r + list.get(i).s;
					list.get(i).s = 0;
				}
			}
			
			if(list.get(i).d == 2) { // 방향 : 아래
				if(list.get(i).s > R - list.get(i).r) {
					list.get(i).s = list.get(i).s - R + list.get(i).r;
					list.get(i).r = R;
					list.get(i).d = 1;
				} else {
					list.get(i).r = list.get(i).r + list.get(i).s;
					list.get(i).s = 0;
				}
			}
			
			if(list.get(i).d == 3) { // 방향 : 오른쪽
				if( list.get(i).s > C - list.get(i).c) {
					list.get(i).s = list.get(i).s - C + list.get(i).c;
					list.get(i).c = C;
					list.get(i).d = 4;
				}else {
					list.get(i).c = list.get(i).c + list.get(i).s;
					list.get(i).s = 0;
				}
			}
			
			if(list.get(i).d == 4) { // 방향 : 왼쪽
				if(list.get(i).s > list.get(i).c-1) {
					list.get(i).s = list.get(i).s - list.get(i).c + 1;
					list.get(i).c = 1;
					list.get(i).d = 3;
				}else {
					list.get(i).c = list.get(i).c - list.get(i).s;
					list.get(i).s = 0;
				}
			}
		}
	}
	
	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		public int getD() {
			return d;
		}
		public void setD(int d) {
			this.d = d;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "] \n";
		}
		
	}
	static String src = 
			"4 6 8\r\n" + 
			"4 1 3 3 8\r\n" + 
			"1 3 5 2 9\r\n" + 
			"2 4 8 4 1\r\n" + 
			"4 5 0 1 4\r\n" + 
			"3 3 1 2 7\r\n" + 
			"1 5 8 4 3\r\n" + 
			"3 6 2 1 2\r\n" + 
			"2 2 2 3 5	";

}
