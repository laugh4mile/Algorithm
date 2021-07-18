package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_S1_19638_센티와마법의뿅망치 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,H,T;
	static PriorityQueue<Integer> giant = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		for(int n=0; n<N; n++) {
			giant.offer(Integer.parseInt(input.readLine()));
		}
		int tallest;
		int temp = T;
		while(temp>0) {
			tallest = giant.poll();
			if(tallest < H) {
				giant.offer(tallest);
				break;
			}else {
				if(tallest/2 == 0) {
					giant.offer(1);
					break;
				}else {
					giant.offer(tallest/2);
				}
			}
			temp--;
		}
		
		if(giant.peek() < H) {
			System.out.println("YES");
			System.out.println(T-temp);
		}else {
			System.out.println("NO");
			System.out.println(giant.peek());
		}
	}

	static String src =
			"1 1 100000\r\n" + 
			"1";
}
