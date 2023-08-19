package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_2491_수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		int len = 1, max = 1;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=0; i<N-1; i++) {
			if(arr[i] <= arr[i+1]) {
				len++;
			}else {
				if(max < len) {
					max = len;
				}
				len = 1;
			}
		}
		//
		int len2 = 1, max2 = 1;
		for(int i=0; i<N-1; i++) {
			if(arr[i] >= arr[i+1]) {
				len2++;
			}else {
				if(max2 < len2) {
					max2 = len2;
				}
				len2 = 1;
			}
		}
		
		if(max2 < len2) {
			max2 = len2;
		}
		if(max < len) {
			max = len;
		}
		System.out.println(Math.max(max, max2));
	}

	static String src =
			"9\r\n" + 
			"9 8 9 6 5 4 3 2 1";
}
