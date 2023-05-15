package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_9333_돈갚기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer tokens = new StringTokenizer (input.readLine());
			double R = Double.parseDouble(tokens.nextToken()); // 월 이자
			double B = Double.parseDouble(tokens.nextToken()); // 빌린 돈
			double M = Double.parseDouble(tokens.nextToken()); // 월급
			
			double eja = 0;
			int cnt = 0;
			while(true) {
				cnt++;
				eja = Double.parseDouble(String.format("%.2f", B*R/100));
				B = B + eja - M;
				if(B <= 0) {
					System.out.println(cnt);
					break;
				}
				if(cnt>=1200) {
					System.out.println("impossible");
					break;
				}
			}
		}
	}

	static String src =
			"11\r\n"
			+ "2.00 100.00 105.00\r\n"
			+ "2.00 100.00 102.00\r\n"
			+ "2.00 100.00 100.00\r\n"
			+ "2.00 100.00 4.00\r\n"
			+ "2.00 100.00 3.00\r\n"
			+ "2.00 100.00 1.00\r\n"
			+ "2.00 100.00 2.00\r\n"
			+ "9.56 5462.50 522.22\r\n"
			+ "12.50 29876.44 33610.99\r\n"
			+ "5.50 1.00 1.05\r\n"
			+ "14.78 40181.09 46119.86";
}
