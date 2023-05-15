package com.programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class L2_JadenCase문자열만들기 {
    public static String solution(String s) {
        boolean isFirstWord = true;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(isFirstWord){
                sb.append(Character.toUpperCase(s.charAt(i)));
                if(s.charAt(i) != ' '){
                    isFirstWord = false;
                }
            }else{
                if(s.charAt(i) == ' '){
                    isFirstWord = true;
                }
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution(" A4S 2aS a3S aa2Da asdfFDS"));
    }
}