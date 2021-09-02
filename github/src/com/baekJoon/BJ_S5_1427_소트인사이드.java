package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_1427_소트인사이드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int len = str.length();
		List<Character> list = new ArrayList<>();
		for(int i=0; i<len; i++) {
			list.add(str.charAt(i));
		}
		Collections.sort(list, Comparator.reverseOrder());
		for(char x: list) {
			System.out.print(x);
		}
	}

	static String src =
			"2143123412312446";
}
