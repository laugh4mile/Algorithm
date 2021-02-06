package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_1697_숨바꼭질 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K,cnt;
	static int []min;
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		isVisited = new boolean[100001];
		min = new int [100001];
		bfs(N);
		System.out.println(min[K]);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		int[] c = new int[3];
		min[start] = 0;
		isVisited[start] = true;
		
		while(!queue.isEmpty() && start != K) {
			start = queue.poll();
			c[0] = start-1;		
			c[1] = start+1;		
			c[2] = start*2;	
			
			for(int i =0; i<3; i++) {
				if(isIn(c[i]) && !isVisited[c[i]]) {
					queue.offer(c[i]);
					isVisited[c[i]] = true;
					min[c[i]] = min[start]+1;
				}
			}
				
		}
	}
	static boolean isIn(int i) {
		return (i>=0 && i< 100001);
	}
	
	static String src = "50000 100000";

}
