package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_12886_돌그룹 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static boolean isVisited[][][] = new boolean[1000][1000][1000];
	static int stones[] = new int[3];
	static boolean answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<3; i++) {
			stones[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(stones);
		
		dfs(stones);
		System.out.println(answer);
	}
	

	private static void dfs(int[] stones) {
		isVisited[stones[0]][stones[1]][stones[2]] = true;
		if(stones[0]==stones[1] && stones[1]==stones[2]) {
			answer = true;
			return;
		}
		
		if(stones[0]!=stones[1]) {
			int temp = stones[0];
			stones[0] = stones[0] * 2;
			stones[1] = stones[1] - temp;
			Arrays.sort(stones);
			if(!isVisited[stones[0]][stones[1]][stones[2]]) {
				dfs(stones);
			}
		}
		if(answer) {
			return;
		}
		if(stones[1]!=stones[2]) {
			int temp = stones[1];
			stones[1] = stones[1] * 2;
			stones[2] = stones[2] - temp;
			Arrays.sort(stones);
			if(!isVisited[stones[0]][stones[1]][stones[2]]) {
				dfs(stones);
			}
		}
		if(answer) {
			return;
		}
		if(stones[2]!=stones[0]) {
			int temp = stones[0];
			stones[0] = stones[0] * 2;
			stones[2] = stones[2] - temp;
			Arrays.sort(stones);
			if(!isVisited[stones[0]][stones[1]][stones[2]]) {
				dfs(stones);
			}
		}
		if(answer) {
			return;
		}
	}


	static String src =

			"1 1 2";
}












