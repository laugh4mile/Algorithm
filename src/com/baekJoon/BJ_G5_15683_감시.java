package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15683_감시 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][],copy[][], cctv, num[], min = Integer.MAX_VALUE;
	static List<CCTV> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		int six = 0;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] != 0 && map[r][c] != 6) {
					cctv++;
					list.add(new CCTV(r, c, 0, map[r][c]));
				}
				if(map[r][c] == 6) {
					six++;
				}
			}	
		}
		num = new int[cctv];
		
		permutation(0);
		System.out.println(min-six);
	}

	private static void permutation(int cnt) {
		if (cnt == cctv) {
//			System.out.println(Arrays.toString(num));
			makeMap();
			return;
		}
		for(int i=0; i<4; i++) {
			num[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	private static void makeMap() {
		copy = new int[N][M];
		for(int i=0; i<cctv; i++) {
			fillMap(num[i], list.get(i).n, i);
		}
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(copy[r][c] == 0) {
					cnt++;
				}
			}	
		}
		if(min > cnt) {
			min = cnt;
		}
	}

	private static void fillMap(int dir, int cam, int i) {
		int r = list.get(i).r;
		int c = list.get(i).c;
		if(cam == 5) {
			fillUp(r, c);
			fillDown(r, c);
			fillLeft(r, c);
			fillRight(r, c);
		}else {
			switch (dir) {
			case 0:// 상
				switch (cam) {
				case 1:
					fillUp(r, c);
					break;
				case 2:
					fillUp(r, c);
					fillDown(r, c);
					break;
				case 3:
					fillUp(r, c);
					fillLeft(r, c);
					break;
				case 4:
					fillUp(r, c);
					fillLeft(r, c);
					fillDown(r, c);
					break;
				}
				break;
			case 1: // 하
				switch (cam) {
				case 1:
					fillDown(r, c);
					break;
				case 2:
					fillUp(r, c);
					fillDown(r, c);
					break;
				case 3:
					fillLeft(r, c);
					fillDown(r, c);
					break;
				case 4:
					fillLeft(r, c);
					fillDown(r, c);
					fillRight(r, c);
					break;
				}
				break;
			case 2: // 좌
				switch (cam) {
				case 1:
					fillLeft(r, c);
					break;
				case 2:
					fillLeft(r, c);
					fillRight(r, c);
					break;
				case 3:
					fillDown(r, c);
					fillRight(r, c);
					break;
				case 4:
					fillDown(r, c);
					fillRight(r, c);
					fillUp(r, c);
					break;
				}
				break;
			case 3: // 우
				switch (cam) {
				case 1:
					fillRight(r, c);
					break;
				case 2:
					fillLeft(r, c);
					fillRight(r, c);
					break;
				case 3:
					fillRight(r, c);
					fillUp(r, c);
					break;
				case 4:
					fillRight(r, c);
					fillUp(r, c);
					fillLeft(r, c);
					break;
				}
				break;
			}
		}
	}
	static void fillUp(int r, int c) {
		copy[r][c] = 1;
		int nr = r+dr[0];
		if(isIn(nr, c) && map[nr][c] != 6) {
			fillUp(nr, c);
		}
		
	}
	static void fillDown(int r, int c) {
		copy[r][c] = 1;
		int nr = r+dr[1];
		if(isIn(nr, c) && map[nr][c] != 6) {
			fillDown(nr, c);
		}
	}
	static void fillLeft(int r, int c) {
		copy[r][c] = 1;
//		System.out.println(r + " : " + c);
		int nc = c+dc[2];
		if(isIn(r, nc) && map[r][nc] != 6) {
			fillLeft(r, nc);
		}
	}
	static void fillRight(int r, int c) {
		copy[r][c] = 1;
		int nc = c+dc[3];
		if(isIn(r, nc) && map[r][nc] != 6) {
			fillRight(r, nc);
		}
	}
	
	static class CCTV{
		int r;
		int c;
		int d;
		int n;
		public CCTV(int r, int c, int d, int n) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.n = n;
		}
		@Override
		public String toString() {
			return "CCTV [r=" + r + ", c=" + c + ", d=" + d + ", n=" + n + "]";
		}
	}
	
	static String src =
			"3 7\r\n" + 
			"4 0 0 0 0 0 0\r\n" + 
			"0 0 0 2 0 0 0\r\n" + 
			"0 0 0 0 0 0 4";
}
