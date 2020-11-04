package com.base;

import java.util.Arrays;

public class P1_PermutationTest {

	private static int N = 4, R = 2;
	private static int[] numbers; // 순열 저장 배열
	private static boolean[] isSelected;
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1]; // boolean은 디폴트값이 false 
		permutation(0);
	}
	
	//지정된 자리에 순열 뽑기
	private static void permutation(int cnt) { // cnt : 현재까지 뽑은 순열의 갯수
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1); // 다음 자리 순열 뽑기
			isSelected[i] = false;
		}
		
		
	}
}
