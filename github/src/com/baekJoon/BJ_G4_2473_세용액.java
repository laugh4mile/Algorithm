package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_2473_세용액 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static long arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new long[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(arr); 
		
		long min = Long.MAX_VALUE;
		long answer1 = 0, answer2 = 0, answer3 = 0;
		int j = 0, k = 0;
		long sum = 0;
		for(int i=0; i<N-2; i++) {
			j=i+1;
			k=N-1;
			while(j<k) {
				sum = Math.abs(arr[i] + arr[j] + arr[k]);
				if(sum<min) { 
					min = sum;
					answer1 = arr[i];
					answer2 = arr[j];
					answer3 = arr[k];
				}
				if(arr[i]+arr[j]+arr[k] < 0) {
					j++;
				}else{ 
					k--;
				}
			}
		}
		System.out.println(answer1+" "+answer2+" "+answer3);
	}

	static String src =
			"10\r\n" + 
			"254336095 47691541 257341582 -144645454 861485597 33299316 -291023334 -255047743 -645353494 329443014"; //-382,436
}
