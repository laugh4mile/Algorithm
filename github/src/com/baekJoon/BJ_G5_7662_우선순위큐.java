package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_7662_우선순위큐 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for (int t = 0; t < T; t++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
			K = Integer.parseInt(input.readLine());
			for (int k = 0; k < K; k++) {
				tokens = new StringTokenizer(input.readLine());
				char cmd = tokens.nextToken().charAt(0);
				int num = Integer.parseInt(tokens.nextToken());
				if (cmd == 'I') {
					pq.offer(num);
					pq2.offer(num);
				}
				if (cmd == 'D') {
					if (num == -1 && !pq.isEmpty()) {
						int min = pq.poll();
						pq2.remove(min);
					} else if (num == 1 && !pq2.isEmpty()) {
						int max = pq2.poll();
						pq.remove(max);
					}
				}
			}
			if(pq.isEmpty()) {
				output.append("EMPTY\n");
			}else {
				output.append(pq.peek()+" "+pq2.peek()+"\n");
			}
		}
		output.close();
	}

	static String src = "2\r\n" + "7\r\n" + "I 16\r\n" + "I -5643\r\n" + "D -1\r\n" + "D 1\r\n" + "D 1\r\n"
			+ "I 123\r\n" + "D -1\r\n" + "9\r\n" + "I -45\r\n" + "I 653\r\n" + "D 1\r\n" + "I -642\r\n" + "I 45\r\n"
			+ "I 97\r\n" + "D 1\r\n" + "D -1\r\n" + "I 333";
}
