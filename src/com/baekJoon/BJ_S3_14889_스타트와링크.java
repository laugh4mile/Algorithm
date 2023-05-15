package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S3_14889_스타트와링크 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], result[], min = Integer.MAX_VALUE, sum1, sum2;
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		result = new int[N/2];
		isVisited = new boolean[N];
		map = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}	
		}
		
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		combi(0,0);
		System.out.println(min);
	}
	private static void combi(int start, int cnt) {
		if(cnt == N/2) {
//			System.out.println(Arrays.toString(result));
//			System.out.println(Arrays.toString(isVisited));
			
//			for(int i=0; i<result.length-1; i++) {
//				for(int j=i+1; j<result.length; j++) {
//					sum += map[result[i]][result[j]] + map[result[j]][result[i]];
//				}	
//			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(isVisited[i] &&  isVisited[j]) {
						sum1 += map[i][j];
					}
					
					if(!isVisited[i] &&  !isVisited[j]) {
						sum2 += map[i][j];
					}
				}	
			}
			
			if(min > Math.abs(sum1-sum2)) {
				min = Math.abs(sum1-sum2);
			}
			
			sum1 = 0;
			sum2 = 0;
			return;
		}
		for(int i=start; i<N; i++) {
			result[cnt] = i;
			isVisited[i] = true;
			combi(i+1, cnt+1);
			isVisited[i] = false;
		}
	}
	static String src = "8\r\n" + 
			"0 5 4 5 4 5 4 5\r\n" + 
			"4 0 5 1 2 3 4 5\r\n" + 
			"9 8 0 1 2 3 1 2\r\n" + 
			"9 9 9 0 9 9 9 9\r\n" + 
			"1 1 1 1 0 1 1 1\r\n" + 
			"8 7 6 5 4 0 3 2\r\n" + 
			"9 1 9 1 9 1 0 9\r\n" + 
			"6 5 4 3 2 1 9 0";
}
