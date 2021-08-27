package com.codingtest.mobis21;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
	static String[] a = {"abab","bbaa","bababa","bbbabababbbaa"};
	static Map<String, Boolean> map = new HashMap<>();
	public static void main(String[] args) {
		boolean[] answer = solution(a);
//		System.out.println(Arrays.toString(answer));
	}
	private static boolean[] solution(String[] a) {
		boolean[] answer = new boolean[500001];
		map.put("a", true);
//		fillMap("a",1);
		for(int i=0; i<a.length; i++) {
			if(map.get(a[i]) == null) {
				answer[i] = false;
			}else {
				answer[i] = true;
			}
		}
		return answer;
	}
	private static void fillMap(String str, int cnt) {
		if(str.length() > 500000) {
			return;
		}
		String bs = "";
		for(int i=0; i<cnt; i++) {
			bs= bs + "b";
		}
		String nextStr = bs+str+bs;
		if(map.get(nextStr) == null) {
			map.put(nextStr, true);
			fillMap(nextStr, cnt);
		}
		nextStr = "a"+str;
		if(map.get(nextStr) == null) {
			map.put(nextStr, true);
			fillMap(nextStr, cnt+1);
		}
		nextStr = str+"a";
		if(map.get(nextStr) == null) {
			map.put(nextStr, true);
			fillMap(nextStr, cnt+1);
		}
	}
}












