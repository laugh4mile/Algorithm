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
 * @date 2021. 6. 26
 * @see https://www.acmicpc.net/problem/9466
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class BJ_G4_9466_텀프로젝트2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, N, nums[];
	static boolean isVisited[], isTeamed[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(input.readLine());
			nums = new int[N+1];
			tokens = new StringTokenizer(input.readLine());
			isTeamed = new boolean[N+1];
			
			for(int i=1; i<N+1; i++) {
				int num = Integer.parseInt(tokens.nextToken());
				nums[i] = num;
				if(i == num) {
					isTeamed[num] = true;
				}
			}
			
			for(int i=1; i<N+1; i++) {
				isVisited = new boolean[N+1];
				if(!isTeamed[i]) {
					checkCycle(i);
				}
			}
			
			int answer = 0;
			for(int i=1; i<N+1; i++) {
				if(!isTeamed[i]) {
					answer++;
				}
			}
			System.out.println(answer);
		}
	}

	private static void checkCycle(int i) {
		if(isTeamed[i]) return;
		
		isVisited[i] = true;
		if(!isVisited[nums[i]]) {
			checkCycle(nums[i]);
		}else {
			if(!isTeamed[nums[i]]) {
				marking(i);
			}
		}
		
	}

	private static void marking(int i) {
		if(!isTeamed[i]) {
			isTeamed[i] = true;
			marking(nums[i]);
		}
	}
	static String src =
			"2\n"
			+ "7\n"
			+ "3 1 3 7 3 4 6\n"
			+ "8\n"
			+ "1 2 3 4 5 6 7 8";
}
