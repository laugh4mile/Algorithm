package com.codingtest.bro.kakaobank;

import java.io.IOException;
import java.util.Arrays;

public class Q5 {
	static int[] prices = {5,3,7,9,5,2,4,9,10,6};
//	static int[] prices = {5,4,3,2,1,2,3,4,5};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer[] = new int[prices.length];
		answer = solution(prices);
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(int[] prices) {
		int answer[] = {};
		answer = new int[prices.length];
		int cnt;
		for(int i=0; i<prices.length-1; i++) {
			cnt = 0;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[j] > prices[i]) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		return answer;
	}
}
