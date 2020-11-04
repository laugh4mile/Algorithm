package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_17504_제리와톰2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,arr[];
	static long mom, son, temp;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		mom = arr[N-1]; // 초기값 8
		son = 1;
		
		for(int i=N-1; i>0; i--) {
			son = arr[i-1]*mom + son;
			temp = son;
			son = mom;
			mom = temp;
		}
		System.out.println(mom-son +" "+mom);
	}
	static String src =
			"15\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9 9 9 9";
}
