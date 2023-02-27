package com.base;

import java.util.Arrays;

public class goodmorning {
	static int N,R, ccnt,cc;
	static int num[];
	static int result[];
	static boolean isSelected[];
	public static void main(String[] args) {
		N = 3;
		R = 3;
		num = new int [N];
		result = new int[R];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			num[i] = i+1;
		}
//		
		permutation(0);
//		combination(0,0);
//		subSet(0);
//		System.out.println(ccnt);
	}
	private static void subSet(int cnt) { 
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					System.out.print(num[i]);
				}
			}
			System.out.println();
			return;
		}
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
	
	
	
	
	
	private static void combination(int start, int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			cc++;
			return;
		}
		for(int i = start; i<N; i++) {
			result[cnt] = num[i];
			combination(i+1, cnt+1);
		}
	}
	
	
	
	
	private static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(result));
			ccnt++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			result[cnt] = i+1;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
