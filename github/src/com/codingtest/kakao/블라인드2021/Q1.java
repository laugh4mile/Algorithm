package com.codingtest.kakao.블라인드2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1 {
	static String[] id_list = {"muzi","frodo","apeach","neo"};
	static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
	static int k = 2;
	public static void main(String[] args) {
		int[] answer = solution(id_list, report, k);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Boolean> checkMap = new HashMap<>();
        Map<String, Integer> reportMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
        	answerMap.put(id_list[i], 0);
        }
        StringTokenizer tokens;
        for(int i=0; i<report.length; i++) {
        	if(checkMap.get(report[i]) == null) { // 해당 유저가 같은 사람을 신고 했는지 체크
        		checkMap.put(report[i], true); 
        		tokens = new StringTokenizer(report[i]);
        		String user = tokens.nextToken();
        		String rep = tokens.nextToken();
        		// 신고당한 유저의 신고수 갱신
        		if(reportMap.get(rep) == null) { 
        			reportMap.put(rep, 1);
        		}else{
        			reportMap.replace(rep, reportMap.get(rep)+1);
        		}
        	}
        }
        checkMap.clear();
        for(int i=0; i<report.length; i++) {
        	if(checkMap.get(report[i]) == null) { // 중복 검사
        		checkMap.put(report[i], true); 

        		tokens = new StringTokenizer(report[i]);
        		String user = tokens.nextToken();
        		String rep = tokens.nextToken();
        		
        		if(reportMap.get(rep) >= k) { 
        			answerMap.replace(user, answerMap.get(user)+1);
        		}
        	}
        }
        for(int i=0; i<id_list.length; i++) {
        	answer[i] = answerMap.get(id_list[i]);
        }
        
        return answer;
    }
}
