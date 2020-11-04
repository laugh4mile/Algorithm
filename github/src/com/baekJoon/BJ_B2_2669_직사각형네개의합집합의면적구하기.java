package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_2669_직사각형네개의합집합의면적구하기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int sq[][] = new int[4][4];
	static int map[][] = new int[101][101];
	
	static StringTokenizer tokens;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		for(int i=0; i<4; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j=0; j<4; j++) {
				sq[i][j] = Integer.parseInt(tokens.nextToken()); 
			}
		}
		for(int k=0; k<4; k++) {
			for(int i=sq[k][0]; i<sq[k][2]; i++) {
				for(int j=sq[k][1]; j<sq[k][3]; j++) {
					map[i][j] = 1;
				}
			}
		}
		int result = 0;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100; j++) {
				if(map[i][j]==1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	static String src = 
			"1 2 4 4\r\n" + 
			"2 3 5 7\r\n" + 
			"3 1 6 5\r\n" + 
			"7 3 8 6";
}
