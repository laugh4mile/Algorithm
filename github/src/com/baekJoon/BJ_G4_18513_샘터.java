package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_18513_샘터 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		tokens = new StringTokenizer(input.readLine());
		
		Map<Integer, Boolean> map = new HashMap<>(); // 방문 체크하는 용도
		Queue<Integer> queue = new LinkedList<>();
		for(int n=0; n<N; n++) {
			int spring = Integer.parseInt(tokens.nextToken());
			queue.offer(spring);
			map.put(spring, true);
		}
		
		int distance = 0;
		int k = 0;
		long unhappiness = 0;
		outer : while(k<K) {
			distance++;
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int front = queue.poll();
				
				if(!isIn(front-distance) || !isIn(front+distance)) continue;
				if(map.get(front+distance) != null && map.get(front-distance) != null) continue;
				
				if(map.get(front-distance) == null) {
					map.put(front-distance, true);
					k++;
					unhappiness += distance;
				}
				if(k==K) {
					break outer;
				}
				
				if(map.get(front+distance) == null) {
					map.put(front+distance, true);
					k++;
					unhappiness += distance;
				}
				
				if(k==K) {
					break outer;
				}
				queue.offer(front);
			}
		}
		System.out.println(unhappiness);
		
	}
	
	static boolean isIn(int n) {
		return (n>=-100000000 && n<=100000000);
	}
	
	static String src =

			"1 1\r\n" + 
			"0";
}
