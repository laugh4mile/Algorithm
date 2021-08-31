package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G3_16172_나는친구가적다 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String origin = input.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<origin.length(); i++) {
			if(!Character.isDigit(origin.charAt(i))) {
				sb.append(origin.charAt(i));
			}
		}
		String target = sb.toString();
		String pattern = input.readLine();
		int pi[] = getPi(pattern);
		if(kmp(pi, target, pattern)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

	private static boolean kmp(int[] pi, String target, String pattern) {
		int patternlen = pattern.length();
		int targetnlen = target.length();
		int j = 0;
		
		for (int i=0; i<targetnlen; i++) {
			while(j>0 && target.charAt(i) != pattern.charAt(j)){
				j = pi[j-1];
			}
			if(target.charAt(i) == pattern.charAt(j)) {
				if(j == patternlen-1) {
					return true;
//					j = pi[j];
				}else {
					j++;
				}
			}
		}
		
		return false;
	}

	private static int[] getPi(String pattern) {
		int patternlen = pattern.length();
		int pi[] = new int[patternlen];
		int j = 0;
		
		for(int i=1; i<patternlen; i++) {
			while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}

	static String src =
			"1q2w3e4r5t6y\r\n"
			+ "qwerty";
}
