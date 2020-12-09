package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_3349_최솟값으로이동하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,W,H,N, arr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			W = Integer.parseInt(tokens.nextToken());
			H = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());
			arr = new int[N][2];
			
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				arr[n][0] = Integer.parseInt(tokens.nextToken());
				arr[n][1] = Integer.parseInt(tokens.nextToken());
			}
			int answer = solve(arr);
//			for(int x[]: arr) {
//				System.out.println(Arrays.toString(x));
//			}
			System.out.println("#"+t+" "+answer);
		}
	}

	private static int solve(int[][] arr) {
		int answer = 0;
		for(int i=0; i<arr.length-1; i++) {
			int r1, r2, c1, c2, R, C;
			r1 = arr[i][0];
			c1 = arr[i][1];
			r2 = arr[i+1][0];
			c2 = arr[i+1][1];
			
			R = Math.abs(r2-r1);
			C = Math.abs(c2-c1);
			if(r2 >= r1 && c2 >= c1) {
				answer += Math.max(R, C);
			}
			if(r2 < r1 && c2 > c1) {
				answer += R + C;
			}
			if(r2 <= r1 && c2 <= c1) {
				answer += Math.max(R, C);
			}
			if(r2 > r1 && c2 < c1) {
				answer += R + C;
			}			
		}
		
		return answer;
	}

	static String src =
			"1\r\n" + 
			"4 3 3\r\n" + 
			"4 1\r\n"+
			"1 1\r\n" + 
			"3 3\r\n" + 
			"";
}
