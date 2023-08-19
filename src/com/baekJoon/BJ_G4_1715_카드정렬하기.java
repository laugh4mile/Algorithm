package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G4_1715_카드정렬하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		for(int n=0; n<N; n++) {
			pq.offer(Integer.parseInt(input.readLine()));
		}
		int sum = 0;
		if(N == 1) {// N 이 1 일경우 걍 출력
			System.out.println(0);
		}else {
			while(true) {
				int num1 = pq.poll();
				int num2 = pq.poll();
				sum += num1 + num2;
				if(pq.isEmpty()) {
					break;
				}
				pq.offer(num1 + num2);
			}
			System.out.println(sum);
		}

	}

	static String src =
			"5\r\n" + 
			"10\r\n" + 
			"20\r\n" + 
			"40\r\n" + 
			"50\r\n" + 
			"60";
}
