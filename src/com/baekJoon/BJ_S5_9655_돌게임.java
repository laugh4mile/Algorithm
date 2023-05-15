package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S5_9655_돌게임 {
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		if(N%2 == 0) {
			System.out.println("CY");
		}else {
			System.out.println("SK");
		}
	}

	static String src =
			"1";
}
