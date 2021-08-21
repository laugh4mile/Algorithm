package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S4_10828_스택 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		String cmd = "";
		int num = 0;
		Stack<Integer> stack = new Stack<>();
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			cmd = tokens.nextToken();
			switch (cmd) {
			case "push":
				num = Integer.parseInt(tokens.nextToken());
				stack.push(num);
				break;
			case "pop":
				if(stack.isEmpty()) {
					output.append(-1+"\n");
				}else {
					output.append(stack.pop()+"\n");
				}
				break;
			case "size":
				output.append(stack.size()+"\n");
				break;
			case "empty":
				if(stack.isEmpty()) {
					output.append(1+"\n");
				}else {
					output.append(0+"\n");
				}
				break;
			case "top":
				if(stack.isEmpty()) {
					output.append(-1+"\n");
				}else {
					output.append(stack.peek()+"\n");
				}
				break;
			}
		}
		output.close();
	}

	static String src =
			"14\r\n"
			+ "push 1\r\n"
			+ "push 2\r\n"
			+ "top\r\n"
			+ "size\r\n"
			+ "empty\r\n"
			+ "pop\r\n"
			+ "pop\r\n"
			+ "pop\r\n"
			+ "size\r\n"
			+ "empty\r\n"
			+ "pop\r\n"
			+ "push 3\r\n"
			+ "empty\r\n"
			+ "top";
}	
