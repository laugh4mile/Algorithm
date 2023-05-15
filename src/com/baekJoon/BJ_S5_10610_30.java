package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S5_10610_30 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String str = input.readLine();
		int zary = 0;
		char arr[] = str.toCharArray();
		boolean flag = false;
		
		for(int i=0; i<arr.length; i++) {
			zary += arr[i] - '0';
			if(arr[i] == '0') {
				flag = true;
			}
		}
		
		if(zary%3 != 0) {
			flag = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(flag) {
			Arrays.sort(arr);
			for(int i=arr.length-1; i>=0; i--) {
				sb.append(arr[i]);
			}
		}else {
			sb.append(-1);
		}
		System.out.println(sb);
	}

	static String src =
			"80875542";
}
