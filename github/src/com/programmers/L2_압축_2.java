package com.programmers;

import java.util.*;

class L2_압축_2 {
    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        char c = '0';
        int cnt = 1;
        for(int i=0; i<26; i++){
            map.put(Character.toString((char)('A'+i)), cnt++);
        }

        for(int i=0; i<msg.length(); i++){
            String subStr = "";
            for(int j=1; j<msg.length()-i+1; j++){
                if(map.get(msg.substring(i,i+j)) == null){
                    map.put(msg.substring(i,i+j), cnt++);
                    break;
                }else{
                    subStr = msg.substring(i,i+j);
                }
            }
            i += subStr.length()-1;
            list.add(map.get(subStr));
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(solution(msg)));
    }
}