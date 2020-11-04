package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_S2_1911_흙길보수하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,L;
	static int [][] pool;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		pool = new int[N][2];
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			pool[n][0] = start;
			pool[n][1] = end;
		}
		
		Arrays.sort(pool, new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
//		for(int[] x : pool) {
//			System.out.println(Arrays.toString(x));
//		}
		int currentPoint = pool[0][0];
		int result = 0;
		int cnt = 0;
		for(int i=0; i<N-1; i++) {
			int len = pool[i][1] - currentPoint;
			if(len%L == 0) {
				cnt = len/L;
				currentPoint = currentPoint + cnt*L; 
			}else {
				cnt = len/L+1;
				currentPoint = currentPoint + cnt*L;
			}
			result +=  cnt;
			if(currentPoint < pool[i+1][0]) {
				currentPoint = pool[i+1][0];
			}
//			System.out.println("현재 위치 : "+ currentPoint);
		}
		if(currentPoint < pool[N-1][0]) {
			currentPoint = pool[N-1][0];
		}
		int len = pool[N-1][1] - currentPoint;
		if(len%L == 0) {
			cnt = len /L;
		}else {
			cnt = len /L +1;
		}
		result +=  cnt;
		System.out.println(result);
		
		
	}

	static String src = "3 3\r\n" + 
			"1 6\r\n" + 
			"13 17\r\n" + 
			"8 12";

}
