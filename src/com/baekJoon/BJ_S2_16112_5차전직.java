package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_16112_5차전직 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static long exp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		exp = new long[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			exp[n] = Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(exp);
		long max = 0;
		int k=1;
		String result = "";
		for(int i=1; i<N; i++) {
			if(k<K) { // 스톤의 개수
				max += exp[i]*k;
				k++;
			}
			else{
				max += exp[i]*k;
			}
		}
		System.out.println(max);
	}


	static String src =
			"3 2\r\n" + 
			"100 300 200";
}
