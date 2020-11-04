package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_B2_2605_줄세우기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,num[];
	static List<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		num = new int [N];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=0; i<num.length; i++) {
			list.add(num[i], i+1);
		}
//		System.out.println(list);
		for(int i=num.length-1; i>=0; i--) {
			System.out.print(list.get(i)+" ");
		}
	}
	static class node{
		int no;
		node link;
		public node(int no, node link) {
			super();
			this.no = no;
			this.link = link;
		}
	}
	
	static String src = "5\r\n" + 
			"0 1 1 3 2";
}
