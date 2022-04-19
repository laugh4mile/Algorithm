package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayTest2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());

		map = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
//		printMap();
		dfs(0, map);
//		printMap();
	}

	private static void dfs(int cnt, int[][] map) {
		if(cnt==2){
			printMap(map);
			return;
		}
		for(int d=0; d<2; d++){
			dfs(cnt+1, move(d, map));
		}
	}

	private static int[][] move(int d, int[][] map) {
		int temp[][] = new int[N][N];
		for(int r=0; r<N; r++){
			for(int c=0; c<N; c++){
				temp[r][c] = map[r][c];
			}
		}
		if(d == 0){
			temp[0][0]++;
		}else{
			temp[1][1]++;
		}
		return temp;
	}


	private static void printMap(int [][]arr) {
		for(int[] x: arr){
			System.out.println(Arrays.toString(x));
		}
		System.out.println();
	}

	static String src =
			"3\n" +
			"0 0 0\n" +
			"0 0 0\n" +
			"0 0 0";
}
