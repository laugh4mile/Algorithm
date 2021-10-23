package com.codingtest.bro.naver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Q2 {
	
	public static String S = 
			"Sun 10:00-20:00\r\n" + 
			"Fri 05:00-10:00\r\n" + 
			"Fri 16:30-23:50\r\n" + 
			"Sat 10:00-24:00\r\n" + 
			"Sun 01:00-04:00\r\n" + 
			"Sat 02:00-06:00\r\n" + 
			"Tue 03:30-18:15\r\n" + 
			"Tue 19:00-20:00\r\n" + 
			"Wed 04:25-15:14\r\n" + 
			"Wed 15:14-22:40\r\n" + 
			"Thu 00:00-23:59\r\n" + 
			"Mon 05:00-13:00\r\n" + 
			"Mon 15:00-21:00";
	
	public static void main(String[] args) {
		int answer = solution(S);
		System.out.println(answer);
	}
	
	public static int solution(String S) {
		int answer = 0;
		boolean schedule[] = new boolean[25200]; // 7일 = 25200분
		StringTokenizer lines = new StringTokenizer(S,"\r\n");
		while(lines.hasMoreTokens()) {
			String cur = lines.nextToken();
			int day = getDay(cur.substring(0, 3));
			String startH = cur.substring(4, 6);
			String startM = cur.substring(7, 9);
			String endH = cur.substring(10, 12);
			String endM = cur.substring(13, 15);
			int hour = Integer.parseInt(endH) - Integer.parseInt(startH);		
			int minute = Integer.parseInt(endM) - Integer.parseInt(startM);
			
			
		}
		return answer;
	}
	
	private static int getDay(String str) {
		int day = -1;
		switch (str) {
		case "Mon":
			day = 0;
			break;
		case "Tue":
			day = 1;
			break;
		case "Wed":
			day = 2;
			break;
		case "Thu":
			day = 3;
			break;
		case "Fri":
			day = 4;
			break;
		case "Sat":
			day = 5;
			break;
		case "Sun":
			day = 6;
			break;
		}
		return day;
	}
}
