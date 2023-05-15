package com.programmers;

import java.util.*;

public class PCCP_모의고사1_1 {
    public static String solution(String input_string) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<input_string.length(); i++){
            if(map.get(input_string.charAt(i))==null){
                map.put(input_string.charAt(i),1);
            }else{
                map.replace(input_string.charAt(i),map.get(input_string.charAt(i))+1);
                if(input_string.charAt(i-1) != input_string.charAt(i)){
                    set.add(input_string.charAt(i));
                }
            }
        }
        if(set.isEmpty()){
            return "N";
        }

        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            answer += list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("edeaaabbccd"));
        System.out.println(solution("eeddee"));
        System.out.println(solution("string"));
        System.out.println(solution("zbzbz"));
    }
}
