package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_15489_파스칼삼각형 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int R = Integer.parseInt(tokens.nextToken())-1;
		int C = Integer.parseInt(tokens.nextToken())-1;
		int W = Integer.parseInt(tokens.nextToken());
		int arr[][] = new int[30][30];
		for(int i=0; i<30; i++) {
			arr[i][0] = 1;
			arr[0][i] = 1;
		}
		for(int r=1; r<30; r++) {
			for(int c=1; c<30; c++) {
				arr[r][c] = arr[r-1][c] + arr[r][c-1];
			}	
		}
//		for(int x[] : arr) {
//			System.out.println(Arrays.toString(x));
//		}
//		System.out.println();
//		System.out.println();
//		System.out.println();
		int answer = 0;
		int cnt = C+W;
		for(int r=R-C; r<R-C+W; r++) {
			for(int c=C; c<cnt; c++) {
				answer += arr[r][c];
//				System.out.print(arr[r][c]+" ");
			}	
//			System.out.println();
			cnt--;
		}
		System.out.println(answer);
	}

	static String src =
			"1 1 4";
}