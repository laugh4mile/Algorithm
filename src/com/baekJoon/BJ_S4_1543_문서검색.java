package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_S4_1543_문서검색 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		char[] text = input.readLine().toCharArray();
		char[] word = input.readLine().toCharArray();
		
		int answer = 0;
		for(int i=0; i<text.length - word.length+1; i++) {
			boolean isMatched = true;
			for(int j=0; j<word.length; j++) {
				if(text[i+j] == word[j]) {
				}else {
					isMatched = false;
					break;
				}
			}
			if(isMatched) {
				answer++;
				i += word.length-1;
			}
		}
		System.out.println(answer);
	}

	static String src =
			"ababababa\r\n" + 
			"aba";
}
