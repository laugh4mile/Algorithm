package com.codingtest.bro.naver;

import java.util.StringTokenizer;

public class Q2_2 {
	
//	public static String S = 
//			"Sun 10:00-20:00\r\n" + 
//					"Fri 05:00-10:00\r\n" + 
//					"Fri 16:30-23:50\r\n" + 
//					"Sat 10:00-24:00\r\n" + 
//					"Sun 01:00-04:00\r\n" + 
//					"Sat 02:00-06:00\r\n" + 
//					"Tue 03:30-18:15\r\n" + 
//					"Tue 19:00-20:00\r\n" + 
//					"Wed 04:25-15:14\r\n" + 
//					"Wed 15:14-22:40\r\n" + 
//					"Thu 00:00-23:59\r\n" + 
//					"Mon 05:00-13:00\r\n" + 
//					"Mon 15:00-21:00";
	
//	public static String S = 
//			"Mon 01:00-23:00\r\n" + 
//					"Tue 01:00-23:00\r\n" + 
//					"Wed 01:00-23:00\r\n" + 
//					"Thu 01:00-23:00\r\n" + 
//					"Fri 01:00-23:00\r\n" + 
//					"Sat 01:00-23:00\r\n" + 
//					"Sun 01:00-21:00";

	public static String S = 
			"Mon 00:01-24:00\r\n" + 
			"Tue 00:00-24:00\r\n" + 
			"Wed 00:00-24:00\r\n" + 
			"Thu 00:00-24:00\r\n" + 
			"Fri 00:00-24:00\r\n" + 
			"Sat 00:00-24:00\r\n" + 
			"Sun 00:00-24:00";
	
	public static void main(String[] args) {
		int answer = solution(S);
		System.out.println(answer);
	}
	
	public static int solution(String S) {
		int size = 10080;
		boolean schedule[] = new boolean[size]; // 7일 = 25200분
		StringTokenizer lines = new StringTokenizer(S,"\r\n");
		while(lines.hasMoreTokens()) {
			String cur = lines.nextToken();
			int day = getDay(cur.substring(0, 3));
			int startH = Integer.parseInt(cur.substring(4, 6));
			int startM = Integer.parseInt(cur.substring(7, 9));
			int endH = Integer.parseInt(cur.substring(10, 12));
			int endM = Integer.parseInt(cur.substring(13, 15));
			
			int meetingStart = day * 1440 + startH * 60 + startM; 
			int meetingEnd = day * 1440 + endH * 60 + endM;
			for(int i = meetingStart; i<meetingEnd; i++) {
				schedule[i] = true;
			}
			if(day == 6 && endH == 24) {
				schedule[size-1] = true;
			}
		}
		int max = 0;
		int sum = 0;
		for(int i=0; i<size; i++) {
			if(!schedule[i]) {
				sum++;
				max = Math.max(max, sum);
			}else {
				sum = 0;
			}
		}
		return max;
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
