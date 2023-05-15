package com.codingtest.naver;

import java.util.Random;

public class Task2 {
	static public String solution(String riddle) {
		//String riddle = "???????";
		StringBuilder  sb = new StringBuilder();
	      Random r = new Random();
	      
	      for (int i = 0; i < riddle.length(); i++) {
	         if (riddle.charAt(i) == '?') {
	            if (i == 0) sb.append((char)(r.nextInt(26) + 'a'));
	            else if (i == 1) sb.append((char)(((sb.charAt(i - 1) - 'a')  + 15) % 26 + 'a'));
	            else sb.append(sb.charAt(i - 2));
	         } else sb.append(riddle.charAt(i));
	      }
	      
	      System.out.println(sb.toString());

		return null;
	}
	public static void main(String[] args) {
		solution("??a??a?");
	}
}
