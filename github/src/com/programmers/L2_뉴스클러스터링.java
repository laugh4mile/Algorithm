package com.programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class L2_뉴스클러스터링 {
    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=0;i<str1.length()-1; i++){
            String sub = str1.substring(i,i+2);
            if(!Character.isAlphabetic(sub.charAt(0)) || !Character.isAlphabetic(sub.charAt(1))) continue;
            if(map1.get(sub) == null){
                map1.put(sub, 1);
            }else{
                map1.replace(sub, map1.get(sub)+1);
            }
        }
        for(int i=0;i<str2.length()-1; i++){
            String sub = str2.substring(i,i+2);
            if(!Character.isAlphabetic(sub.charAt(0)) || !Character.isAlphabetic(sub.charAt(1))) continue;
            if(map2.get(sub) == null){
                map2.put(sub, 1);
            }else{
                map2.replace(sub, map2.get(sub)+1);
            }
        }

        double hap = 0;
        double gyo = 0;

        for (String s : map1.keySet()) {
            if(map2.get(s) == null){
                hap += map1.get(s);
            }else{
                hap += Math.max(map1.get(s), map2.get(s));
                gyo += Math.min(map1.get(s), map2.get(s));
            }
        }
        for (String s : map2.keySet()) {
            if(map1.get(s) == null){
                hap += map2.get(s);
            }
        }
        double j = gyo / hap * 65536;
//        System.out.println(str1+" "+str2);
//        System.out.println(gyo+" "+hap+" "+j);
        answer = (int) j;
        if(hap == 0){
            answer = 65536;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aa1+aa2","AAAA12"));
    }
}