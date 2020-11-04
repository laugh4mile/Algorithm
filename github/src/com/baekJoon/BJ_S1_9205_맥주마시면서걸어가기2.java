package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_9205_맥주마시면서걸어가기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,map[][],copy[][];
	static boolean result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N+2][2];
			copy = new int[N][2];
			for(int i=0; i<N+2; i++) {
				tokens = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				map[i][0] = x;
				map[i][1] = y;
			}
			
			for(int i=1; i<N+1; i++) {
				for(int j=0; j<2; j++) {
					copy[i-1][j] = map[i][j];
				}
			}
			
//			for(int[] x : map) {
//				System.out.println(Arrays.toString(x));
//			}
//			System.out.println();
//			for(int[] x : copy) {
//				System.out.println(Arrays.toString(x));
//			}
			Arrays.sort(copy, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
//					int sum1 = 0;
//					int sum2 = 0;
//					for(int i=0; i<o1.length; i++) {
//						sum1 += o1[i];
//						sum2 += o2[i];
//					}
//					return Integer.compare(sum1, sum2);
					int dx1 = Math.abs(o1[0] - copy[0][0]);
					int dy1 = Math.abs(o1[1] - copy[0][1]);
					
					int dx2 = Math.abs(o2[0] - copy[0][0]);
					int dy2 = Math.abs(o2[1] - copy[0][1]);
					return Integer.compare(dx1+dy1, dx2+dy2);
					
				}
			});
			
//			for(int i=0; i<N+2; i++) {
//				Arrays.sort(map[i]);
//			}
//			for(int[] x : map) {
//				System.out.println(Arrays.toString(x));
//			}
//			bfs(map[0][0],map[0][1]);
			
			for(int i=1; i<N+1; i++) {
				for(int j=0; j<2; j++) {
					map[i][j] = copy[i][j];
				}
			}
			
			for(int i=0; i<N+1; i++) {
				if(Math.abs(map[i+1][0]-map[i][0]) + Math.abs(map[i+1][1]-map[i][1]) > 1000) {
					result = true;
					break;
				}
			}
			if(result) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
			result = false;
			
		}
		
	}
	static String src = "2\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"1000 1000\r\n" + 
			"2000 1000\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"2000 1000\r\n" + 
			"2000 2000";
}
