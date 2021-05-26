package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_12886_돌그룹2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static boolean isVisited[][] = new boolean[1000][1000];
	static int stones[] = new int[3];
	static boolean answer;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<3; i++) {
			stones[i] = Integer.parseInt(tokens.nextToken());
			sum += stones[i];
		}
		Arrays.sort(stones);
		dfs(stones);
		System.out.println(answer);
	}
	
	private static void dfs(int[] stones) {
		if(stones[0] == stones[1] && stones[1] == stones[2]) {
			answer = true;
			return;
		}
		isVisited[stones[0]][stones[1]] = true;
		isVisited[stones[1]][stones[0]] = true;
		isVisited[stones[0]][stones[2]] = true;
		isVisited[stones[2]][stones[0]] = true;
		isVisited[stones[1]][stones[2]] = true;
		isVisited[stones[2]][stones[1]] = true;
		
		if(stones[0]!=stones[1]) {
			int temp = stones[0];
			stones[0] = temp * 2;
			stones[1] = stones[1] - temp;
			Arrays.sort(stones);
			if(!isVisited[stones[0]][stones[1]]) {
				dfs(stones);
			}
		}
	}

	static String src =
			"1 1 2";
}












