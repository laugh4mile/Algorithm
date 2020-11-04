package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 8. 6
 * @see https://www.acmicpc.net/status?user_id=laugh4mile&problem_id=1931&from_mine=1
 * @mem 44132KB
 * @time 504ms
 * @caution #정렬 #그리디
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

public class BJ_S2_1931_회의실배정 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static StringTokenizer tokens;
	static int meetings[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		meetings = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			meetings[i][0] = Integer.parseInt(tokens.nextToken());
			meetings[i][1] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(meetings, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int cnt=1, time=meetings[0][1];
		for(int i=1; i<N; i++) {
			
			if(time <= meetings[i][0]) {
				time = meetings[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static String src = "11\r\n" + 
			"1 4\r\n" + 
			"3 5\r\n" + 
			"0 6\r\n" + 
			"5 7\r\n" + 
			"3 8\r\n" + 
			"5 9\r\n" + 
			"6 10\r\n" + 
			"8 11\r\n" + 
			"8 12\r\n" + 
			"2 13\r\n" + 
			"12 14";
}
