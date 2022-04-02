package com.codingtest.devmatching.test2;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
	static String[] registered_list = {"card", "ace13", "ace16", "banker", "ace17", "ace14"}; 
	static String new_id = "ace1";
	public static void main(String[] args) {
		String answer = solution(registered_list, new_id);
		System.out.println(answer);
	}
	
	public static String solution(String[] registered_list, String new_id) {
		Map<String, Boolean> map = new HashMap<>();
		for(int i=0; i<registered_list.length; i++) {
			map.put(registered_list[i], true);
		}

		String answer = new_id;
        String S = new_id;
        String strN = "0";
        
        
        for(int i=0; i<new_id.length(); i++) {
        	if(Character.isDigit(new_id.charAt(i))) {
        		S = new_id.substring(0, i);
        		strN = new_id.substring(i,new_id.length());
        		break;
        	}
        }
        int N = Integer.parseInt(strN);
        
        if(map.get(new_id) == null) {
        	return new_id;
        }
        
        while(map.get(answer) != null) {
        	N += 1;
        	answer = S+N;
        }
        return answer;
    }
}
