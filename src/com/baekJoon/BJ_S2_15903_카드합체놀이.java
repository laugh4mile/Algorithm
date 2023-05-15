package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S2_15903_카드합체놀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			pq.offer(Long.parseLong(tokens.nextToken()));
		}
		long sum = 0;
		for(int i=0; i<M; i++) {
			sum = pq.poll();
			sum += pq.poll();
			pq.offer(sum);
			pq.offer(sum);
		}
		
		long answer = 0;
		
		for(int i=0; i<N; i++) {
			answer += pq.poll();
		}
		
		System.out.println(answer);
	}

	static String src =
			"4 2\r\n"
			+ "4 2 3 1";
}
