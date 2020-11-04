package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_S1_1991_트리순회 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		List<Node> nodes = new LinkedList<>();

		N = Integer.parseInt(input.readLine());
		
		for(int i=0; i<N; i++) {
			Node newNode = new Node();
			newNode.data = (char) (i + 65) ;
			nodes.add(newNode);
		}
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			char d = tokens.nextToken().charAt(0);
			char left = tokens.nextToken().charAt(0);
			char right = tokens.nextToken().charAt(0);
			nodes.get(i).data = d;
			nodes.get(i).data = d;
			
		}
	}
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		public Node() {
			super();
		}

		public Node(char data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	static String src =
			"7\r\n" + 
			"A B C\r\n" + 
			"B D .\r\n" + 
			"C E F\r\n" + 
			"E . .\r\n" + 
			"F . G\r\n" + 
			"D . .\r\n" + 
			"G . .";
}
