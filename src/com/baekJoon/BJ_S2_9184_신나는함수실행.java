package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_9184_신나는함수실행 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		int dp[][][] = new int[21][21][21];
		for(int i=0; i<21; i++) {
			for(int j=0; j<21; j++) {
				for(int k=0; k<21; k++) {
					if(i==0 || j==0 || k==0) {
						dp[i][j][k] = 1;
						continue;
					}
					if(i<j && j<k) {
						dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
					}else {
						dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
					}
				}	
			}	
		}
//		for(int i=0; i<1; i++) {
//			for(int j=0; j<21; j++) {
//				for(int k=0; k<21; k++) {
//					System.out.print(dp[i][j][k]+" ");
//				}	
//				System.out.println();
//			}	
//			System.out.println();
//			System.out.println();
//		}
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			if(a==-1 && a==b && a==c) {
				break;
			}
			sb.append("w("+a+", "+b+", "+c+") = ");
			if(a<=0 || b<=0 || c<=0) {
				sb.append(dp[0][0][0]+"\n");
			}else if(a>20 || b>20 || c>20) {
				sb.append(dp[20][20][20]+"\n");
			}else {
				sb.append(dp[a][b][c]+"\n");
			}
			
			
		}
		System.out.println(sb);
		
	}

	static String src =
			"1 1 1\r\n"
			+ "2 2 2\r\n"
			+ "10 4 6\r\n"
			+ "50 50 50\r\n"
			+ "-1 7 18\r\n"
			+ "-1 -1 -1";
}
