package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_G5_2631_줄세우기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N, arr[], result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		result = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
			result[i] = 1;
		}
		
//		System.out.println(Arrays.toString(arr));
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N; j++) {
				if(arr[i] < arr[j]) {
					if(result[j] < result[i]+1) {
						result[j] = result[i]+1;
					}
				}
			}	
		}
		
//		System.out.println(Arrays.toString(result));
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(max < result[i]) {
				max = result[i];
			}
		}
		System.out.println(N-max);
	}
	static String src =
			"7\r\n" + 
			"3\r\n" + 
			"7\r\n" + 
			"5\r\n" + 
			"2\r\n" + 
			"6\r\n" + 
			"1\r\n" + 
			"4";
}
