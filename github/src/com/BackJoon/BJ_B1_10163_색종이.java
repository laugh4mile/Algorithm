package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B1_10163_색종이 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, paper[][], map[][] = new int[101][101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		paper = new int[N][4];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<4; j++) {
				paper[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
//		for(int x[]: paper) {
//			System.out.println(Arrays.toString(x));
//		}
		
		for(int k=0; k<N; k++) {
			for(int i=paper[k][0]; i<paper[k][0]+paper[k][2]; i++) {
				for(int j=paper[k][1]; j<paper[k][1]+paper[k][3]; j++) {
					map[i][j] = k+1;
				}
			}	
		}
		
//		for(int x[]: map) {
//			System.out.println(Arrays.toString(x));
//		}
		int result[] = new int[N+1];
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				for(int k=1; k<=N; k++) {
					if(map[i][j] == k) {
						result[k]++;
					}
				}
			}
		}
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
	}	
	static String src = 
			"2\r\n" + 
			"0 0 10 10\r\n" + 
			"2 2 6 6";
}
