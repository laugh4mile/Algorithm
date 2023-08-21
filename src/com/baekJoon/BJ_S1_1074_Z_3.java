package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1074_Z_3 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, r, c, answer;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());


		
		N = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());

		solve(N,r,c, 0);
		System.out.println(answer);
		
	}

	private static void solve(int n, int r, int c, int cnt) {
		if(n == 0){
			answer = cnt;
			return;
		}
//		System.out.println(n+"  "+cnt);
		int mid = (int) Math.pow(2, n)/2;

		if(r < mid && c < mid){ // 1 사분면
			solve(n-1, r, c, cnt);
		}else if(r < mid && c >= mid){ // 2
			solve(n-1, r, c-mid, cnt+mid*mid);
		}else if(r >= mid && c < mid){ // 3
			solve(n-1, r-mid, c, cnt+mid*mid*2);
		}else{ // 4
			solve(n-1, r-mid, c-mid, cnt+mid*mid*3);
		}
	}

	static String src = "2 3 1";
}