package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author yhs
 * @date 2020. 8. 3
 * @see https://www.acmicpc.net/problem/8958
 * @mem 13140KB
 * @time 88ms
 * @caution #완전탐색
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

public class BJ_B2_8958_OX퀴즈 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int T,N;
	static char[] ox;
	static int[] score;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int testCase=0; testCase<T; testCase++) {
			String line = input.readLine();
			N = line.length();
			ox = new char[N];
			score = new int[N];
			for(int i=0; i<N; i++) {
				ox[i] = line.charAt(i);
				if(ox[i] == 'O') {
					score[i] = 1;
				}
			}
//			System.out.println(Arrays.toString(score));
			for(int i=1; i<N; i++) {
				for(int j=i-1; j>=0; j--) {
					if(ox[i]=='O') {
						if(ox[j] == 'O') {
							score[i]++;
						}else {
							break;
						}
					}
					
				}
			}
			int sum=0;
			for(int i=0; i<N; i++) {
				sum+=score[i];
			}
			System.out.println(sum);
		}
	}
//	static String src = "5\r\n" + 
//			"OOXXOXXOOO\r\n" + 
//			"OOXXOOXXOO\r\n" + 
//			"OXOXOXOXOXOXOX\r\n" + 
//			"OOOOOOOOOO\r\n" + 
//			"OOOOXOOOOXOOOOX";

}
