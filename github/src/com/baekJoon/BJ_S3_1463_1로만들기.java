package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_1463_1로만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, path[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		path = new int[N+1];
		Arrays.fill(path, 1000000);
		path[1] = 0;
		for(int n=2; n<=N; n++) {
			path[n] = Math.min(path[n-1] + 1, path[n]);
			if(n%2==0) {
				path[n] = Math.min(path[n/2]+1, path[n]);
			}
			if(n%3==0) {
				path[n] = Math.min(path[n/3]+ 1, path[n]);
			}
		}
		System.out.println(path[N]);
	}
	static String src =
			"100000";
}
