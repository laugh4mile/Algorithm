package com.swcordingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class Q1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int [N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input.readLine());
		}
//		System.out.println(Arrays.toString(arr));
		
		int sumL = 0;
		int sumR = 0;
		int minChai = Integer.MAX_VALUE;
		int index = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				sumL += arr[j];
			}
			for(int j=i; j<N; j++) {
				sumR += arr[j];
			}
			
			if(Math.abs(sumL - sumR) < minChai){
				minChai = Math.abs(sumL - sumR);
				index = i;
			}
			sumL = 0;
			sumR = 0;
		}
		System.out.println(index);
		
	}
	static String src =
			"4\r\n"
			+ "1\r\n"
			+ "2\r\n"
			+ "3\r\n"
			+ "3";
}
