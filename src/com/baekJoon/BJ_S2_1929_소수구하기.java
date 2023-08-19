package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_1929_소수구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int M = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());
		boolean isPrime [] = new boolean [1000001];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for(int i=2; i<isPrime.length; i++) {
			if(isPrime[i]) {
				for(int j=i+i; j<isPrime.length; j+=i) {
					isPrime[j] = false;
				}	
			}
		}
		for(int i=M; i<=N; i++) {
			if(isPrime[i]) {
				output.append(i+"\n");
			}
		}
		output.close();
	}

	static String src =
			"1 4";
}
