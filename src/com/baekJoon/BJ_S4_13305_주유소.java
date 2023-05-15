package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S4_13305_주유소 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		
		long len[] = new long[N-1];
		long oilPrice[] = new long[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N-1; i++) {
			oilPrice[i] = Integer.parseInt(tokens.nextToken());
		}
		
		
		long curPrice = oilPrice[0];
		long answer = 0;
//		System.out.println(Long.MAX_VALUE);
		for(int i=0; i<N-1; i++) {
			if(curPrice > oilPrice[i]) {
				curPrice = oilPrice[i];
			}
			answer += curPrice * len[i];
		}
		System.out.println(answer);
	}

	static String src =
			"4\r\n" + 
			"3 3 4\r\n" + 
			"1 1 1 1";
}
