package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S4_2840_행운의바퀴 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		char[] roulette = new char[N];
		boolean[] isSelected = new boolean[26]; 
		Arrays.fill(roulette, '?');
		int idx = 0;
		boolean isCorrect = true;
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int cnt = Integer.parseInt(tokens.nextToken());
			char ch = tokens.nextToken().charAt(0);
			idx = (idx+cnt) % N;
			if(!isSelected[ch-'A']&& roulette[idx] == '?' || roulette[idx] == ch) {
				isSelected[ch-'A'] = true;
				roulette[idx] = ch;
			}else {
				isCorrect = false;
			}
		}
		
		if(!isCorrect) {
			System.out.println('!');
		}else {
			for(int i = idx; i> idx-N; i--) {
				int ni = i;
				if(ni < 0) {
					ni += N; 
				}
				System.out.print(roulette[ni]);
			}
		}
	}

	static String src =
			"4 4\r\n"
			+ "1 A\r\n"
			+ "1 A\r\n"
			+ "1 A\r\n"
			+ "1 A";
}
