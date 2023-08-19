package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_1719_택배2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,result[][],result2[][], INF = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		result = new int[N][N];
		result2 = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result[i][j] = INF;
				result2[i][j] = j+1;
				if(i==j) {
					result[i][j] = 0;
					result2[i][j] = 0;
				}
			}	
		}
		for(int i=0; i<M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int from = Integer.parseInt(tokens.nextToken());
			int to = Integer.parseInt(tokens.nextToken());
			int val = Integer.parseInt(tokens.nextToken());
			result[from-1][to-1] = val;
			result[to-1][from-1] = val;
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(result[i][j] > result[i][k]+result[k][j]) {
						result[i][j] = result[i][k]+result[k][j];
						result2[i][j] = k+1;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				int t = j;
				while(result2[i][t] != t+1) {
					t = result2[i][t]-1;
				}
				result2[i][j] = t+1;
			}	
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) {
					System.out.print("- ");
				}else {
					System.out.print(result2[i][j]+" ");
				}
			}	
			System.out.println();
		}
	}
	
	static String src =
			"6 10\r\n" + 
			"1 2 2\r\n" + 
			"1 3 1\r\n" + 
			"2 4 5\r\n" + 
			"2 5 3\r\n" + 
			"2 6 7\r\n" + 
			"3 4 4\r\n" + 
			"3 5 6\r\n" + 
			"3 6 7\r\n" + 
			"4 6 4\r\n" + 
			"5 6 2";
}
