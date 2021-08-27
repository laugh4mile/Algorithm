package com.codingtest.mobis21;

import java.util.Arrays;

public class Q1 {
	static int [][] dice = 
		{
			{1, 6, 2, 5, 3, 4}, 
			{9, 9, 1, 0, 7, 8}
		};
	public static void main(String[] args) {
		int answer = solution(dice);
		System.out.println(answer);
	}
	
	private static int solution(int[][] dice) {
		int answer = 0;
		boolean isExist[] = new boolean[(int)Math.pow(10, dice.length)];
		
		for(int i=1; i<=dice.length; i++) { // i = dice의 수
			int result[] = new int[i]; 
			combi1(0,0,i,dice,result);
		}
//		System.out.println(Arrays.toString(isExist));
		return answer;
	}

	private static void combi1(int start, int cnt, int R, int dice[][], int result[]) {
		if(cnt==R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int r=0; r<dice.length; r++) {
			for(int c=0; c<dice[0].length; r++) {
				
			}	
		}
		for(int i=0; i<6; i++) {
			result[cnt] = dice[cnt][i];
			combi1(i+1, cnt+1, R, dice, result);
		}
	}


	
}
