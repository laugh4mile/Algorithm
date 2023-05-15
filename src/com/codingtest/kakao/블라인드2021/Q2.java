package com.codingtest.kakao.블라인드2021;

import java.util.StringTokenizer;

public class Q2 {
	static int n = 437674;
	static int k = 3;
	public static void main(String[] args) {
		
		int answer = solution(n, k);
		System.out.println(answer);
	}
	
	public static int solution(int n, int k) {
		int answer = 0;
		String strNum = Integer.toString(n, k);
		StringTokenizer tokens = new StringTokenizer(strNum,"0");
		while(tokens.hasMoreTokens()) {
			String s = tokens.nextToken();
			if(checkPrime(Long.parseLong(s))) {
				answer++;	
			}
		}
		return answer;
	}
	
	private static boolean checkPrime(long num) {
		if(num == 1) return false;
		for(long i=2; i*i<=num; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}
