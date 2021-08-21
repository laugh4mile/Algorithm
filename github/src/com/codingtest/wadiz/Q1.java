package com.codingtest.wadiz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1 {
	static int[][] passwords = {{101,1234},{102,54321},{201,202},{202,1}};
	static String s = "101#1234#102#654321#51#203#201#202#1#";
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = solution(passwords, s);
		System.out.println(answer);
		
	}

	private static int solution(int[][] passwords, String s) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<passwords.length; i++) {
			map.put(passwords[i][0], passwords[i][1]);
		}
		StringTokenizer tokens = new StringTokenizer(s,"#");
		while(tokens.hasMoreTokens()) {
			int hosu = Integer.parseInt(tokens.nextToken());
			if(map.get(hosu) == null) continue;
			if(!tokens.hasMoreTokens()) continue;
			int pw = Integer.parseInt(tokens.nextToken());
			if(map.get(hosu) != pw) continue;
			
			answer++;
		}
		return answer;
	}
}
