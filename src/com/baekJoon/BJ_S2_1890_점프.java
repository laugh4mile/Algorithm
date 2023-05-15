package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_1890_점프 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int map[][] = new int[N][N];
		long dp[][] = new long[N][N];
		dp[0][0] = 1;
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				if(r==N-1 && c==N-1) break;
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if((r!=0 || c!=0) && dp[r][c] == 0) {
					continue;
				}
				int nr = r+map[r][c];
				int nc = c+map[r][c];
				if(isIn(nr, c, N)) {
					dp[nr][c] = dp[nr][c] + dp[r][c];
				}
				if(isIn(r, nc, N)) {
					dp[r][nc] = dp[r][nc] + dp[r][c];
				}
			}	
		}
//		for(long x[] : dp) {
//			System.out.println(Arrays.toString(x));
//		}
		System.out.println(dp[N-1][N-1]);
		
	}
	static boolean isIn(int r, int c, int N) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	static String src =
			"4\r\n"
			+ "2 3 3 1\r\n"
			+ "1 2 1 3\r\n"
			+ "1 2 3 1\r\n"
			+ "3 1 1 0";
}
