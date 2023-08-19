package com.codingtest.bro.kakaobank;

public class Q2 {
	static int r = 2;
	static int[][] needs = {
			{1,0,0},
			{1,1,0},
			{1,1,0},
			{1,0,1},
			{1,1,0},
			{0,1,1}
			};
	public static void main(String[] args) {
		int answer = solution(needs, r);
		System.out.println(answer);
	}
	private static int solution(int[][] needs, int r) {
		int answer = 0;
		result = new int[needs[0].length];
		combination(0,0, needs[0].length);
		answer = max;
		return answer;
	}
	static int result[];
	static int max;
	private static void combination(int start, int cnt, int N) {
		if(cnt == r) {
			int sum = 0;
			outer : for(int i=0; i<needs.length; i++) {
				for(int j=0; j<N; j++) {
					if(needs[i][j] == 1 && result[j] != 1) {
						continue outer;
					}
				}
				sum++;
			}
			if(sum > max) {
				max = sum;
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			result[i] = 1;
			combination(i+1, cnt+1, N);
			result[i] = 0;
		}
		
	}
}
