package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S5_1789_수들의합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		long S = Long.parseLong(input.readLine());
		
		int answer = 0;
		for(int i=1; i<=S; i++) {
			if(S >= i+i+1) {
				answer++;
				S -= i;
			}else {
				break;
			}
		}
		System.out.println(answer+1);
	}

	static String src =
			"4294967295";
}