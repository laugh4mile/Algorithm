package com.codingtest.codechallenges2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Q2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
        	s = s.substring(1,s.length()) + s.substring(0, 1);
        	
        	if(check(s)) {
        		answer++;
        	}
        }
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String s = input.readLine();
		solution(s);
	}

	static boolean check(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			switch (str.charAt(i)) {
			case '[':
				stack.push(str.charAt(i));
				break;
			case '{':
				stack.push(str.charAt(i));
				break;
			case '(':
				stack.push(str.charAt(i));
				break;
			case ']':
				if(stack.isEmpty()) {
					return false;
				}
				if(!stack.isEmpty() && stack.peek()=='[') {
					stack.pop();
				}
				break;
			case '}':
				if(stack.isEmpty()) {
					return false;
				}
				if(!stack.isEmpty() && stack.peek()=='{') {
					stack.pop();
				}
				break;
			case ')':
				if(stack.isEmpty()) {
					return false;
				}
				if(!stack.isEmpty() && stack.peek()=='(') {
					stack.pop();
				}
				break;
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	static String src =
			"}}}";
}
