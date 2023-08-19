package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B1_18868_멀티버스1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int M,N,map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		map = new int[M][N];
		
		for(int r=0; r<M; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		
		int answer = 0;
		for(int i=0; i<M-1; i++) {
			for(int j=i+1; j<M; j++) {
				if(!compare(map[i], map[j])) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

	private static boolean compare(int[] arr1, int[] arr2) {
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr1[i] > arr1[j]) {
					if(arr2[i] <= arr2[j]) {
						return true;
					}
				}else if(arr1[i] < arr1[j]) {
					if(arr2[i] >= arr2[j]) {
						return true;
					}
				}else {
					if(arr2[i] != arr2[j]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static String src =
			"5 3\r\n" + 
			"20 10 30\r\n" + 
			"10 20 60\r\n" + 
			"80 25 79\r\n" + 
			"30 50 80\r\n" + 
			"80 25 81";
}
