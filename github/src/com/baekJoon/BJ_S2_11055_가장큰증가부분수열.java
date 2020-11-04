package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_11055_가장큰증가부분수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, arr[], result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		arr = new int[N];
		result = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			result[i] = arr[i];
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N; j++) {
				if(arr[i]<arr[j]) {
					if(result[j] <result[i]+arr[j]) {
						result[j] = result[i]+arr[j];
					}
				}
			}
		}
		System.out.println(Arrays.toString(result));
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		System.out.println(max);
	}
	static String src =
			"3\r\n" + 
			"8 1 8";
}
