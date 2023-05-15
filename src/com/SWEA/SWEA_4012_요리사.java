package com.SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T,N,map[][],result[],result2[],min=Integer.MAX_VALUE,mat1,mat2;
	static boolean isUsed;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			map = new int [N][N];
			result = new int[N/2];
			result2 = new int[N/2];
			for(int r=0; r<N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
				}	
			}
			
//			for(int x[] : map) {
//				System.out.println(Arrays.toString(x));
//			}
			
			combi(0,0);
//			System.out.printf("#%d %d\n",t,min);
			output.write("#"+ t + " "+min+"\n");
			min = Integer.MAX_VALUE;
		}
		output.close();
	}
	private static void combi(int cnt, int start) {
		if(cnt == N/2) {
			for(int i=0; i<result.length-1; i++) {
				for(int j=i+1; j<result.length; j++) {
					mat1 += map[result[i]][result[j]] + map[result[j]][result[i]] ; 
				}
			}
			
//			System.out.println(Arrays.toString(result));
//			System.out.println();
			combi2(0,0);
//			System.out.println("-------------------------------");
			mat1 = 0;
			return;
		}
		for(int i=start; i<N; i++) {
			result[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	private static void combi2(int cnt, int start) {
		if(cnt == N/2) {
			for(int i=0; i<result2.length-1; i++) {
				for(int j=i+1; j<result2.length; j++) {
					mat2 += map[result2[i]][result2[j]] + map[result2[j]][result2[i]] ;
					if(Math.abs(mat1-mat2) < min) {
						min = Math.abs(mat1-mat2);
					}
				}
			}
//			System.out.println(Arrays.toString(result2));
//			mat2 = map[result2[0]][result2[1]] + map[result2[1]][result2[0]];
//			System.out.println(mat1 + " : " + mat2);
//			System.out.println();
			if(Math.abs(mat1-mat2) < min) {
				min = Math.abs(mat1-mat2);
			}
			mat2 = 0;
			return;
		}
		for(int i=start; i<N; i++) {
			for(int j=0; j<result.length; j++) {
				if(i==result[j]) {
					isUsed = true;
				}
			}
			if(!isUsed) {
				result2[cnt] = i;
				combi2(cnt+1, i+1);
			}
			isUsed = false;
		}
	}
	static String src =
			"5\r\n" + 
			"4\r\n" + 
			"0 5 3 8\r\n" + 
			"4 0 4 1\r\n" + 
			"2 5 0 3\r\n" + 
			"7 2 3 0\r\n" + 
			"4\r\n" + 
			"0 7 1 1\r\n" + 
			"7 0 6 2\r\n" + 
			"1 1 0 2\r\n" + 
			"10 1 9 0\r\n" + 
			"6\r\n" + 
			"0 37 26 52 77 20\r\n" + 
			"32 0 15 26 75 16\r\n" + 
			"54 33 0 79 37 90\r\n" + 
			"92 10 66 0 92 3\r\n" + 
			"64 7 89 89 0 21\r\n" + 
			"80 49 94 68 5 0\r\n" + 
			"6\r\n" + 
			"0 73 30 81 27 94\r\n" + 
			"98 0 91 9 97 24\r\n" + 
			"51 100 0 35 41 98\r\n" + 
			"26 26 96 0 26 90\r\n" + 
			"73 37 39 57 0 16\r\n" + 
			"90 88 97 9 95 0\r\n" + 
			"8\r\n" + 
			"0 410 87 281 463 41 192 191\r\n" + 
			"65 0 93 26 402 367 22 222\r\n" + 
			"90 408 0 108 179 457 248 369\r\n" + 
			"151 466 13 0 189 426 405 376\r\n" + 
			"219 207 351 256 0 361 73 207\r\n" + 
			"381 453 11 113 165 0 164 499\r\n" + 
			"121 325 328 428 459 386 0 146\r\n" + 
			"286 98 334 430 230 263 252 0\r\n";
			
}
