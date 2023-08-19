package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_13335_트럭 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,W,L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		Queue<Integer> trucks = new LinkedList<>();
		for(int n=0; n<N; n++) {
			trucks.offer(Integer.parseInt(tokens.nextToken()));
		}
		
		Queue<Integer> bridge = new LinkedList<>();
		for(int w=0; w<W; w++) {
			bridge.offer(0);
		}
		int cnt = 0;
		int sum = 0;
		while(!bridge.isEmpty()) {
			sum -= bridge.poll();
			if(!trucks.isEmpty()) {
				if(sum + trucks.peek() <= L) {
					int newTruck = trucks.poll();
					sum += newTruck;
					bridge.offer(newTruck);
				}else {
					bridge.offer(0);
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	static String src =
			"4 2 10\r\n" + 
			"7 4 5 6";
}
