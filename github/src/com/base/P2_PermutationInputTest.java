package com.base;

import java.util.Arrays;
import java.util.Scanner;

public class P2_PermutationInputTest {

	private static int N, R;
	private static int[] numbers,input; // 순열 저장 배열,입력된 숫자 배열
	private static boolean[] isSelected;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		
		numbers = new int[R];
		isSelected = new boolean[N]; // boolean은 디폴트값이 false
		input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i]= sc.nextInt();
		}
		
		permutation(0);
	}
	
	//지정된 자리에 순열 뽑기
	private static void permutation(int cnt) { // cnt : 현재까지 뽑은 순열의 갯수
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1); // 다음 자리 순열 뽑기
			isSelected[i] = false;
		}
		
		
	}
}
