package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
/**
 * @author yhs
 * @date 2020. 8. 2
 * @see https://www.acmicpc.net/problem/3040
 * @mem 12940 KB
 * @time 80 ms
 * @caution #부분집합
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class BJ_B2_3040_백설공주와일곱난쟁이 {

	static int[] cap;
	static int[] result;
	static int sum;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		cap = new int[9];
		result = new int[7];
//		input = new BufferedReader(new StringReader(src));
		for(int i=0; i<9; i++) {
			cap[i] = Integer.parseInt(input.readLine());
		}
		combination(0,0);
		
	}
	
	private static void combination(int start, int cnt) {
		if(cnt == 7) {
			for(int i=0; i<7; i++) {
				sum += result[i];
			}
			if(sum == 100) {
				for(int i=0; i<7; i++) {
					System.out.println(result[i]);
				}
			}
			sum = 0;
			return;
		}
		for(int i=start; i<9; i++) {
			result[cnt] = cap[i];
			combination(i+1, cnt+1);
		}
	}
//	static String src= "7\r\n" + 
//			"8\r\n" + 
//			"10\r\n" + 
//			"13\r\n" + 
//			"15\r\n" + 
//			"19\r\n" + 
//			"20\r\n" + 
//			"23\r\n" + 
//			"25";
}
