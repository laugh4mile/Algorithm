package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G5_1107_리모컨2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N  = Integer.parseInt(input.readLine());
		boolean keys[] = new boolean[10]; // 0,1,2,3,4,5,6,7,8,9
		int b = Integer.parseInt(input.readLine());
		Arrays.fill(keys, true);
		
		if(b != 0) {
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<b; i++) {
				keys[Integer.parseInt(tokens.nextToken())] = false;
			}
		}
		int answer = Math.abs(N-100); // 초기 상태. 방향키로만 이동할 경우
		
		for(int i=0; i<=1000000; i++) {
			int len = check(i, keys);
			if(len > 0) {
				if(answer > len + Math.abs(i - N)) {
					answer = len + Math.abs(i - N);
				}
			}
		}
		System.out.println(answer);
	}

	private static int check(int n, boolean keys[]) {
		int cnt = 0;
		if(n == 0) {
			if(keys[0]) {
				return 1;
			}
		}
		while(n>0) {
			if(keys[n%10]) {
				cnt++;
				n /= 10;
			}else {
				return 0;
			}
		}
		return cnt;
	}
	static String src =
			"0\r\n"
			+ "3\r\n"
			+ "0 1 2\r\n"
			+ "4";
}