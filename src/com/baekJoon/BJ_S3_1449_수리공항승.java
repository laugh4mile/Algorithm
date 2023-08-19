package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1449_수리공항승 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int L = Integer.parseInt(tokens.nextToken());
		int holes[] = new int[N];
		boolean isClosed[] = new boolean[1001+L];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			holes[i] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(holes);
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			int cur = holes[i];
			if(!isClosed[cur]) {
				for(int j=0; j<L; j++) {
					isClosed[cur+j] = true;
				}
				answer++;
			}
		}
		System.out.println(answer);
		
	}

	static String src =
			"3 1\r\n" + 
			"3 2 1";
}
