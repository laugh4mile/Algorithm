package com.codingtest.codechallenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Q2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int cnt, answer1, answer2;
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		String s = 	input.readLine();
		int[] answer = {};

		String temp = "";
		while(!s.equals("1")) {
			System.out.println(s);
			s = removeZero(s);
			System.out.println(s);
			
			s = makeBinary(s);
			cnt++;
			
		}
	}
	
	private static String makeBinary(String s) {
		int oCnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 1) {
				oCnt++;
			}
		}
		
		String temp = "";
		for(int i=oCnt; oCnt>0; oCnt/=2) {
			temp = String.valueOf(i%2) + temp;
		}
		

		return temp;
	}

	private static String removeZero(String s) {
		int zCnt = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '0') {
				zCnt++;
			}
		}
		answer1 += zCnt;
		int oCnt = s.length() - zCnt;
		String rs = "";
		for(int i=0; i<oCnt; i++) {
			rs.concat("1");
		}
		return rs;
	}

	static String src = 
			"110010101001";
	
	
	
	class Solution {
	    public int[] solution(String s) {
	        int[] answer = {};
	        return answer;
	    }
	}
}
