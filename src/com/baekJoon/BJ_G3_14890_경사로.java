package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G3_14890_경사로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, L, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		int answer = 0;
		outer : for(int r=0; r<N; r++) {
			int [] line = new int[N];
			boolean [] flag = new boolean[N];
			for(int c=0; c<N; c++) {
				line[c] = map[r][c];
			}
			
			for(int i=0; i<N-1; i++) {
				if(Math.abs(line[i]-line[i+1]) > 1) { 
					continue outer;
				}else {
					if(line[i]-line[i+1] == 1) { // 번개모양
						int layer = line[i+1];
						for(int d=1; d<=L; d++) {
							int ni = i+d;
							if(isIn(ni)) {
								if(line[ni] != layer) {
									continue outer;
								}
							}else {
								continue outer;
							}
							flag[ni] = true;
						}
					}
				}
			}
			
			for(int i=N-1; i>0; i--) {
				if(line[i]-line[i-1] == 1) { // 번개모양
					int layer = line[i-1];
					for(int d=1; d<=L; d++) {
						int ni = i-d;
						if(isIn(ni) && !flag[ni]) {
							if(line[ni] != layer) {
								continue outer;
							}
						}else {
							continue outer;
						}
					}
				}
			}
			answer++;
		}
		
		outer : for(int c=0; c<N; c++) {
			int [] line = new int[N];
			boolean [] flag = new boolean[N];
			for(int r=0; r<N; r++) {
				line[r] = map[r][c];
			}
			for(int i=0; i<N-1; i++) {
				if(Math.abs(line[i]-line[i+1]) > 1) { 
					continue outer;
				}else {
					if(line[i]-line[i+1] == 1) { // 번개모양
						int layer = line[i+1];
						for(int d=1; d<=L; d++) {
							int ni = i+d;
							if(isIn(ni)) {
								if(line[ni] != layer) {
									continue outer;
								}
							}else {
								continue outer;
							}
							flag[ni] = true;
						}
					}
				}
			}
			
			for(int i=N-1; i>0; i--) {
				if(line[i]-line[i-1] == 1) { // 번개모양
					int layer = line[i-1];
					for(int d=1; d<=L; d++) {
						int ni = i-d;
						if(isIn(ni) && !flag[ni]) {
							if(line[ni] != layer) {
								continue outer;
							}
						}else {
							continue outer;
						}
					}
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
	
	static boolean isIn(int n) {
		return (n>=0 && n<N);
	}
	
	static String src =
			"6 1\r\n" + 
			"3 2 1 1 2 3\r\n" + 
			"3 2 2 1 2 3\r\n" + 
			"3 2 2 2 3 3\r\n" + 
			"3 3 3 3 3 3\r\n" + 
			"3 3 3 3 2 2\r\n" + 
			"3 3 3 3 2 2";
}
