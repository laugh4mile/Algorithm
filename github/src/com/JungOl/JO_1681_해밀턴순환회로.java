package com.JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1681_해밀턴순환회로 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,map[][],min=Integer.MAX_VALUE,sum;
	static boolean isVisited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
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
		
		for(int i=0; i<N; i++) {
			isVisited = new boolean[N];
			sum = 0;
			if(map[0][i] != 0 ) {
				dfs(0,i,1);
			}
		}
		System.out.println(min);
	}
	

	private static void dfs(int start, int end, int depth) {
		sum += map[start][end];
		isVisited[start] = true;
		if(depth == N-1) {
			sum += map[end][0];
			if(map[end][0] == 0) {
				return;
			}
			min = Math.min(min, sum);
			sum -= map[end][0];
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isVisited[i] && map[end][i] != 0) {
				dfs(end, i, depth+1);
				sum -= map[end][i];
				isVisited[i] = false;
			}
		}
	}


	static String src = 
			"5\r\n" + 
			"0 14 4 10 20 \r\n" + 
			"14 0 7 8 7 \r\n" + 
			"4 5 0 7 16 \r\n" + 
			"11 7 9 0 2 \r\n" + 
			"18 7 17 4 0";
}
