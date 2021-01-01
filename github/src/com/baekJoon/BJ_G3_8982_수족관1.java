package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G3_8982_수족관1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, K, aquarium[], holeIndex[],drainedWater[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		List<Node> list = new ArrayList<>();
		int len = 0;
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int c = Integer.parseInt(tokens.nextToken());
			int r = Integer.parseInt(tokens.nextToken());
			list.add(new Node(r, c));
			if(len < c) {
				len = c;
			}
		}
		aquarium = new int[len];
		drainedWater = new int[len];
		int cnt = 0;
		for(int i=1; i<list.size()-1; i=i+2) {
			int c1 = list.get(i).c;
			int c2 = list.get(i+1).c;
			for(int j = c1; j<c2; j++) {
				aquarium[cnt++] = list.get(i).r;
			}
		}
		K = Integer.parseInt(input.readLine());
		holeIndex = new int[K];
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			holeIndex[k] = Integer.parseInt(tokens.nextToken());
		}// 입력 끝
		solve();
		int answer = 0;
		for(int i=0; i<aquarium.length; i++) {
			answer += aquarium[i] - drainedWater[i];
		}
		System.out.println(answer);
		
	}
	
	private static void solve() {
		for(int k=0; k<K; k++) {
			int h = holeIndex[k];
			int cur = aquarium[h];
			drainedWater[h] = cur;
			for(int i=h; i<aquarium.length; i++) { // 오른쪽
				if(cur < aquarium[i]) {
					drainedWater[i] = Math.max(drainedWater[i], cur);
				}else {
					cur = aquarium[i];
					drainedWater[i] = Math.max(drainedWater[i], cur);
				}
			}
			cur = aquarium[h];
			for(int i=h ; i>=0; i--) { // 왼
				if(cur < aquarium[i]) {
					drainedWater[i] = Math.max(drainedWater[i], cur);
				}else {
					cur = aquarium[i];
					drainedWater[i] = Math.max(drainedWater[i], cur);
				}
			}
		}
	}

	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}
	}
	static String src =
			"8\r\n" + 
			"0 0 \r\n" + 
			"0 5\r\n" + 
			"1 5\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n" + 
			"2 4\r\n" + 
			"3 4\r\n" + 
			"3 0\r\n" + 
			"1\r\n" + 
			" 0 5 1 5";
}
