package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_15654_N과M5 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,num[],result[];
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		num = new int[N];
		isVisited = new boolean[N];
		result = new int[M];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(num);
//		System.out.println(Arrays.toString(num));
		per(0);
	}
	
	private static void per(int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) {
			if(isVisited[i]) continue;
			
			result[cnt] = num[i];
			isVisited[i] = true;
			per(cnt+1);
			isVisited[i] = false;
		}
	}
	
	static String src = 
			"4 2\r\n" + 
			"9 8 7 1";
}
