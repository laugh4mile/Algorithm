package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ_G2_1701_Cubeditor2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int n = str.length();
		int max = 0;
		int pi[] = new int[5001];
		String pattern = "";
		for(int i=0; i<n-1; i++) {
			pattern = str.substring(i,n);
			max = getPi(pattern,pi, max);
		}
		System.out.println(max);
	}

	private static int getPi(String pattern, int[] pi, int max) {
		int size = pattern.length();
		int j=0;
		for(int i=0; i<size; i++) {
			pi[i] = 0;
		}
		for(int i=1; i<size; i++) {
			while(j>0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
			if(max < pi[i]) {
				max = pi[i];
			}
		}
		return max;
	}

	static String src =
			"abcdaba";
}
