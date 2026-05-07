package com.programmers;

import java.util.HashMap;
import java.util.Map;

public class L2_의상 {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String c = clothes[i][0];
            String k = clothes[i][1];

            if(map.get(k) == null){
                map.put(k, 1);
            }else{
                map.put(k, map.get(k) + 1);
            }
        }

        answer = 1;
        for(int v : map.values()){
            answer *= v+1;
        }

        return answer-1;
    }
}
