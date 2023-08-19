package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G2_1202_보석도둑 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		PriorityQueue<Gem> gems = new PriorityQueue<>();
//		List<Gem> gems = new ArrayList<>();
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int m = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			gems.offer(new Gem(m, v));
		}
//		Collections.sort(gems);
		PriorityQueue<Integer> bag = new PriorityQueue<>();
		for(int k=0; k<K; k++) {
			int bagCapacity = Integer.parseInt(input.readLine());
			bag.offer(bagCapacity);
		}
		long answer = 0;
		PriorityQueue<Integer> gemPQ = new PriorityQueue<>(Collections.reverseOrder());
		
		while(!gems.isEmpty() && !bag.isEmpty()) {
			Gem front = gems.peek();
			if(!bag.isEmpty() && bag.peek() >= front.m) {
				gemPQ.offer(gems.poll().v);
			}else {
				if(!bag.isEmpty()) bag.poll();
				if(!gemPQ.isEmpty()) {
					answer+=gemPQ.poll();
				}
			}
		}
		while(!bag.isEmpty() && !gemPQ.isEmpty()) {
			if(!gemPQ.isEmpty()) {
				answer+=gemPQ.poll();
				bag.poll();
			}
		}
		
		System.out.println(answer);
	}	
	static class Gem implements Comparable<Gem>{
		int m;
		int v;
		public Gem(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(Gem o) {
			return Integer.compare(this.m, o.m);
		}
		@Override
		public String toString() {
			return "Jem [m=" + m + ", v=" + v + "]";
		}
		
		
	}
	static String src =
			"2 1\r\n"
			+ "5 10\r\n"
			+ "100 100\r\n"
			+ "11";
}	
