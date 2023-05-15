package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_G4_11404_플로이드2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M, result[][];
	static int INF = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		M = Integer.parseInt(input.readLine());
		
		result = new int [N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result[i][j] = INF;
			}	
		}

		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int val = Integer.parseInt(tokens.nextToken());
			
			if(result[from-1][to-1] > val) {
				result[from-1][to-1] = val;
			}
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
//					if(i==j) continue;
					if(result[i][j] > result[i][k] + result[k][j]) {
						result[i][j] = result[i][k] + result[k][j];
					}
				}	
			}	
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j || result[i][j] == 1000000000) {
					System.out.print(0+" ");
				}else {
					System.out.print(result[i][j]+" ");
				}
			}	
			System.out.println();
		}
	}
	
	static String src = 
			"5\r\n" + 
			"14\r\n" + 
			"1 2 2\r\n" + 
			"1 3 3\r\n" + 
			"1 4 1\r\n" + 
			"1 5 10\r\n" + 
			"2 4 2\r\n" + 
			"3 4 1\r\n" + 
			"3 5 1\r\n" + 
			"4 5 3\r\n" + 
			"3 5 10\r\n" + 
			"3 1 8\r\n" + 
			"1 4 2\r\n" + 
			"5 1 7\r\n" + 
			"3 4 2\r\n" + 
			"5 2 4";
}
