package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S5_14467_소가길을건너간이유1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		int answer = 0;
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int cow = Integer.parseInt(tokens.nextToken());
			int position = Integer.parseInt(tokens.nextToken());
			if(map.get(cow) == null) {
				map.put(cow, position);
			}else {
				if(map.get(cow) != position) {
					answer++;
					map.put(cow, position);
				}
			}
		}
		System.out.println(answer);
	}

	static String src =
			"8\r\n" + 
			"3 1\r\n" + 
			"3 0\r\n" + 
			"6 0\r\n" + 
			"2 1\r\n" + 
			"4 1\r\n" + 
			"3 0\r\n" + 
			"4 0\r\n" + 
			"3 1";
}
