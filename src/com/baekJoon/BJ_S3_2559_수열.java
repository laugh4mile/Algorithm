package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_2559_수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K,arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(tokens.nextToken());
		}
		int sum = 0;
		int max = 0;
		for(int k=0; k<K; k++) {
			sum += arr[k];
		}
		max = sum;
		if(N==K) {
			System.out.println(max);
		}else {
			for(int n=K; n<N; n++) {
				sum+=arr[n];
				sum-=arr[n-K];
				if(max < sum) {
					max = sum;
				}
			}
			System.out.println(max);
		}
	}

	static String src =
			"10 10\r\n" + 
			"3 -2 -4 -9 0 3 7 13 8 -3";
}
