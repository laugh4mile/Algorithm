package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G3_11054_가장긴바이토닉부분수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, arr[], arr2[], result[], result2[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		arr2 = new int[N];
		result = new int[N];
		result2 = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			arr2[N-1-i] = arr[i];
			result[i] = 1;
			result2[i] = 1;
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr2));
		
//		for(int i=0; i<N-1; i++) {
//			for(int j=i; j<N; j++) {
//				if(arr[i]<arr[j]) {
//					if(result[j] < result[i]+1) {
//						result[j] = result[i]+1;
//					}
//				}
//			}	
//		}
		result = lis(arr, result);
		result2 = lis(arr2, result2);
		reverse(result2);
		
//		System.out.println(Arrays.toString(result));
//		System.out.println(Arrays.toString(result2));
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(max < result[i] + result2[i])
			max = result[i] + result2[i];
		}
		
		System.out.println(max-1);
		
		
	}
	
	static int[] reverse (int [] arr) {
		int temp = 0;
		for(int i=0; i<N/2; i++) {
			temp = arr[i];
			arr[i] = arr[N-i-1];
			arr[N-i-1] = temp;
		}
		
		return arr;
	}
	
	static int[] lis (int []arr, int []result) {
		for(int i=0; i<N-1; i++) {
			for(int j=i; j<N; j++) {
				if(arr[i]<arr[j]) {
					if(result[j] < result[i]+1) {
						result[j] = result[i]+1;
					}
				}
			}	
		}
		return result;
	}
	
	static String src = 
			"10\r\n" + 
			"1 5 2 1 4 3 4 5 2 1";
}
