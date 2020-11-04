package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_B1_2999_비밀이메일 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static int R,C, min = Integer.MAX_VALUE;
	static char [][] ch;
	static char [] arr;
	public static void main(String[] args) throws IOException {
//		input = new BufferedReader(new StringReader(src));
		str = input.readLine();
		
		int len = str.length();
		arr = new char[len];
		for(int i=0; i<len; i++) {
			arr[i] = str.charAt(i);
		}
		for(int i=1; i<=len; i++) {
			if(len % i == 0) {
				int num = len/i;
				if(min > Math.abs(num-i)) {
					min = Math.abs(num-i);
					R = Math.min(num, i);
					C = Math.max(num, i);
				}
			}
		}
//		System.out.println(R+ " "+C);
		ch = new char[R][C];
//		System.out.println(Arrays.toString(c));
		int cnt = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				ch[r][c] = arr[cnt++];
			}	
		}
//		for(char []x : ch) {
//			System.out.println(Arrays.toString(x));
//		}
		
		
		for(int c=0; c<C; c++) {
			for(int r=0; r<R; r++) {
				System.out.print(ch[r][c]);
			}
		}	
	}
	static String src = 
			"abcd";
}