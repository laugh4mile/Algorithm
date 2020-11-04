package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static List<column> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int l = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			list.add(new column(l, h));
		}
		Collections.sort(list, new Comparator<column>() {
			@Override
			public int compare(column o1, column o2) {
				
				return Integer.compare(o1.L, o2.L);
			}
		});
		System.out.println(list);
		
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				if(list.get(i).H > list.get(j).H) {
					
				}
			}
		}
	}
	
	static class column{
		int L;
		int H;
		public column(int l, int h) {
			super();
			L = l;
			H = h;
		}
		@Override
		public String toString() {
			return "column [L=" + L + ", H=" + H + "]";
		}
		
		
	}
	
	static String src =
			"7\r\n" + 
			"2 4\r\n" + 
			"11 4\r\n" + 
			"15 8\r\n" + 
			"4 6\r\n" + 
			"5 3\r\n" + 
			"8 10\r\n" + 
			"13 6";
}
