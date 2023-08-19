package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S5_15904_UCPC는무엇의약자일까 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String S = input.readLine();
		char UCPC[] = {'U','C','P','C'};
		int cnt = 0;
		for(int i=0; i<S.length(); i++) {
			if(cnt==4) break;
			if(S.charAt(i) == UCPC[cnt]) {
				cnt++;
			};
		}
		if(cnt == 4) {
			System.out.println("I love UCPC");
		}else {
			System.out.println("I hate UCPC");
		}
	}

	static String src =
			"1";
}
