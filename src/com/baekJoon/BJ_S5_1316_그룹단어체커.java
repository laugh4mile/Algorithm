package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_1316_그룹단어체커 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int answer = 0;
		boolean isSeleted[] = new boolean [26];
		String str = "";
		char cur = ' ';
		boolean isGroup = true;
		for(int n=0; n<N; n++) {
			Arrays.fill(isSeleted, false);
			cur = ' ';
			isGroup = true;
			str = input.readLine();
			for(int i=0; i<str.length(); i++) {
				if(cur != str.charAt(i)) {
					cur = str.charAt(i);
					if(isSeleted[cur - 'a']) {
						isGroup = false;
						break;
					}else {
						isSeleted[cur - 'a'] = true;
					}
				}
			}
			if(isGroup) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	static String src =
			"3\r\n"
			+ "happy\r\n"
			+ "new\r\n"
			+ "year";
}
