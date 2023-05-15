package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;


public class BJ_G5_2116_주사위쌓기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, dice[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		dice = new int[N][6];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<6; c++) {
				dice[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}

		int max = 0;
		for(int t=0; t<6; t++) {
			int floor = dice[0][t];
			int ceiling = 0;
			int fIndex = t;
			int cIndex = 0;
			int sum = 0;
			if(fIndex == 0) {
				ceiling = dice[0][5];
				cIndex = 5;
			}else if (fIndex == 1) {
				ceiling = dice[0][3];
				cIndex = 3;
			}else if (fIndex == 2) {
				ceiling = dice[0][4];
				cIndex = 4;
			}else if (fIndex == 3) {
				ceiling = dice[0][1];
				cIndex = 1;
			}else if (fIndex == 4) {
				ceiling = dice[0][2];
				cIndex = 2;
			}else if (fIndex == 5) {
				ceiling = dice[0][0];
				cIndex = 0;
			}
			for(int c=0; c<6; c++) {
				if(c != fIndex && c!= cIndex) {
					if(dice[0][c] > sum) {
						sum = dice[0][c];
					}
				}
			}
			floor = ceiling;
			for(int r=1; r<N; r++) {
				for(int c=0; c<6; c++) {
					if(dice[r][c]==floor) {
						fIndex = c;
						break;
					}
				}
				if(fIndex == 0) {
					ceiling = dice[r][5];
					cIndex = 5;
				}else if (fIndex == 1) {
					ceiling = dice[r][3];
					cIndex = 3;
				}else if (fIndex == 2) {
					ceiling = dice[r][4];
					cIndex = 4;
				}else if (fIndex == 3) {
					ceiling = dice[r][1];
					cIndex = 1;
				}else if (fIndex == 4) {
					ceiling = dice[r][2];
					cIndex = 2;
				}else if (fIndex == 5) {
					ceiling = dice[r][0];
					cIndex = 0;
				}
				int val = 0;
				for(int c=0; c<6; c++) {
					if(c != fIndex && c!= cIndex) {
						if(dice[r][c] > val) {
							val = dice[r][c];
						}
					}
				}
				sum += val;
				floor = ceiling;
			}
			if(max < sum) {
				max = sum;
			}
		}
		System.out.println(max);
	}

	static String src =
			"5\r\n" + 
			"2 3 1 6 5 4\r\n" + 
			"3 1 2 4 6 5\r\n" + 
			"5 6 4 1 3 2\r\n" + 
			"1 3 6 2 4 5\r\n" + 
			"4 1 6 5 2 3";
}
