package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_14696_딱지놀이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static long aScore[], bScore[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		aScore = new long[N];
		bScore = new long[N];
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int k = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j<k; j++) {
				int x = Integer.parseInt(tokens.nextToken());
				switch (x) {
				case 4:
					aScore[i] += 1000000000;
					break;
				case 3:
					aScore[i] += 1000000;
					break;
				case 2:
					aScore[i] += 1000;
					break;
				case 1:
					aScore[i] += 1;
					break;
				}
			}
			
			tokens = new StringTokenizer(input.readLine());
			k = Integer.parseInt(tokens.nextToken());
			for(int j = 0; j<k; j++) {
				int x = Integer.parseInt(tokens.nextToken());
				switch (x) {
				case 4:
					bScore[i] += 1000000000;
					break;
				case 3:
					bScore[i] += 1000000;
					break;
				case 2:
					bScore[i] += 1000;
					break;
				case 1:
					bScore[i] += 1;
					break;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
//			System.out.println("aScore["+i+"] : "+aScore[i]+" bScore["+i+"] : "+bScore[i]);
			if(aScore[i] > bScore[i]) {
				System.out.println("A");
			}else if(aScore[i] < bScore[i]) {
				System.out.println("B");
			}else {
				System.out.println("D");
			}
		}
	}
	static String src = 
			"4\r\n" + 
			"4 4 3 2 1\r\n" + 
			"4 1 4 3 2\r\n" + 
			"4 3 3 2 1\r\n" + 
			"4 4 3 3 3\r\n" + 
			"4 4 3 3 3\r\n" + 
			"4 3 4 3 2\r\n" + 
			"4 3 2 1 1\r\n" + 
			"3 3 2 1";
}
