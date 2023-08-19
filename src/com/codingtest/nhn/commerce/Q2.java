package com.codingtest.nhn.commerce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());

			Map<String, Boolean> map = new HashMap<>();
			tokens = new StringTokenizer(input.readLine());
			int cnt = 0;
			int answer = -1;
			for(int n=1; n<=N; n++) {
				String phoneNumber = tokens.nextToken();
				if(map.get(phoneNumber) == null) {
					map.put(phoneNumber, true);
					cnt++;
					answer = n;
					if(cnt == M) {
						break;
					}
				}
			}
			output.append(answer+"\n");
		}
		output.close();
	}

	static String src =
			"2\r\n" + 
			"10 3\r\n" + 
			"123123123 234234234 234234234 123123123 345345345 123456789 987654321 123789456 456123789 987987789\r\n" + 
			"5 4\r\n" + 
			"123123123 456456456 789789789 789789789 789789781";
}
