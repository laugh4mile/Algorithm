package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 12. 3
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 1) 순열
 * 2) 규영이가 이기는 경우임
 * [입력사항]
 * [출력사항]
 */

public class SWEA_D3_6808_규영이와인영이의카드게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, gy[], iy[], result[], cntWin;
	static boolean isSelected[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			gy = new int[9];
			iy = new int[9];
			result = new int[9];
			isSelected = new boolean[19];
			for(int i=0; i<9; i++) {
				gy[i] = Integer.parseInt(tokens.nextToken());
			}
			int cnt = 0;
			for(int i=1; i<=18; i++) {
				boolean isUsed = false;
				for(int j=0; j<9; j++) {
					if(gy[j]==i) {
						isUsed = true;
					}
				}
				if(!isUsed) {
					iy[cnt++] = i;
				}
			}
			
			permutation(0,0);
			
			System.out.println("#"+t+" "+ cntWin+ " "+ (362880-cntWin));
			
			cntWin = 0;
		}
	}

	private static void permutation(int start, int cnt) {
		if(cnt == 9) {
//			System.out.println(Arrays.toString(result));
			boolean gyWin = compare(result);
			
			if(gyWin) {
				cntWin++;
			}
			
			return;
		}
		for(int i=0; i<9; i++) {
			if(isSelected[i]) continue;
			result[cnt] = iy[i];
			
			isSelected[i] = true;
			permutation(start+1, cnt+1);
			isSelected[i] = false;
			
		}
	}

	private static boolean compare(int[] result) {
		int gyScore = 0;
		int iyScore = 0;
		for(int i=0; i<9; i++) {
			if(gy[i] > result[i]) {
				gyScore += gy[i]+result[i];
			}else {
				iyScore += gy[i]+result[i];
			}
		}
		
		if(gyScore > iyScore) {
			return true;
		}else {
			return false;
		}
	}

	static String src =
			"4\r\n" + 
			"1 3 5 7 9 11 13 15 17\r\n" + 
			"18 16 14 12 10 8 6 4 2\r\n" + 
			"13 17 9 5 18 7 11 1 15\r\n" + 
			"1 6 7 9 12 13 15 17 18";
}
