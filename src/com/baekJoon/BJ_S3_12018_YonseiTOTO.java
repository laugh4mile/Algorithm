package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S3_12018_YonseiTOTO {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int P = Integer.parseInt(tokens.nextToken());
			int L = Integer.parseInt(tokens.nextToken());
			
			tokens = new StringTokenizer(input.readLine());
			Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for(int p=0; p<P; p++) {
				pq.offer(Integer.parseInt(tokens.nextToken()));
			}
			if(P >= L) {
				for(int l=0; l<L-1; l++) {
					pq.poll();
				}
				queue.offer(pq.poll());
			}else {
				queue.offer(1);
			}
		}
		int answer = 0;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			if(M >= temp) {
				M -= temp;
				answer++;
			}else {
				break;
			}
		}
		System.out.println(answer);
	}

	static String src =
			"5 76\r\n" + 
			"5 4 \r\n" + 
			"36 25 1 36 36\r\n" + 
			"4 4\r\n" + 
			"30 24 25 20\r\n" + 
			"6 4\r\n" + 
			"36 36 36 36 36 36\r\n" + 
			"2 4\r\n" + 
			"3 7\r\n" + 
			"5 4\r\n" + 
			"27 15 26 8 14";
}
