package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_D2_2001_파리퇴치 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int T,N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
		T = Integer.parseInt(input.readLine());
		for(int testCase=0; testCase<T; testCase++) {
			StringTokenizer tokens = new StringTokenizer(input.readLine()," ");
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			map = new int[N][N];
			for(int row=0; row<N; row++) {
				tokens = new StringTokenizer(input.readLine()," ");
				for(int col=0; col<N; col++) {
					map[row][col] = Integer.parseInt(tokens.nextToken());
				}
			}
			int sum[] = new int[(N-M+1)*(N-M+1)];
			int count=0;
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							sum[count]+=map[k][l];
						}
					}
					count++;
				}
			}
			System.out.printf("#%d %d\n",testCase+1,maxOfArray(sum));
		}
    }
    static int maxOfArray(int [] arr) {
    	int max=0;
    	for(int i=0; i<arr.length; i++) {
    		if(max<arr[i]) {
    			max = arr[i];
    		}
    	}
    	return max;
    }
}
