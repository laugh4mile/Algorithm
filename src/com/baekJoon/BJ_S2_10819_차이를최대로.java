package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_10819_차이를최대로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,A[],result[], max=Integer.MIN_VALUE;
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		A = new int[N];
		result = new int[N];
		isVisited = new boolean[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			A[n] = Integer.parseInt(tokens.nextToken());
		}
//		System.out.println(Arrays.toString(A));
		per(0);
		System.out.println(max);
	}
	private static void per(int cnt) {
		if(cnt == N) {
			sibal(result);
			return;
		}
		for(int i=0; i<N; i++) {
			if(isVisited[i]) continue;
			result[cnt] = A[i];
			isVisited[i] = true;
			per(cnt+1);
			isVisited[i] = false;
		}
	}
	private static void sibal(int[] result) {
		int sum = 0;
		for(int i=0; i<result.length-1; i++) {
			sum += Math.abs(result[i] - result[i+1]);
		}
		if(max < sum) {
			max = sum;
		}
	}
	static String src = "6\r\n" + 
			"20 1 15 8 4 10";

}
