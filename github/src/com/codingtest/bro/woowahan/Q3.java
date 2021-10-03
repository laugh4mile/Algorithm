package com.codingtest.bro.woowahan;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
	static int[][] money = {{100,3},{200,1},{50,2}};
//	static int[][] money = {{2500,3},{700,5}};
	public static void main(String[] args) {
		int answer = solution(money);
		System.out.println(answer);
	}
	private static int solution(int[][] money) {
		int answer = -1;
		int total = 0;
		boolean isZero = true;
		
		for(int i=0; i<money.length; i++) {
			total += money[i][0] * money[i][1];
			if(money[i][1]%2 == 1) {
				isZero = false;
			} 
		}
		
		if(isZero) { // 전부다 짝수개씩 가지고 있을 경우
			return 0;
		}
		System.out.println(total);

		int minChai = Integer.MAX_VALUE;
		
		
		return answer;
	}
}















