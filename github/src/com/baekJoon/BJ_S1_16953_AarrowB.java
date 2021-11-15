package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_16953_AarrowB {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int A = Integer.parseInt(tokens.nextToken());
		int B = Integer.parseInt(tokens.nextToken());
		
		int answer = solution(A, B);
		System.out.println(answer);
	}

	private static int solution(int a, int b) {
		int cnt = 0;
		while(a < b) {
			if(b%2 == 0) {
				cnt++;
				b = b/2;
			}else {
				if(b%10 != 1) {
					return -1;
				}else {
					cnt++;
					b = b/10;
				}
			}
		}
		
		if(a == b) {
			return cnt+1;
		}else {
			return -1;
		}
	}

	static String src =
			"100 40021";
}
