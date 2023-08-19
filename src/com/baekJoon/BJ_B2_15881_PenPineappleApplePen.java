package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_B2_15881_PenPineappleApplePen {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		String str = input.readLine();
		int start = 0;
		int answer = 0;
		for(int i=start; i<n-3; i++) {
			if(str.substring(i, i+4).equals("pPAp")) {
				i += 3;
				answer++;
			};
		}
		System.out.println(answer);
	}

	static String src =
			"7\r\n" + 
			"pPApPAp";
}
