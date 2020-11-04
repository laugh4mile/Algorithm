package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G5_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<int[]> stack = new Stack<>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(input.readLine());
		StringTokenizer stt = new StringTokenizer(input.readLine());

		for (int i = 1; i <= n; i++) {
			int top = Integer.parseInt(stt.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= top) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new int[] { i, top });
		}
	}
//	static String src = "5\r\n" + 
//			"6 9 5 7 4";
//			"6 9 5 7 4";
}
