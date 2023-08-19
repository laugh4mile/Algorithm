package com.codingtest.bro.naver.financial;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1 {
	static String[] id_list = {"A B C D","A D","A B D","B D"};
	static int k = 2;
//	static String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
//	static int k = 3;
	public static void main(String[] args) {
		int answer = solution(id_list, k);
		System.out.println(answer);
	}
	
	public static int solution(String[] id_list, int k) {
		int answer = 0;
		Map<String, Integer> map = new HashMap<>();
		StringTokenizer tokens;
		for(int i=0; i<id_list.length; i++) {
			Map<String, Boolean> isVisited = new HashMap<>();
			tokens = new StringTokenizer(id_list[i]);
			while(tokens.hasMoreTokens()) {
				String id = tokens.nextToken();
				if(map.get(id) == null) {
					map.put(id, 1);
					isVisited.put(id, true);
					answer++;
				}else {
					if(isVisited.get(id) == null && map.get(id) < k) {
						map.replace(id, map.get(id)+1);
						isVisited.put(id, true);
						answer++;
					}
				}
			}
		}
		return answer;
	}
}
