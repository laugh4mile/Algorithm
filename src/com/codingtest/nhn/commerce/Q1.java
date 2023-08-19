package com.codingtest.nhn.commerce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;

public class Q1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int n = Integer.parseInt(input.readLine());
		String[] logs = new String[n];
		for(int i=0; i<n; i++) {
			logs[i] = input.readLine();
		}
		ArrayList<Node> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(new Node(logs[i], 1));
		}
		
		if(n==1) {
			output.append(n+"\n");
			output.append(logs[0]+"\n");
		}else {
			for(int i=1; i<list.size(); i++) {
				if(list.get(i).str.equals(list.get(i-1).str)) {
					list.get(i-1).count++;
					list.remove(i--);
				}
			}
			output.append(list.size()+"\n");
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).count == 1) {
					output.append(list.get(i).str+"\n");
				}else {
					output.append(list.get(i).str+" ("+list.get(i).count+")\n");
				}
			}
		}
		output.close();
		
	}
	static class Node{
		String str;
		int count;
		public Node(String str, int count) {
			super();
			this.str = str;
			this.count = count;
		}
		@Override
		public String toString() {
			return "Node [str=" + str + ", count=" + count + "]";
		}
		
	}
	static String src =
			"1\r\n" + 
//			"SMS 010-1234-5678\r\n" + 
//			"CALL 010-1234-5678\r\n" + 
//			"CALL 010-1234-5678\r\n" + 
//			"SMS 010-1111-1111\r\n" + 
//			"SMS 010-5555-5555\r\n" + 
//			"CALL 010-5555-5555\r\n" + 
//			"CALL 010-5555-5555\r\n" + 
//			"CALL 010-4444-4444\r\n" + 
//			"SMS 010-5555-5555\r\n" + 
			"CALL 010-5555-5555";
}
