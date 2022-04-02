package com.codingtest.sk.street11;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
	static String S = "abaab";
	public static void main(String[] args) {
		System.out.println(solution(S));
	}
	public static int solution(String S) {
        char cur = S.charAt(0);
        int maxLen = 1;
        int len = 0;
        List<Integer> lenList = new ArrayList<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == cur){
                len++;
                if(maxLen < len){
                    maxLen = len;
                }
            }else{
                lenList.add(len);
                cur = S.charAt(i);
                len = 1;
            }
        }
        lenList.add(len);

        int answer = 0;
        for(int i=0; i<lenList.size(); i++){
            if(lenList.get(i) < maxLen){
                answer += maxLen-lenList.get(i);
            }
        }
        // System.out.println(lenList);
        return answer;
    }
}
