package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_14225_부분수열의합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,S[];
	static boolean isSelected[], check[] = new boolean[2000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		S = new int[N];
		isSelected = new boolean[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			S[n] = Integer.parseInt(tokens.nextToken());
		}
		subSet(0);
		
		for(int i=1; i<check.length; i++) {
			if(!check[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	private static void subSet(int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sum += S[i];
				}
			}
			check[sum] = true;
			return;
		}
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}

	static String src =
			"4\r\n" + 
			"2 1 2 7";
}

