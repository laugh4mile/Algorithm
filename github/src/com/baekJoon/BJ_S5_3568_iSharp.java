package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_S5_3568_iSharp {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		boolean typeIsSelected = false;
		tokens = new StringTokenizer(input.readLine());
		String type = "";
		while(tokens.hasMoreTokens()) {
			if(!typeIsSelected) {
				type = tokens.nextToken();
				typeIsSelected = true;
			}
			
			String str = tokens.nextToken();
			boolean valIsSelected = false;
			int valend = str.length()-1;
			for(int i=0; i<str.length(); i++) {
				if(!valIsSelected) {
					if(str.charAt(i)== '&' || str.charAt(i)== '*' || str.charAt(i)== '[' || str.charAt(i)== ']') {
						valend = i;
						valIsSelected = true;
					}
				}
			}
			String val = str.substring(0,valend);
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)== '&' || str.charAt(i)== '*') {
					stack.add(str.charAt(i));
				}else if(str.charAt(i)== '[') {
					stack.add(']');
				}else if(str.charAt(i)== ']') {
					stack.add('[');
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append(type);
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.append(" ");
			sb.append(val);
			sb.append(';');
			
			System.out.println(sb);
		}
	}

	static String src =
			"int& a*[]&, b, c*;";
}
