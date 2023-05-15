package com.codingtest.bro.kakaobank;

import java.io.IOException;

public class Q33 {
	
//	static int[] price = {0,1,2,0,1,2,0,1,2,0,1,2,4,2,3,1,2,3,4,5,6,7,3,1,1,3,2};
//	static int[] price = {1,2,0};
//	static int[] price = {0,1,2};
	static int[] price = {1,0,0};
//	static int[] price = {0,2,1,1,2};
	static int n = price.length;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = solution(n, price);
		System.out.println(answer);
	}
	private static int solution(int n, int[] price) {
		int answer = -1;
		game(0,0,0); // 현재날짜, 돈, 돌
		answer = max;
		return answer;
	}
	static int max;
	static int[] cut = new int[101];
	private static void game(int day, int money, int stones) {
		// 0. n일이 되면 최대 차익을 계산한다.
		if(cut[day] <= money) {
			cut[day] = money;
		}else {
			return;
		}
		if(day >= n) {
			if(money > max) {
				max = money;
			}
			return;
		}
		
		// 1. 시세가 0이면 무조건 사야한다. 불변의 진리.
		if(price[day] == 0) {
			game(day+1, money, stones+1);
		}else {
			// 2. 해당 날의 돌을 살 돈이 없으면 다음날로 간다.
			if(money < price[day]) {
				game(day+1, money, stones); 
				// 3. 돈은 없지만 돌은 있는경우 판다.
				if(stones>0) {
					game(day+1, money+(price[day]*stones), 0);
				}
			}else {
				// 3. 산다
				game(day+1, money-price[day], stones+1);
				// 4. 판다
				if(stones>0) {
					game(day+1, money+(price[day]*stones), 0);
				}
				// 5. 아무것도 안한다.
				game(day+1, money, stones);
			}
		}
	}
}
