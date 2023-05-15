package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_3258_컴포트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,Z,M,board[];
	static boolean obstacle[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		Z = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		obstacle = new boolean[N+1];
		tokens = new StringTokenizer(input.readLine());
		for(int m=0; m<M; m++) {
			obstacle[Integer.parseInt(tokens.nextToken())] = true;
		}
		System.out.println(solve());
	}

	private static int solve() {
		outer : for(int i=1; i<1000; i++) {
			int cur = 1;
			boolean isVisited[] = obstacle.clone();
			while(cur<1000) {
				if(cur == Z) {
					return i;
				}
				if(!isVisited[cur]) {
					isVisited[cur] = true;
				}else {
					break;
				}
				cur += i;
				if(cur>N) {
					cur = cur-N;
				}
			}
		}
		return -1;
	}

	static String src =

			"7 6 2\r\n" + 
			"2 4";
}
