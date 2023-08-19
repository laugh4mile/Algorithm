package com.programmers;

import java.util.*;

public class L2_시소짝궁 {
    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<weights.length; i++){
            if(map.get(weights[i]) == null){
                map.put(weights[i], 1);
            }else{
                map.replace(weights[i], map.get(weights[i])+1);
            }
        }

        for(int i=0; i<weights.length; i++){
            int w = weights[i];
            if(set.contains(w)){
               continue;
            }else{
                set.add(w);
            }
//            System.out.println(w);
            int n = map.get(w);
            if(n > 1){
                answer += (n * n-1) / 2;
            }
            if(map.get(w*2) != null){
                answer += n * map.get(w*2);
            }
            int d = w/2 * 3;
            if((double) w/2*3 == d){
                if(map.get(d) != null){
                    answer += n * map.get(d);
                }
            }

            d = w/3 * 4;
            if((double) w/3*4 == d){
                if(map.get(d) != null){
                    answer += n * map.get(d);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] weights = {100,180,360,100,270};
        System.out.println(solution(weights));
    }
}
