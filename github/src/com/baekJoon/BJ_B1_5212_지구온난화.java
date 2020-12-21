package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B1_5212_지구온난화 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,map2[][];
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		map2 = new int[R][C];
		for(int r=0; r<R; r++) {
			String line = input.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c] == 'X') {
					for(int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if(isIn(nr, nc) && map[nr][nc] == 'X') {
							map2[r][c] ++;
						}
					}
				}
			}	
		}
		int minR = 10, minC = 10;
		int maxR = 0, maxC = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map2[r][c] < 2) {
					map[r][c] = '.';
				}else {
					if(maxR < r) {
						maxR = r;
					}
					if(maxC < c) {
						maxC = c;
					}
					if(minR > r) {
						minR = r;
					}
					if(minC > c) {
						minC = c;
					}
				}
			}	
		}
//		System.out.println(minR+" " + minC);
//		System.out.println(maxR+" " + maxC);
//		for(char x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		for(int r=minR; r<=maxR; r++) {
			for(int c=minC; c<=maxC; c++) {
				System.out.print(map[r][c]);
			}	
			System.out.println();
		}
	}
	
	static boolean isIn (int r, int c) {
		return (r>=0 && c>=0 && r<R && c<C);
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	
	static String src =
			"3 10\r\n" + 
			"..........\r\n" + 
			"..XXX.XXX.\r\n" + 
			"XXX.......";
}
