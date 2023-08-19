package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_19597_문자열뒤집기 {
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
		String reverseStr = "";
		int cnt = 0;
		for(int i=1; i<words.length; i++) {
			String curStr = words[i];
			System.out.println("preStr : "+preStr+"    curStr : "+curStr + "         i : "+i);
			StringBuilder reverse = new StringBuilder(curStr);
			reverseStr = reverse.reverse().toString();
			if(preStr.compareTo(curStr) < 0) {
				preStr = curStr;
				answer[i] = 0;
			}else if(preStr.compareTo(reverseStr) < 0) {
				preStr = reverseStr;
				answer[i] = 1;
			}else { // 바꿔도 안바꿔도 기존보다 작으면 i를 거슬러 올라가며 맞을때 까지 preStr을 바꿔야한다.
				if(cnt == 5) {
					break;
				}
				while(i>0) {
					if(i == 1) {
						reverse = new StringBuilder(words[0]);
						preStr = reverse.reverse().toString();
						answer[0] = 1;
						words[0] = preStr;
						i=0;
						System.out.println("zzzzzzzzzz");
//						cnt ++;
						break;
					}
					curStr = words[i-1];
					reverse = new StringBuilder(curStr);
					reverseStr = reverse.reverse().toString();
					preStr = words[i-2];
					System.out.println(preStr + " " + curStr + " " + reverseStr);
					if(preStr.compareTo(reverseStr) < 0) {
						System.out.println("tqtqtqtqtqtqtqtqtqtq");
						preStr = reverseStr;
						answer[i-1] = 1;
						words[i-1] = reverseStr;
						break;
					}
					i--;
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.println(Arrays.toString(words));
		return Arrays.toString(answer).replaceAll("[^a-zA-Z0-9]", "");
	}
	static String src =
			"3\r\n"
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
			+ "ADA";
}
