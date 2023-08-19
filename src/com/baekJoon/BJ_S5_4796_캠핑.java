package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_4796_캠핑 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new StringReader(src));
		StringTokenizer tokens;
		int t = 1;
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			int L = Integer.parseInt(tokens.nextToken());
			int P = Integer.parseInt(tokens.nextToken());
			int V = Integer.parseInt(tokens.nextToken());
			if(L == 0) {
				break;
			}
			int answer = 0;
			answer += V/P*L;
			if(V%P > L) {
				answer += L;
			}else {
				answer += V%P;
			}
			output.append("Case "+ t++ +": "+answer+"\n");
		}
		output.close();
	}
	
	static String src = 
			"5 8 20\r\n" + 
			"5 8 17\r\n" + 
			"0 0 0";
}
