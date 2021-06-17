package com.codingtest.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S2 {
	
	static int max = 0,N,R,no;
	static int result[], num[];
	
	static int[][] map = 
				{	
						{1, 0, 0}, 
						{1, 1, 0}, 
						{1, 1, 0}, 
						{1, 0, 1}, 
						{1, 1, 0}, 
						{0, 1, 1}
				};
	static int r = 2;
	
	public static int solution(int[][] needs, int r) {
		int answer = 0;
		R = r;
		N = needs[0].length;
		result = new int[R];
		num = new int [N];
		
		for(int i=0; i<N; i++) {
			num[i] = i;
		}
		
		combination(0, 0);
		
		return answer;
	}
	
	private static void combination(int start, int cnt) {
		if(cnt == R) {
			check(result);
			if(map.length - no > max) {
				max = map.length - no; 
			}
			no = 0;
			return;
		}
		for(int i = start; i<N; i++) {
			result[cnt] = num[i];
			combination(i+1, cnt+1);
		}
	}
	
	private static void check(int[] arr) {
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(map[i][j] == 1 && !containCheck(j,arr)) {
					no++;
					break;
				}
			}
		}
	}

	private static boolean containCheck(int j, int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == j) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		solution(map, r);
		System.out.println(max);
		
	}
}
