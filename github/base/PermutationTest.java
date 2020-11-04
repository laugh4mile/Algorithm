package com.base;

import java.util.Arrays;

public class PermutationTest {
	static int N,R;
	static int[] num;
	static boolean[] isSelected;

	public static void main(String[] args) {
		N = 4;
		R = 2;
		num = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0);
		
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for(int i=1; i<=N; i++) {
			if(isSelected[i]) continue;
			num[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
