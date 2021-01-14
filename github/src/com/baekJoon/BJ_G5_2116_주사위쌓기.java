package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2021. 1. 15
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 첫번째 주사위를 놓는 경우는 3가지이다.
 * 	1. A나 F
 * 	2. B나 D
 * 	3. C나 E
 * 1을 고를 시
 * 	int 윗면 = dice1.F = 4
 * 	다음 주사위로 넘어감 -> dice.get(next).
 * [입력사항]
 * [출력사항]
 */

public class BJ_G5_2116_주사위쌓기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][];
	static boolean isChecked[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][6];
		isChecked = new boolean[7];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<6; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		int max = 0;
		for(int t=0; t<6; t++) {
			int floor = map[0][t];
			int ceiling = 0;
			int fIndex = t;
			int cIndex = 0;
			int sum = 0;
			if(fIndex == 0) {
				ceiling = map[0][5];
				cIndex = 5;
			}else if (fIndex == 1) {
				ceiling = map[0][3];
				cIndex = 3;
			}else if (fIndex == 2) {
				ceiling = map[0][4];
				cIndex = 4;
			}else if (fIndex == 3) {
				ceiling = map[0][1];
				cIndex = 1;
			}else if (fIndex == 4) {
				ceiling = map[0][2];
				cIndex = 2;
			}else if (fIndex == 5) {
				ceiling = map[0][0];
				cIndex = 0;
			}
			for(int c=0; c<6; c++) {
				if(c != fIndex && c!= cIndex) {
					if(map[0][c] > sum) {
						sum = map[0][c];
					}
				}
			}
			floor = ceiling;
			for(int r=1; r<N; r++) {
				for(int c=0; c<6; c++) {
					if(map[r][c]==floor) {
						fIndex = c;
						break;
					}
				}
				if(fIndex == 0) {
					ceiling = map[r][5];
					cIndex = 5;
				}else if (fIndex == 1) {
					ceiling = map[r][3];
					cIndex = 3;
				}else if (fIndex == 2) {
					ceiling = map[r][4];
					cIndex = 4;
				}else if (fIndex == 3) {
					ceiling = map[r][1];
					cIndex = 1;
				}else if (fIndex == 4) {
					ceiling = map[r][2];
					cIndex = 2;
				}else if (fIndex == 5) {
					ceiling = map[r][0];
					cIndex = 0;
				}
				int val = 0;
				for(int c=0; c<6; c++) {
					if(c != fIndex && c!= cIndex) {
						if(map[r][c] > val) {
							val = map[r][c];
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
