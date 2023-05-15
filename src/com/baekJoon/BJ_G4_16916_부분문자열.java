package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_G4_16916_부분문자열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String target = input.readLine();
		String pattern = input.readLine();
		
		int []pi = getPi(pattern);
		System.out.println(kmp(target,pattern,pi));
		
	}

	private static int kmp(String target, String pattern, int[] pi) {
		int targetlen = target.length();
		int patternlen = pattern.length();
		
		int j=0;
		for(int i=0; i<targetlen; i++) {
			while(j>0 && target.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(target.charAt(i) == pattern.charAt(j)) {
				if(j == patternlen-1) {
					j = pi[j];
					return 1;
				}else {
					j++;
				}
			}
		}
		
		return 0;
	}

	private static int[] getPi(String pattern) {
		int size = pattern.length();
		int pi[] = new int[size];
		
		int j = 0;
		for(int i=1; i<size; i++) {
			while(j>0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = pi[j-1];
			}
			if(pattern.charAt(j) == pattern.charAt(i)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static String src =
			"baekjoon\r\n" + 
			"baekjoon";
}





