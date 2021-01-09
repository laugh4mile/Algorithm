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

public class BJ_S2_18870_좌표압축 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N;
	static long arr[], copy[];
	static Map<Long, Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new long [N];
		copy = new long [N];
		tokens  = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			long num = Integer.parseInt(tokens.nextToken());
			arr[i] = num;
			copy[i] = num;
		}
		Arrays.sort(copy);
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(map.get(copy[i]) == null) {
				map.put(copy[i], cnt++);
			}
		}
		for(int i=0; i<N; i++) {
			output.append(map.get(arr[i])+" ");
		}
		output.close();
	}
	static String src =
			"6\r\n" + 
			"1000 999 1000 999 1000 999";
}
