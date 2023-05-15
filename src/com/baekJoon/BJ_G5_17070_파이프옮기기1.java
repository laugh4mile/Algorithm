package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_17070_파이프옮기기1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, map[][], cnt, or, oc;
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
		or = 0;
		oc = 0;
		dfs(0,1,0);
		System.out.println(cnt);
		
	}
	
	private static void dfs(int r, int c, int d) {
//		System.out.println(map[r][c]);
		if(r==N-1 && c==N-1) {
			cnt++;
			return;
		}
		
		if (d !=2 && isIn(r, c+1) && map[r][c+1] ==0) {
			dfs(r, c + 1, 0);
		}
		if (d != 0 && isIn(r + 1, c) && map[r + 1][c] == 0) {
			dfs(r + 1, c, 2);
		}
		if (isIn(r + 1, c + 1) && map[r + 1][c] == 0 && map[r + 1][c + 1] == 0 && map[r][c + 1] == 0) {
			dfs(r + 1, c + 1, 1);
		}
		
	}

	static int dx[] = {1,0,1};
	static int dy[] = {0,1,1};
	
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	
	static String src = 
			"6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0";
}
