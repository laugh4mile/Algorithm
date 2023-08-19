package com.programmers;

import java.util.*;

class L2_압축 {
    public static int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        char c = '0';
        int cnt = 1;
        for(int i=0; i<26; i++){
            map.put(Character.toString((char)('A'+i)), cnt++);
        }
        msg = msg+"a";
        String subStr = "";
        for(int i=0; i<msg.length(); i++){
            int jump = 0;
            if(msg.charAt(i) == 'a') break;
            for(int j=1; j<msg.length()-i+1; j++){
                subStr = msg.substring(i,i+j);
                if(map.get(subStr)==null){
                    map.put(subStr,cnt++);
                    break;
                }else{
                    jump++;
                }
            }
            if(subStr.length() == 1){
                list.add(map.get(subStr.charAt(0)+""));
            }else{
                list.add(map.get(subStr.substring(0,subStr.length()-1)));
            }
            i+=jump-1;
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