package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_18442_우체국1 { 
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
	static StringTokenizer tokens; 
	static int V, P;
	static long L, village[], post[], result[], answer[], minSum = Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException { 
		input = new BufferedReader(new StringReader(src)); 
		tokens = new StringTokenizer(input.readLine()); 
		V = Integer.parseInt(tokens.nextToken()); 
		P = Integer.parseInt(tokens.nextToken()); 
		L = Long.parseLong(tokens.nextToken());
		village = new long[V];
		post = new long[P];
		result = new long[P];
		answer = new long[P];
		
		tokens = new StringTokenizer(input.readLine()); 
		for(int v=0; v<V; v++) {
			village[v] = Long.parseLong(tokens.nextToken());
		}
		
		combi(0,0);
		
		System.out.println(minSum);
		for(long x : answer) {
			System.out.print(x+" ");
		}
			
	}
	private static void combi(int start, int cnt) {
		if(cnt == P) {
			getDist();
			return;
		}
		for(int i=start; i<V; i++) {
			result[cnt] = village[i];
			combi(i+1, cnt+1);
		}
	}
	private static void getDist() {
		long sumDist = 0;
		for(int v=0; v<V; v++) {
			long minDist = Long.MAX_VALUE;
			for(int p=0; p<P; p++) {
				long chai = Math.min(Math.abs(village[v] - result[p])
						, Math.min(village[v], result[p])+L - Math.max(village[v], result[p]));
				if(minDist > chai) {
					minDist = chai;
				}
			}
			sumDist += minDist;
		}
		
		if (sumDist < minSum) {
			minSum = sumDist;
			answer = result.clone();
		}
	}
	static String src = // 예제 입력
			"10 5 200\r\n" + 
			"1 2 3 6 7 9 11 22 44 50";
}
