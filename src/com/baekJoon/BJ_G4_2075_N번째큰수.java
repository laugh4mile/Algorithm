package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_2075_N번째큰수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				pq.offer(Integer.parseInt(tokens.nextToken()));
			}	
		}
		for(int i=0; i<N-1; i++) {
			pq.poll();
		}
		System.out.println(pq.peek());
	}

	static String src =
			"5\r\n" + 
			"12 7 9 15 5\r\n" + 
			"13 8 11 19 6\r\n" + 
			"21 10 26 31 16\r\n" + 
			"48 14 28 35 25\r\n" + 
			"52 20 32 41 49";
}
