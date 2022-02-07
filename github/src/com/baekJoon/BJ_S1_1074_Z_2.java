package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1074_Z_2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, r, c, cnt,newN;
	static int map[][];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		c = Integer.parseInt(tokens.nextToken());
		
		int len = (int) Math.pow(2, N);
		zmove(len,0,0,len-1,len-1);
	}
	
	private static void zmove(int n, int sr, int sc, int er, int ec) {
		int newN = n/2;
		if(newN != 0) {
			zmove(newN, sr, sc, sr+newN, sc+newN);
			zmove(newN, sr, sc+newN, sr+newN, sc+newN+newN);
			zmove(newN, sr+newN, sc, sr+newN+newN, sc+newN);
			zmove(newN, sr+newN, sc+newN, sr+newN+newN, sc+newN+newN);
		}else {
			if(sr == r && sc == c) {
				System.out.println(cnt);
			}
			cnt++;
		}
	}
	static String src = "15 512 512";
}