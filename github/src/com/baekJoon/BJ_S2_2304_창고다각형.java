package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_2304_창고다각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static List<Column> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		int maxH = 0;
		int maxL = 0;
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int l = Integer.parseInt(tokens.nextToken());
			int h = Integer.parseInt(tokens.nextToken());
			list.add(new Column(l, h));
			if(h > maxH) {
				maxH = h;
			}
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).H == maxH) {
				maxL = i;
				break;
			}
		}
//		System.out.println(maxL);
		int answer = 0;
		for(int i=0; i<maxL; i++) {
			for(int j=i+1; j<=maxL; j++) {
				if(list.get(i).H <= list.get(j).H) {
					answer += (list.get(j).L - list.get(i).L) * list.get(i).H;
					i = j;
				}
			}
		}
		
		for(int i=N-1; i>maxL; i--) {
			for(int j=i-1; j>=maxL; j--) {
				if(list.get(i).H <= list.get(j).H) {
					answer += (list.get(i).L - list.get(j).L) * list.get(i).H;
					i = j;
				}
			}
		}
		System.out.println(answer+maxH);
	}
	
	static class Column implements Comparable<Column>{
		int L;
		int H;
		public Column(int l, int h) {
			super();
			L = l;
			H = h;
		}
		@Override
		public String toString() {
			return "column [L=" + L + ", H=" + H + "]\n";
		}
		@Override
		public int compareTo(Column o) {
			return Integer.compare(this.L, o.L);
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
