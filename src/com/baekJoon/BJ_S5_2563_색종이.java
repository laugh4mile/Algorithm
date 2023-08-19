package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_2563_색종이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static int map[][] = new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
//			System.out.println(r);
//			System.out.println(c);
			for(int i=r; i<r+10; i++) {
				for(int j=c; j<c+10; j++) {
					map[i][j] = 1;
				}	
			}
		}
//		for(long x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		int sum = 0;
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				sum+=map[i][j];
			}	
		}
		System.out.println(sum);
	}
	
	static String src = 
			"3\r\n" + 
			"3 7\r\n" + 
			"15 7\r\n" + 
			"5 2";
}
