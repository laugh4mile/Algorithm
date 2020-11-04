package com.base;

import java.util.Arrays;

public class CombinationTest {
	
	static int N,R;
	static int[] num = {1,2,3,4};
	static int[] result;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		N=num.length;
		R=2;
		result = new int[R];
		isSelected = new boolean[N];
		permutation(0);
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i])continue;
			result[cnt]=num[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
}
