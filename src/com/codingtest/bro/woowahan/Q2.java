package com.codingtest.bro.woowahan;

import java.util.Arrays;

public class Q2 {
	static int n = 4;
	public static void main(String[] args) {
		int[] answer = solution(n);
		
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int n) {
		int size = 1;
		for(int i=1; i<n; i++) {
			size += 6*(n-i);
		}
		int[] answer = new int[size];
		
		int lv = n; // 최외각 = n 
		int layer = 0;
		
		// 왼쪽 위 채우기
		int idx = layer+6*(lv-1) +1;
		for(int i=0; i<lv; i++) {
			answer[idx] = i+1;
			idx += i+2;
		}
		// 오른쪽 위 채우기
		// 오른쪽 채우기
		return answer;
	}
}
