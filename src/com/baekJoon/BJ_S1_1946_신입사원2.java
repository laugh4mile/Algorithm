package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_1946_신입사원2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(input.readLine());
			int arr[] = new int[N+1];
			for(int i=0; i<N; i++) {
				tokens = new StringTokenizer(input.readLine());
				arr[Integer.parseInt(tokens.nextToken())] = Integer.parseInt(tokens.nextToken());
			}
			
			int answer = 0;
			int min = Integer.MAX_VALUE;
			for(int i=1; i<=N; i++) {
				if(arr[i] < min) {
					min = arr[i];
					answer++;
				}
			}
			output.append(answer+"\n");
		}
		output.close();
	}

	static String src =
			"2\r\n"
			+ "5\r\n"
			+ "3 2\r\n"
			+ "1 4\r\n"
			+ "4 1\r\n"
			+ "2 3\r\n"
			+ "5 5\r\n"
			+ "7\r\n"
			+ "3 6\r\n"
			+ "7 3\r\n"
			+ "4 2\r\n"
			+ "1 4\r\n"
			+ "5 7\r\n"
			+ "2 5\r\n"
			+ "6 1";
}
