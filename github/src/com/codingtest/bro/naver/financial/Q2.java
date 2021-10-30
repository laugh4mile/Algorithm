package com.codingtest.bro.naver.financial;

import java.util.Arrays;

public class Q2 {
	static int n;
	static int jump;
	public static void main(String[] args) {
		int[] answer = solution(n, jump);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int n, int jump){
		int[] answer = {};
		int[][] map = new int[n][n];
		
		map[0][0] = 1;
		for(int i=0; i<n; i++) {
			
		}
		return answer;
	}
}
