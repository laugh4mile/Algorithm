package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class BJ_G2_1701_Cubeditor {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int n = str.length();
		Map<String, Boolean> map = new HashMap<>();
		int max = 0;
		int pi[] = new int[5001];
		String pattern = "";
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n+1; j++) {
				pattern = str.substring(i,j);
				if(pattern.length() > max && map.get(pattern) == null) {
					map.put(pattern, true);
					pi = getPi(pattern);
					if(kmp(pi, str,pattern) && max < pattern.length()) {
						max = pattern.length();
					}
				}
			}	
		}
		System.out.println(max);
	}

	private static boolean kmp(int[] pi, String target, String pattern) {
		int targetlen = target.length();
		int patternlen = pattern.length();
		int j = 0;
		int cnt = 0;
		for(int i=0; i<targetlen; i++) {
			while(j>0 && target.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(target.charAt(i) == pattern.charAt(j)) {
				if(j == patternlen-1) {
					if(++cnt>=2) {
						return true;
					}
					j = pi[j];
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
			"abcdabcabb";
}
