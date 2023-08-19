package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D5_1245_균형점 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,	m[], w[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			m = new int[N];
			w = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for(int i=0; i<N; i++) {
				m[i] = Integer.parseInt(tokens.nextToken());
			}
			for(int i=0; i<N; i++) {
				w[i] = Integer.parseInt(tokens.nextToken());
			}
			
//			System.out.print(Arrays.toString(m)+ "   ");
//			System.out.println(Arrays.toString(w));
			
			for(int i=0; i<N-1; i++) {
				System.out.print(F(m[i], m[i+1], w[i], w[i+1])+"  ");
			}
			System.out.println();
		}
	}
	
	static double F (int x1, int x2, int m1, int m2) {
		int d = x2-x1;
		
		return (m1*m2)/(d*d);
	}
	
	static String src = 
			"10\r\n" + 
			"2\r\n" + 
			"1 2 1 1\r\n" + 
			"2\r\n" + 
			"1 2 1 1000\r\n" + 
			"2\r\n" + 
			"457 468 333 321\r\n" + 
			"3\r\n" + 
			"1 2 3 1 2 1\r\n" + 
			"4\r\n" + 
			"2 3 5 7 3 2 7 5\r\n" + 
			"5\r\n" + 
			"3 11 12 19 29 542 661 450 521 366	\r\n" + 
			"6\r\n" + 
			"42 75 88 94 113 144 669 551 355 344 294 155\r\n" + 
			"7\r\n" + 
			"62 86 279 323 363 516 579 810 749 736 297 136 107 52\r\n" + 
			"8\r\n" + 
			"10 34 64 73 93 97 101 122 466 463 441 373 315 292 225 83\r\n" + 
			"10\r\n" + 
			"9 14 38 39 48 73 179 190 207 302 560 497 640 722 437 259 449 470 709 520";
}
