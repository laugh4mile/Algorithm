package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1052_물병2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		String binaryN = Integer.toBinaryString(N);
		//
		int cnt2 = 0;
		System.out.println(binaryN);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<binaryN.length(); i++) {
			if(binaryN.charAt(i) == '1') {
				cnt2++;
			}
			if(cnt2 > K) {
				sb.append(0);
			}else {
				sb.append(binaryN.charAt(i));
			}
		}
		System.out.println(Integer.parseInt(sb.toString(),2));
		//
		int ones = 0;
		for(int i=0; i<binaryN.length(); i++) {
			if(binaryN.charAt(i) == '1') {
				ones++;
			}
		}
		
		int cnt = 0;
		int point = 0;
		if(ones <= K) {
			System.out.println(0);
		}else {
			for(int i=0; i<binaryN.length(); i++) {
				if(binaryN.charAt(i) == '1') {
					cnt++;
					if(cnt == K) {
						point = i;
						break;
					}
				}
			}
			String stringAnswer = binaryN.substring(point);
			int answer = Integer.parseInt(stringAnswer, 2);
			int temp = 0;
			for(int i=0; i<binaryN.length()-point; i++) {
				temp = temp << 1;
				temp = temp+1;
			}
			answer ^= temp;
			answer = answer+1;
			System.out.println(answer);
		}
	}

	static String src =
			"21 2";
}
