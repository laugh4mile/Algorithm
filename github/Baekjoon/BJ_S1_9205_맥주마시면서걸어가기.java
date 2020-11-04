package com.BackJoon;

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

public class BJ_S1_9205_맥주마시면서걸어가기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,map[][];
	static boolean beerOut;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int[N+2][2];
			for(int i=0; i<N+2; i++) {
				tokens = new StringTokenizer(input.readLine());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
				map[i][0] = x;
				map[i][1] = y;
			}
			int hx = map[0][0];
			int hy = map[0][1];
			int fx = map[N+1][0];
			int fy = map[N+1][1];
//			for(int[] x : map) {
//				System.out.println(Arrays.toString(x));
//			}
			Arrays.sort(map, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
//					int sum1 = 0;
//					int sum2 = 0;
//					for(int i=0; i<o1.length; i++) {
//						sum1 += o1[i];
//						sum2 += o2[i];
//					}
//					return Integer.compare(sum1, sum2);
					int dx1 = Math.abs(o1[0] - map[0][0]);
					int dy1 = Math.abs(o1[1] - map[0][1]);
					
					int dx2 = Math.abs(o2[0] - map[0][0]);
					int dy2 = Math.abs(o2[1] - map[0][1]);
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
			int indexH = 0;
			int indexF = 0;
			for(int i=0; i<N+2; i++) {
				if(map[i][0] == hx && map[i][1] == hy) {
					indexH = i;
				}
			}
			for(int i=0; i<N+2; i++) {
				if(map[i][0] == fx && map[i][1] == fy) {
					indexF = i;
				}
			}
			for(int i=indexH; i<indexF; i++) {
				if(Math.abs(map[i+1][0]-map[i][0]) + Math.abs(map[i+1][1]-map[i][1]) > 1000) {
					beerOut = true;
					break;
				}
			}
			if(beerOut) {
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
			beerOut = false;
			
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
