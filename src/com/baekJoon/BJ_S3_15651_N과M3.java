package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S3_15651_N과M3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,result[];
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		result = new int[M];
		isSelected = new boolean[N];
		per(0);
		
	}
	private static void per(int cnt) {
		if(cnt == M) {
			for(int i=0; i<result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			result[cnt] = i+1;
			
			isSelected[i] = true;
			per(cnt+1);
			isSelected[i] = false;
		}
	}
	static String src = "3 1";
}
