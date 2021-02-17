package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B1_3985_롤케이크 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int L,N,P,K, arr[], max = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		L = Integer.parseInt(input.readLine());
		N = Integer.parseInt(input.readLine()); 
		
		arr = new int[L+1];
		int a1 = 0;
		for(int i=1; i<=N; i++) {
			tokens = new StringTokenizer(input.readLine());
			P = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			
			int answer1 = K-P;
			
			if(answer1 > max) {
				max = answer1;
				a1 = i;
			}
			
			for(int j=P; j<=K; j++) {
				if(arr[j] == 0) {
					arr[j] = i;
				}
			}
		}
		int cnt = 0, answer2=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<arr.length; j++) {
				if(arr[j] == i) {
					cnt++;
				}
			}
			
			if(cnt > max2) {
				max2 = cnt;
				answer2 = i;
			}
			cnt = 0;
		}
		
		System.out.println(a1);
		System.out.println(answer2);
//		System.out.println(Arrays.toString(arr));
	}
	static String src =
			"10\r\n" + 
			"3\r\n" + 
			"2 4\r\n" + 
			"7 8\r\n" + 
			"6 10";
}
