package com.codingtest.bro.naver.financial;

import java.util.Arrays;

public class Q4 {
	static int[][] board = {{1,-7,-2,1,-1},{2,3,0,-1,-2},{1,-1,6,-1,-2},{-1,1,-2,0,4},{-10,5,-3,-1,1}};
	public static void main(String[] args) {
		int[] answer = solution(board);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int[][] board){
		int[] answer = {};
		int n = board.length;
		int dp[][] = new int[n][n];
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<n; i++) {
			sum1 += board[0][i];
			if(board[0][i] == 0) {
				sum1 = Math.max(sum1, -sum1);
			}
			dp[0][i] = sum1;
			
			sum2 += board[i][0];
			dp[i][0] = sum2;
		}
		return answer;
	}
	
	static class Node{
		int r;
		int c;
		
	}
}
