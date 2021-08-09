package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_17779_게리맨더링2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], temp[][], minChai = Integer.MAX_VALUE, populration[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}

		populration = new int[6];
		temp = new int[N][N];
		// 4중 포문밖에 답이 없을거같은데.. 
		for(int d1=1; d1<N/2; d1++) {
			for(int d2=1; d2<N/2; d2++) {
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						// 경계선의 꼭지점을 보고 유효한지 판별
						for(int i=0; i<N; i++) {
							for(int j=0; j<N; j++) {
								temp[i][j] = 0;
							}
						}
						if(!isIn(r-d1, c+d1)) continue; // 상
						if(!isIn(r-d1+d2, c+d1+d2)) continue; // 우
						if(!isIn(r+d2, c+d2)) continue; // 하
						section5(r,c,d1,d2);
						section(r, c, d1, d2);
						Arrays.fill(populration, 0);
						getPopulation();
						if(minChai > getMin()) {
							minChai = getMin();
						}
					}
				}
			}
		}
		System.out.println(minChai);
	}
	
	private static int getMin() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=5; i++) {
			if(min > populration[i]) {
				min = populration[i];
			}
			if(max < populration[i]) {
				max = populration[i];
			}
		}
		return max - min;
	}

	private static void getPopulation() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				for(int k=1; k<=5; k++) {
					if(temp[r][c] == k) {
						populration[k] += map[r][c];
						break;
					}
				}
			}	
		}
	}

	private static void section(int r, int c, int d1, int d2) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(temp[i][j] != 0) continue;
				if(i<r && j<=c+d1) {
					temp[i][j] = 1;
				}else if(i<=r-d1+d2 && j>c+d1) {
					temp[i][j] = 2;
				}else if(i>=r && j<c+d2) {
					temp[i][j] = 3;
				}else {
					temp[i][j] = 4;
				}
			}
		}
	}
	
	private static void section5(int r, int c, int d1, int d2) {
//		System.out.println(r+" "+c+" "+d1+" "+d2);
		for(int i=r-d1; i<=r+d2; i++) { 
			for(int j=c; j<=c+d1+d2; j++) { 
				temp[i][j] = 5;
			}	
		}
		int td1 = d1;
		for(int i=r-d1; i<r; i++) { // 좌상
			for(int j=0; j<td1; j++) {
				temp[i][c+j] = 0;
			}
			td1--;
		}
		int td2 = d2;
		for(int i=r-d1; i<r-d1+d2; i++) { // 우상
			for(int j=0; j<td2; j++) {
				temp[i][c+d1+d2-j] = 0;
			}
			td2--;
		}
		int td3 = 0;
		for(int i=r+1; i<=r+d2; i++) { // 좌하
			for(int j=0; j<=td3; j++) {
				temp[i][c+j] = 0;
			}
			td3++;
		}
		int td4 = 0;
		for(int i=r-d1+d2+1; i<=r+d2; i++) { // 우하
			for(int j=0; j<=td4; j++) {
				temp[i][c+d1+d2-j] = 0;
			}
			td4++;
		}
	}
	static boolean isIn(int r, int c) {
		return(r>=0 && c>=0 && r<N && c<N);
	}
	
	static String src =
			"8\r\n" + 
			"1 2 3 4 5 6 7 8\r\n" + 
			"2 3 4 5 6 7 8 9\r\n" + 
			"3 4 5 6 7 8 9 1\r\n" + 
			"4 5 6 7 8 9 1 2\r\n" + 
			"5 6 7 8 9 1 2 3\r\n" + 
			"6 7 8 9 1 2 3 4\r\n" + 
			"7 8 9 1 2 3 4 5\r\n" + 
			"8 9 1 2 3 4 5 6";
}
