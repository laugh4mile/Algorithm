package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15683_감시 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,map[][], cctv, num[];
	static List<CCTV> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] != 0 && map[r][c] != 6) {
					cctv++;
					list.add(new CCTV(r, c, 0, map[r][c]));
				}
			}	
		}
		num = new int[cctv];
		
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println(cctv);
		permutation(0);
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
	
	static int dr[] = {0,1,-1,0};
	static int dc[] = {1,0,0,-1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
	private static void makeMap() {
		for(int i=0; i<cctv; i++) {
			
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
			"6 6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 2 0 0 0 0\r\n" + 
			"0 0 0 0 6 0\r\n" + 
			"0 6 0 0 2 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 5";
}
