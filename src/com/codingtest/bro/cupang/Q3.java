package com.codingtest.bro.cupang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q3 {
	public static void main(String[] args) {
//		int n = 1;
//		String[] record = {
//				"1 fracta",
//				"1 sina",
//				"1 hana",
//				"1 robel",
//				"1 abc",
//				"1 sina",
//		"1 lynn"};
		int n = 4;
		String[] record = {
				"1 a",
				"1 b",
				"1 abc",
				"3 b",
				"3 a",
				"1 abcd",
				"1 abc",
				"1 aaa",
				"1 a",
				"1 z",
				"1 q",
				"3 k",
				"3 q",
				"3 z",
				"3 m",
				"3 b"
				};

		String answer[] = {};
		answer = solution(n, record);
		
	}
	private static String[] solution(int n, String[] record) {
		String answer[] = {};
		
		StringTokenizer tokens;
		Map<String, Boolean> map[] = new Map[n+1];
		Queue<String> queue[] = new Queue[n+1];
		
		for(int i=1; i<n+1; i++) {
			map[i] = new HashMap<>();
			queue[i] = new LinkedList<>();
		}
		
		for(int i=0; i<record.length; i++) {
			tokens = new StringTokenizer(record[i]);
			int server = Integer.parseInt(tokens.nextToken());
			String nickName = tokens.nextToken();
			
			if(map[server].get(nickName) == null) {
				map[server].put(nickName, true);
				queue[server].offer(nickName);
				if(queue[server].size() > 5) {
					map[server].remove(queue[server].poll());
				}
			}
		}
		int sum = 0;
		for(int i=1; i<n+1; i++) {
			sum += queue[i].size();
		}
		answer = new String[sum];
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			while(!queue[i].isEmpty()) {
				answer[cnt++] = queue[i].poll();
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
