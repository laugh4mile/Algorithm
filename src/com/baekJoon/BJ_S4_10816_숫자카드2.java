package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S4_10816_숫자카드2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(map.get(num) == null) {
				map.put(num, 1);
			}else {
				map.replace(num, map.get(num)+1);
			}
		}
		M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		for(int m=0; m<M; m++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(map.get(num) == null) {
				output.append(0+" ");
			}else {
				output.append(map.get(num)+" ");
			}
		}
		output.close();
		
	}
	
	static String src =
			"10\r\n" + 
			"6 3 2 10 10 10 -10 -10 7 3\r\n" + 
			"8\r\n" + 
			"10 9 -5 2 3 4 5 -10";
}
