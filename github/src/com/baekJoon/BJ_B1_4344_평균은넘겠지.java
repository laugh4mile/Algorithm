package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 8. 3
 * @see https://www.acmicpc.net/problem/4344
 * @mem 14800KB
 * @time 124ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항] 
 */

public class BJ_B1_4344_평균은넘겠지 { 
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int T,N, score[];
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int testCase=0; testCase<T; testCase++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			score = new int[N];
			int sum=0;
			for(int i=0; i<N; i++) {
				score[i] = Integer.parseInt(tokens.nextToken());
				sum += score[i];
			}
//			System.out.println(Arrays.toString(score));
			double avg = (double)sum/N;
//			System.out.println(avg);
			int overStudent =0;
			for(int i=0; i<N; i++) {
				if(score[i]>avg) {
					overStudent++;
				}
			}
//			System.out.println(overStudent);
			double result = (overStudent/(double)N)*100;
			System.out.printf("%.3f%%\n",result);
			
		}
	}
//	static String src = "5\r\n" + 
//			"5 50 50 70 80 100\r\n" + 
//			"7 100 95 90 80 70 60 50\r\n" + 
//			"3 70 90 80\r\n" + 
//			"3 70 90 81\r\n" + 
//			"9 100 99 98 97 96 95 94 93 91";
}
