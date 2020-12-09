package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N, num[] , operator[], min, max;
	static Stack<Integer> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			num = new int[N];
			operator = new int[4];
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<4; i++) {
				operator[i] = Integer.parseInt(tokens.nextToken());
			}
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<N; i++) {
				num[i] = Integer.parseInt(tokens.nextToken());
			}
			
//			System.out.println(Arrays.toString(operator));
//			System.out.println(Arrays.toString(num));
			
			stack = new Stack<>();
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(0);
			
			System.out.println("#"+t+" "+(max-min));
			
		}
	}

	private static void dfs(int depth) {
		if(depth == N-1) {
			int value = calculation();
			if(value < min) {
				min = value;
			}
			if(value > max) {
				max = value;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				stack.push(i);
				dfs(depth+1);
				stack.pop();
				operator[i]++;
			}
		}
	}

	private static int calculation() {
		int value = num[0];
		for(int i=0; i<stack.size(); i++) {
			int op = stack.get(i);
			if(op==0) {
				value = value + num[i+1];
			}
			if(op==1) {
				value = value - num[i+1];
			}
			if(op==2) {
				value = value * num[i+1];
			}
			if(op==3) {
				value = value / num[i+1];
			}
		}
		return value;
	}

	static String src =
			"10\r\n" + 
			"5\r\n" + 
			"2 1 0 1\r\n" + 
			"3 5 3 7 9\r\n" +
			"6\r\n" + 
			"4 1 0 0\r\n" + 
			"1 2 3 4 5 6 \r\n" + 
			"5\r\n" + 
			"1 1 1 1\r\n" + 
			"9 9 9 9 9 \r\n" + 
			"6\r\n" + 
			"1 4 0 0\r\n" + 
			"1 2 3 4 5 6 \r\n" + 
			"4\r\n" + 
			"0 2 1 0\r\n" + 
			"1 9 8 6\r\n" + 
			"6\r\n" + 
			"2 1 1 1\r\n" + 
			"7 4 4 1 9 3 \r\n" + 
			"7\r\n" + 
			"1 4 1 0\r\n" + 
			"2 1 6 7 6 5 8 \r\n" + 
			"8\r\n" + 
			"1 1 3 2\r\n" + 
			"9 2 5 3 4 9 5 6 \r\n" + 
			"10\r\n" + 
			"1 1 5 2\r\n" + 
			"8 5 6 8 9 2 6 4 3 2 \r\n" + 
			"12\r\n" + 
			"2 1 6 2\r\n" + 
			"2 3 7 9 4 5 1 9 2 5 6 4 \r\n"+
			"";
}
