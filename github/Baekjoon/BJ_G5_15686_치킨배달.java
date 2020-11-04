package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_15686_치킨배달 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M, map[][],chickens,homes,ch[][],home[][],result[][],resultmin;
	static int chlen;

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		result = new int[M][2];
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
//		for(int x[] : map) {
//			System.out.println(Arrays.toString(x));
//		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 2) {
					chickens++;
				}
				if(map[r][c] == 1) {
					homes++;
				}
			}
		}
		ch = new int[chickens][2];
		home = new int[homes][2];
		int cnt = 0, cnt2 = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(map[r][c] == 2) {
					ch[cnt][0] = r;
					ch[cnt++][1] = c;
				}
				if(map[r][c] == 1) {
					home[cnt2][0] = r;
					home[cnt2++][1] = c;
				}
			}
		}
		resultmin = Integer.MAX_VALUE;
		combi(0,0);
		System.out.println(resultmin);
	}
	
	private static void combi(int start, int cnt) {
		
		if(cnt == M) {
//			for(int x[] : result) {
//				System.out.print(Arrays.toString(x));
//			}
//			System.out.println();
			int total = checkLen(result);
			if(total<resultmin) {
				resultmin = total;
			}
			return;
		}
		for(int i=start; i<chickens; i++) {
			result[cnt][0] = ch[i][0];
			result[cnt][1] = ch[i][1];
			combi(i+1, cnt+1);
		}
	}

	private static int checkLen(int[][] arr) {
		int len=0, min=Integer.MAX_VALUE, total=0;
		for(int i=0; i < home.length; i++) {
			min=Integer.MAX_VALUE;
			for(int j=0; j<arr.length; j++) {
				len = Math.abs(home[i][0] - result[j][0]) + Math.abs(home[i][1] - result[j][1]);
				if(len<min) {
					min = len;
				}
			}
			total += min;
		}
		return total;
	}

	static String src = "5 3\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 2 0 1\r\n" + 
			"0 1 2 0 0\r\n" + 
			"0 0 1 0 0\r\n" + 
			"0 0 0 0 2";

}
