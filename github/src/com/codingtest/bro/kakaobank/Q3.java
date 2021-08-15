package com.codingtest.bro.kakaobank;

import java.io.IOException;

public class Q3 {
	/**
	 * 시세가 0인 날에는 반드시 사야겠다. 하지만 사더라도 못팔 수 있지. 마지막 날 시세가 0일 수 있으니.
	 * 결국은 길이가 100이니 모든 경우의 수를 다 따져야 할것이다.
	 * 
	 * 일단 가장 먼저! 돈이 없으니 첫 탐색에서 0이 나오면 바로 구매 해야 한다.
	 * 0. 총 돈 money=0, 총 돌 stones=0 초기화
	 * 1. 해당 날짜에서 시세가 0일경우와 0이 아닐경우로 나눈다
	 * 1-1. 0일 경우 무조건 산다. stones+1
	 * 1-2. 0이 아닐경우 stones가 있는 경우와 없는 경우로 나눈다.
	 * 
	 * 가정 1. stones가 여러개 일때 한번에 다팔아야하나 분할해서 팔아야 하나? 다 팔아야겠지?
	 * 무조건 해당 날짜에서 산다 or 아무것도 안한다 or 판다 밖에 없다고 가정한다. 여기서 판다 = 풀매도
	 * 
	 */
//	static int[] price = {0,1,2,0,1,2,0,1,2,0,1,2,4,2,3,1,2,3,4,5,6,7,3,1,1,3,2};
//	static int[] price = {0,1,2};
//	static int[] price = {1,0,0};
//	static int[] price = {0,2,1,1,2};
	static int[] price = {1,2,0};
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
	private static void game(int day, int money, int stones) {
		// 0. n일이 되면 최대 차익을 계산한다.
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
			}else {
				// 3. 해당 날의 돌을 살 돈이 있어도 안사고 넘어갈 수 있다.
				game(day+1, money, stones);
				// 4. 물론 사고 넘어갈 수도 있지.
				game(day+1, money-price[day], stones+1);
			}
			
			// 5. 돌이 있을 경우 풀매도
			if(stones > 0) {
				game(day+1, money+(price[day]*stones), 0);
			}else {
				// 6. 돌이 없을 경우 다음날로
				game(day+1, money, stones);
			}
		}
		
	}
}
