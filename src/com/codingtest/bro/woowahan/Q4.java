package com.codingtest.bro.woowahan;

import java.util.HashMap;
import java.util.Map;

public class Q4 {
//	static String[] before = {"A","B","C"};
//	static String[] after = {"B","C","A"};
//	static String[] before = {"A","B","C"};
//	static String[] after = {"D","E","C"};
//	static String[] before = {"A","B","C","D"};
//	static String[] after = {"B","Z","D","C"};
	static String[] before = {"A","B","C","D"};
	static String[] after = {"A","E","D","C"};
	public static void main(String[] args) {
		int answer = solution(before, after);
		System.out.println(answer);
	}
	private static int solution(String[] before, String[] after) {
		int answer = 0;
		Map<String, Boolean> map = new HashMap<>();
		
		for(int i=0; i<before.length; i++) {
			map.put(before[i], true);
		}
		int cnt = 0; // 서로 겹치는 문자열의 수
		for(int i=0; i<after.length; i++) {
			if(!before[i].equals(after[i])) {
				if(map.get(after[i]) == null) {
					answer++;
				}else {
					cnt++;
				}
			}
		}
		if(cnt>0) {
			answer += cnt+1;
		}
		
		return answer;
	}
}
