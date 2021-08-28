package com.codingtest.ebay;

public class Q3 {
	static int[] prices = {1,5,7,8,9,5,1,58,6,8,4,2,3};
	public static void main(String[] args) {
		int answer = solution(prices);
		System.out.println(answer);
	}

    public static int solution(int[] prices) {
    	getMax(prices, 0, 0, 0);
    	return max;
    }
    static int max;
	private static void getMax(int[] prices, int idx, int cnt, int money) {
		if(money > max) {
			max = money;
		}
		if(idx >= prices.length) {
			return;
		}
		// 구매할 경우
		if(cnt<2) {
			getMax(prices, idx+1, cnt+1, money-prices[idx]);
		}
		// 판매할 경우
		if(cnt>0) {
			getMax(prices, idx+1, cnt-1, money+prices[idx]);
		}
		// 아무것도 안할 경우
		getMax(prices, idx+1, cnt, money);
	}
}







