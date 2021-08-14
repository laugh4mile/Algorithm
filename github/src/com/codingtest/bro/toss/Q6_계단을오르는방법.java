package com.codingtest.bro.toss;

import java.io.IOException;

public class Q6_계단을오르는방법 {
	static int numOfStairs = 70;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution(numOfStairs));
	}
	private static long solution(int numOfStairs) {
		long answer = 0;
		
		dfs(0,numOfStairs);
		answer = cnt;
		return answer;
	}
	
	static long cnt = 0;
	
	private static void dfs(int cur, int numOfStairs) {
		if(cur > numOfStairs) {
			return;
		}
		if(cur == numOfStairs) {
			cnt++;
			return;
		}
		
		for(int i=1; i<=3; i++) {
			dfs(cur+i, numOfStairs);
		}
	}

}
