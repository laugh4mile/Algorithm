package com.codingtest.woowa.test2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q4 {
	static String s = "aaabbaaa";
	public static void main(String[] args) {
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(String s) {
        int[] answer;
        List<Integer> list = new ArrayList<>(); // 연속되는 알파벳의 수를 저장
        
        char front = s.charAt(0);
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) != front) {
        		front = s.charAt(i);
        		list.add(sum);
        		sum = 1;
        	}else {
        		sum++;
        	}
        }
        list.add(sum); // 마지막 남은 값은 직접 넣어줘야함.
        
        if(s.charAt(0) == s.charAt(s.length()-1)) { // 첫글자와 마지막 글자가 같으면 합친다.
        	int temp = list.get(0) + list.get(list.size()-1);
        	list.remove(0);
        	list.remove(list.size()-1);
        	list.add(temp);
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
