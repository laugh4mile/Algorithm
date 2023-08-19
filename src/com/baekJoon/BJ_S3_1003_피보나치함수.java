package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class BJ_S3_1003_피보나치함수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static int zero,one, fibo[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		fibo = new int[41][2];
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		for(int i=2; i<=40; i++) {
			fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
		}
		
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(input.readLine());
			output.append(fibo[n][0] +" "+fibo[n][1]+"\n");
		}
		output.close();
	}	


	static String src =
			"3\r\n"
			+ "0\r\n"
			+ "1\r\n"
			+ "3";
}
