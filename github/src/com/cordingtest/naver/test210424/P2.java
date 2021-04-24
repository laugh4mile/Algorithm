package com.cordingtest.naver.test210424;

import java.util.HashMap;
import java.util.Map;

public class P2 {
	static String sentence = "i love coding";
	static String keyword = "mode";
	static int skips[] = {0,0,3,2,3,4};
	public static String solution(String sentence, String keyword, int[] skips) {
		String answer = "";
		int curIndex = 0;
		int curKeywordIndex = 0;
		int curSkips = 0;
		int cnt = 0;
		
		StringBuilder sb = new StringBuilder();
		
		Map<Integer, Character> map = new HashMap<>();
		
		outer:for(int i=0; i<skips.length; i++) {
			for(int j=curIndex; j<curIndex+skips[i]; j++) {
				if(j>=sentence.length()) {
					break outer;
				}
				if(sentence.charAt(i) == keyword.charAt(curKeywordIndex)) {
					curIndex = j;
					map.put(curIndex + cnt, keyword.charAt(curKeywordIndex));
					curKeywordIndex = (curKeywordIndex+1) % keyword.length();
					cnt++;
					break;
				}
			}
			curIndex = curIndex + skips[i];
			map.put(curIndex + cnt, keyword.charAt(curKeywordIndex));
			curKeywordIndex = (curKeywordIndex+1) % keyword.length();
			cnt++;
		}
		System.out.println(map);
		return answer;
	}
	
	public static void main(String[] args) {
		solution(sentence, keyword, skips);
	}
}
