package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_S1_1992_쿼드트리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int N, map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		int sum = 0;
		for(int n=0; n<N; n++) {
			String line = input.readLine();
			for(int c=0; c<N; c++) {
				map[n][c] = line.charAt(c) - '0';
				sum+= map[n][c];
			}
		}
//		for(int []x : map) {
//			System.out.println(Arrays.toString(x));
//		}
		if(sum == 0) {
			System.out.println(0);
		}else if(sum == N*N) {
			System.out.println(1);
		}else {
			System.out.print("(");
			quadTree(N,0,0);
			System.out.print(")");
		}
	}
	private static void quadTree(int len,int sr, int sc) {
		int newN = len/2;
		int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0;
		for(int r=sr; r < sr+newN; r++) {
			for(int c=sc; c < sc+newN ; c++) {
				sum1 += map[r][c];
			}	
		}
		for(int r=sr; r < sr+newN; r++) {
			for(int c=sc+newN; c < sc+newN+newN ; c++) {
				sum2 += map[r][c];
			}	
		}
		for(int r=sr+newN; r < sr+newN+newN; r++) {
			for(int c=sc; c < sc+newN ; c++) {
				sum3 += map[r][c];
			}	
		}
		for(int r=sr+newN; r < sr+newN+newN; r++) {
			for(int c=sc+newN; c < sc+newN+newN ; c++) {
				sum4 += map[r][c];
			}	
		}
//		System.out.println(sum1+" "+sum2+" "+sum3+" "+sum4);
		
		
		if(sum1 == newN*newN) {
			System.out.print(1);
		}else if(sum1 == 0) {
			System.out.print(0);
		}else {
			System.out.print("(");
			quadTree(newN,sr,sc);
			System.out.print(")");
		}
		
		if(sum2 == newN*newN) {
			System.out.print(1);
		}else if(sum2 == 0) {
			System.out.print(0);
		}else {
			System.out.print("(");
			quadTree(newN,sr,sc+newN);
			System.out.print(")");
		}
		
		if(sum3 == newN*newN) {
			System.out.print(1);
		}else if(sum3 == 0) {
			System.out.print(0);
		}else {
			System.out.print("(");
			quadTree(newN,sr+newN,sc);
			System.out.print(")");
		}
		
		if(sum4 == newN*newN) {
			System.out.print(1);
		}else if(sum4 == 0) {
			System.out.print(0);
		}else {
			System.out.print("(");
			quadTree(newN,sr+newN,sc+newN);
			System.out.print(")");
		}
		
		
	}
	static String src = "4\r\n" + 
			"1111\r\n" + 
			"1111\r\n" + 
			"1111\r\n" + 
			"1111";

}
