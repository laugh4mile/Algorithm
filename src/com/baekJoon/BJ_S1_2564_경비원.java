package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_2564_경비원 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C,S, store[][], map[];
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(input.readLine());
		store = new int[S][2];
		map = new int[(2*R+2*C)];
		int cnt = 1;
		for(int s=0; s<S; s++) {
			tokens = new StringTokenizer(input.readLine());
			store[s][0] = Integer.parseInt(tokens.nextToken()); 
			store[s][1] = Integer.parseInt(tokens.nextToken()); 
			
			switch (store[s][0]) {
			case 1:
				map[store[s][1]] = cnt++;
				break;
			case 4:
				map[C+store[s][1]] = cnt++;
				break;
			case 2:
				map[C+R+(C-store[s][1])] = cnt++;
				break;
			case 3:
				map[C+R+C+(R-store[s][1])] = cnt++;
				break;
			}
		}
		tokens = new StringTokenizer(input.readLine());
		int d1 = Integer.parseInt(tokens.nextToken()); 
		int d2 = Integer.parseInt(tokens.nextToken()); 
		int j = 0;
		switch (d1) {
		case 1:
			map[d2] = -1;
			j = d2;
			break;
		case 4:
			map[C+d2] = -1;
			j = C+d2;
			break;
		case 2:
			map[C+R+(C-d2)] = -1;
			j = C+R+(C-d2);
			break;
		case 3:
			map[C+R+C+(R-d2)] = -1;
			j = C+R+C+(R-d2);
			break;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=j+1; i<map.length; i++) {
			queue.offer(map[i]);
		}
		for(int i=0; i<=j; i++) {
			queue.offer(map[i]);
		}
		int index = 0;
		while(!queue.isEmpty()) {
			map[index++] = queue.poll();
		}
		
		int [] map2 = new int[(2*R+2*C)*2-1];
		
		for(int i=0; i<map2.length; i++) {
			map2[i] = map[i%(2*R+2*C)];
		}
		int center = 2*R+2*C-1;
		
		int result = 0;
		for(int s=1; s<=S; s++) {
			int left = 0;
			int right = 0;
			for(int i=0; i<center; i++) {
				if(map2[i] == s) {
					left = center-i;
				}
			}
			for(int i=center; i<map2.length; i++) {
				if(map2[i] == s) {
					right = i-center;
				}
			}
			
			if(left > right) {
				result += right;
			}else {
				result += left;
			}
		}
		System.out.println(result);
	}
	static String src =
			"10 5\r\n" + 
			"3\r\n" + 
			"1 4\r\n" + 
			"3 2\r\n" + 
			"2 8\r\n" + 
			"2 3";
}
