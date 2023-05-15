package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_19597_문자열뒤집기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		StringBuilder answer = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(input.readLine());
			String [] words = new String[N];
			for(int n=0; n<N; n++) {
				words[n] = input.readLine();
			}
			answer.append(solve(words)+"\n"); 
		}
		System.out.println(answer);
	}

	private static String solve(String[] words) {
		int answer[] = new int[words.length];
		String preStr = words[0];
		if(preStr.compareTo(words[1]) < 0) {
			
		}
		String reverseStr = "";
		int cnt = 0;
		for(int i=1; i<words.length; i++) {
			String curStr = words[i];
			reverseStr = new StringBuilder(curStr).reverse().toString();
			
			if(preStr.compareTo(curStr) < 0) {
				preStr = curStr;
				answer[i] = 0;
			}
			
			else if(preStr.compareTo(reverseStr) < 0) {
//				System.out.println(preStr+" "+reverseStr);
				preStr = reverseStr;
				answer[i] = 1;
			}
			
			else { // 바꿔도 안바꿔도 기존보다 작을 경우
				preStr = new StringBuilder(words[i-1]).reverse().toString();
				for(int j=i-1; j>=0; j--) {
					if(j==0) {
						answer[0] = 1;
						break;
					}
					reverseStr = new StringBuilder(words[j]).reverse().toString();
					answer[j] = 1;
					if(words[j-1].compareTo(reverseStr) < 0) {
						i--;
						break;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(words));
//		System.out.println(Arrays.toString(answer));
		return Arrays.toString(answer).replaceAll("[^a-zA-Z0-9]", "");
	}
	static String src =
			"7\r\n"
			+ "4\r\n"
			+ "BF\r\n"
			+ "BE\r\n"
			+ "EF\r\n"
			+ "FG\r\n"
			+ "4\r\n"
			+ "CBA\r\n"
			+ "CBB\r\n"
			+ "CDB\r\n"
			+ "BEB\r\n"
			+ "3\r\n"
			+ "ABC\r\n"
			+ "ABD\r\n"
			+ "XY\r\n"
			+ "5\r\n"
			+ "AAA\r\n"
			+ "BAA\r\n"
			+ "BCA\r\n"
			+ "CCA\r\n"
			+ "ADA\r\n"
			+ "7\r\n"
			+ "AAA\r\n"
			+ "BAA\r\n"
			+ "BCA\r\n"
			+ "CCA\r\n"
			+ "ADA\r\n"
			+ "ABD\r\n"
			+ "GBE\r\n"
			+ "9\r\n"
			+ "AAA\r\n"
			+ "BAA\r\n"
			+ "BCA\r\n"
			+ "CCA\r\n"
			+ "ADA\r\n"
			+ "ABD\r\n"
			+ "CDE\r\n"
			+ "BFE\r\n"
			+ "EGF\r\n"
			+ "6\r\n"
			+ "BAA\r\n"
			+ "AB\r\n"
			+ "BCA\r\n"
			+ "BB\r\n"
			+ "FHE\r\n"
			+ "EGF";
}
